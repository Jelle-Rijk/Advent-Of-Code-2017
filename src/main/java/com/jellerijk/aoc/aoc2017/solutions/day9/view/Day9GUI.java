package com.jellerijk.aoc.aoc2017.solutions.day9.view;

import com.jellerijk.aoc.aoc2017.common.gui.input.textarea.LiveInput;

import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;

public class Day9GUI extends BorderPane {
	public Day9GUI() {
		buildGUI();
	}

	private void buildGUI() {
		LiveInput input = new LiveInput();
		
		input.setOnAction(evt -> {
			output.setText(input.getInput());
		});

		setLeft(input);
		setRight(output);
	}
}
