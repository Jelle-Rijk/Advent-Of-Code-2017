package com.jellerijk.aoc.aoc2017.solutions.day3.gui;

import com.jellerijk.aoc.aoc2017.common.gui.input.textfield.TextFieldSubmitButton;
import com.jellerijk.aoc.aoc2017.common.gui.output.labels.ErrorLabel;
import com.jellerijk.aoc.aoc2017.common.observer.Subscriber;

import javafx.scene.layout.HBox;

public class Day3GUI extends HBox implements Subscriber {

	public Day3GUI() {
		buildGUI();
	}

	private void buildGUI() {
		TextFieldSubmitButton inputField = new TextFieldSubmitButton();
		inputField.setSubmit(evt -> submit(inputField));

		getChildren().addAll(inputField);
	}

	private void submit(TextFieldSubmitButton inputField) {
		String input = inputField.getInput();
		ErrorLabel err = inputField.getErrorLabel();
		err.setText(input);
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub

	}

}
