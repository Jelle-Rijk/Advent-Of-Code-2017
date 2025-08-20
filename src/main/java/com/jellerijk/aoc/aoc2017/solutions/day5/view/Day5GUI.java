package com.jellerijk.aoc.aoc2017.solutions.day5.view;

import com.jellerijk.aoc.aoc2017.common.gui.input.textarea.TextAreaWithButton;
import com.jellerijk.aoc.aoc2017.common.gui.output.labels.ErrorLabel;
import com.jellerijk.aoc.aoc2017.common.observer.Subscriber;
import com.jellerijk.aoc.aoc2017.solutions.day5.model.CPUController;

import javafx.geometry.Insets;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class Day5GUI extends HBox implements Subscriber {
	private final CPUController controller;

	private TextField stepsToEscape;
	private CheckBox strangeJumps;

	public Day5GUI() {
		controller = CPUController.getInstance();
		controller.subscribe(this);
		buildGUI();
	}

	private void buildGUI() {
		TextAreaWithButton textInput = new TextAreaWithButton();
		textInput.setOnAction(evt -> submit(textInput.getInput(), textInput.getErrorLabel()));
		textInput.getSubmitButton().setText("RUN INSTRUCTIONS");
		strangeJumps = new CheckBox("Enable strange jumps");
		VBox inputPanel = new VBox(textInput, strangeJumps);

		Label lblCycles = new Label("CPU cycles before HALT");
		stepsToEscape = new TextField();
		stepsToEscape.setEditable(false);
		VBox outputPanel = new VBox(lblCycles, stepsToEscape);
		outputPanel.setPadding(new Insets(5));

		getChildren().addAll(inputPanel, outputPanel);
	}

	private void submit(String input, ErrorLabel err) {
		try {
			controller.createInstruction(input, strangeJumps.isSelected());
		} catch (Exception e) {
			err.setText(String.format("%s: %s", e.getClass().getSimpleName(), e.getMessage()));
			e.printStackTrace();
		}
	}

	@Override
	public void update() {
		stepsToEscape.setText(Integer.toString(controller.getCPUCycles()));
	}

}
