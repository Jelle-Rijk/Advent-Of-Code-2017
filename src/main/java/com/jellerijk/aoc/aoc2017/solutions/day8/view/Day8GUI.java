package com.jellerijk.aoc.aoc2017.solutions.day8.view;

import com.jellerijk.aoc.aoc2017.common.gui.input.textarea.TextAreaWithButton;
import com.jellerijk.aoc.aoc2017.solutions.day8.controllers.CPUController;

import javafx.scene.layout.BorderPane;

public class Day8GUI extends BorderPane {

	public Day8GUI() {
		buildGUI();
	}

	private void buildGUI() {
		TextAreaWithButton input = new TextAreaWithButton();
		input.setButtonText("RUN PROGRAM");
		input.setOnAction(evt -> run(input));
		RegisterListView registerView = new RegisterListView();
		TopBar details = new TopBar();

		setTop(details);
		setLeft(input);
		setRight(registerView);
	}

	private void run(TextAreaWithButton input) {
		input.getErrorLabel().clear();
		try {
			CPUController.getInstance().runProgram(input.getInput());
		} catch (IllegalArgumentException iae) {
			input.getErrorLabel().setText(String.format("%s: %s", iae.getClass().getSimpleName(), iae.getMessage()));
		}
	}

}
