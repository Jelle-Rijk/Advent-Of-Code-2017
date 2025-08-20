package com.jellerijk.aoc.aoc2017.solutions.day1.gui;

import com.jellerijk.aoc.aoc2017.common.gui.input.textarea.TextAreaWithButton;
import com.jellerijk.aoc.aoc2017.common.gui.output.labels.ErrorLabel;
import com.jellerijk.aoc.aoc2017.common.observer.Subscriber;
import com.jellerijk.aoc.aoc2017.solutions.day1.domain.CaptchaController;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class Day1GUI extends HBox implements Subscriber {

	private CaptchaController controller;

	public static final double PREF_WIDTH = 800;
	public static final double PREF_HEIGHT = 300;

	private TextField txfPartOne;
	private TextField txfPartTwo;

	public Day1GUI() {
		this.controller = CaptchaController.getInstance();
		controller.subscribe(this);
		buildGUI();
	}

	private void buildGUI() {
		VBox inputPanel = buildInputPanel();
		VBox outputPanel = buildOutputPanel();

		getChildren().addAll(inputPanel, outputPanel);
		setSpacing(20);
		setPadding(new Insets(10));
	}

	private VBox buildInputPanel() {
		TextAreaWithButton txaInput = new TextAreaWithButton();
		txaInput.setMaxWidth(300);
		txaInput.getTextArea().setWrapText(true);
		txaInput.getSubmitButton().setOnAction(evt -> submit(txaInput));

		return txaInput;
	}

	private void submit(TextAreaWithButton inputComponent) {
		ErrorLabel errLabel = inputComponent.getErrorLabel();
		errLabel.setText("");
		String input = inputComponent.getInput();
		try {
			controller.submitInput(input);
		} catch (Exception e) {
			errLabel.setText(e.getMessage());
		}

	}

	private VBox buildOutputPanel() {
		Label lblPartOne = new Label("Sum of doubles");
		Label lblPartTwo = new Label("Sum of opposites");

		txfPartOne = new TextField();
		txfPartTwo = new TextField();

		for (TextField txf : new TextField[] { txfPartOne, txfPartTwo }) {
			txf.setEditable(false);
			txf.getStyleClass().add("terminal");
			txf.setPadding(new Insets(0, 0, 10, 0));
		}

		VBox outputPanel = new VBox(lblPartOne, txfPartOne, lblPartTwo, txfPartTwo);
		outputPanel.setSpacing(5);
		return outputPanel;
	}

	@Override
	public void update() {
		txfPartOne.setText(Long.toString(controller.getSumOfDoubles()));
		txfPartTwo.setText(Long.toString(controller.getSumOfOpposites()));
	}
}
