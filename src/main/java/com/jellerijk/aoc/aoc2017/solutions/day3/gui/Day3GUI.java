package com.jellerijk.aoc.aoc2017.solutions.day3.gui;

import com.jellerijk.aoc.aoc2017.common.gui.input.textfield.TextFieldSubmitButton;
import com.jellerijk.aoc.aoc2017.common.gui.output.labels.ErrorLabel;
import com.jellerijk.aoc.aoc2017.common.observer.Subscriber;
import com.jellerijk.aoc.aoc2017.solutions.day3.domain.SpiralMemoryController;

import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class Day3GUI extends HBox implements Subscriber {
	private SpiralMemoryController controller;
	TextField manhattanDistance;
	TextField smallestLargerInput;

	public Day3GUI() {
		controller = SpiralMemoryController.getInstance();
		controller.subscribe(this);
		buildGUI();
	}

	private void buildGUI() {
		setPrefSize(400, 150);
		TextFieldSubmitButton inputField = new TextFieldSubmitButton();
		inputField.setSubmit(evt -> submit(inputField));

		VBox outputPanel = buildOutput();

		getChildren().addAll(inputField, outputPanel);
	}

	private VBox buildOutput() {
		Label lblManhattan = new Label("Manhattan Distance");
		manhattanDistance = new TextField();
		Label lblSmallestLargerNumber = new Label("Smallest Larger Number");
		smallestLargerInput = new TextField();

		return new VBox(lblManhattan, manhattanDistance, lblSmallestLargerNumber, smallestLargerInput);

	}

	private void submit(TextFieldSubmitButton inputField) {
		String input = inputField.getInput();
		ErrorLabel err = inputField.getErrorLabel();
		err.clear();
		try {
			controller.inputGoal(input);
		} catch (Exception e) {
			err.setText(e.getMessage());
		}
	}

	@Override
	public void update() {
		try {
			manhattanDistance.setText(Integer.toString(controller.getManhattanDistance()));
			smallestLargerInput.setText(Integer.toString(controller.getSmallestLargerNumber()));
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
