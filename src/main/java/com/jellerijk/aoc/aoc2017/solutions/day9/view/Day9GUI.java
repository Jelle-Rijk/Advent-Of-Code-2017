package com.jellerijk.aoc.aoc2017.solutions.day9.view;

import com.jellerijk.aoc.aoc2017.common.gui.input.textarea.LiveInput;
import com.jellerijk.aoc.aoc2017.solutions.day9.controller.StreamAnalysisController;

import javafx.scene.layout.BorderPane;

public class Day9GUI extends BorderPane {
	public Day9GUI() {
		buildGUI();
	}

	private void buildGUI() {
		LiveInput input = new LiveInput();
		OutputPanel output = new OutputPanel();

		StreamAnalysisController controller = StreamAnalysisController.getInstance();
		input.setOnAction(evt -> {
			controller.setStream(input.getInput());
		});

		setLeft(input);
		setRight(output);
	}
}
