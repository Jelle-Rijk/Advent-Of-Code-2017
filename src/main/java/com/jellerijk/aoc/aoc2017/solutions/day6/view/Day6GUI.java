package com.jellerijk.aoc.aoc2017.solutions.day6.view;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.jellerijk.aoc.aoc2017.common.gui.input.textarea.TextAreaWithButton;
import com.jellerijk.aoc.aoc2017.common.observer.Subscriber;
import com.jellerijk.aoc.aoc2017.solutions.day6.controllers.MemoryController;
import com.jellerijk.aoc.aoc2017.solutions.day6.model.Duplicate;

import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class Day6GUI extends HBox implements Subscriber {

	private final MemoryController controller;

	private VBox duplicateResults;

	public Day6GUI() {
		this.controller = MemoryController.getInstance();
		buildGUI();

	}

	private void buildGUI() {
		TextAreaWithButton input = new TextAreaWithButton();
		input.getSubmitButton().setOnAction(evt -> submitPuzzleInput(input));

		VBox output = new VBox();
		output.setMinWidth(600);
		Label lblDuplicate = new Label("Results");
		lblDuplicate.setStyle("-fx-font-size: 18px; -fx-font-weight: bold");
		duplicateResults = new VBox();

		output.getChildren().addAll(lblDuplicate, duplicateResults);

		getChildren().addAll(input, output);
	}

	@Override
	public void update() {
		showFirstDuplicate(controller.getFirstDuplicate());

	}

	private void showFirstDuplicate(Duplicate duplicate) {
		duplicateResults.getChildren().clear();
		StringBuilder configuration = new StringBuilder("Found duplicate configuration: ");
		configuration.append(
				duplicate.data().stream().map(integer -> Integer.toString(integer)).collect(Collectors.joining(" - ")));
		String originalCycle = String.format("Original cycle: %d", duplicate.originalCycle());
		StringBuilder cycles = new StringBuilder("Duplicate cycles: ");
		cycles.append(duplicate.duplicateCycles().stream().map(cycle -> Integer.toString(cycle))
				.collect(Collectors.joining(", ")));
		String loopSize = String.format("Loop size: %d",
				duplicate.duplicateCycles().getFirst() - duplicate.originalCycle());
		duplicateResults.getChildren().addAll(new Label(configuration.toString()), new Label(originalCycle),
				new Label(cycles.toString()), new Label(loopSize));

	}

	private void submitPuzzleInput(TextAreaWithButton input) {
		input.getErrorLabel().clear();

		String puzzleInput = input.getTextArea().getText();
		if (!puzzleInput.matches("^(\\d+\\s)*\\d+$")) {
			input.getErrorLabel().setText("Puzzle Input is not valid");
			return;
		}

		List<Integer> numbers = new ArrayList<Integer>();
		for (String number : puzzleInput.split("\\s+"))
			numbers.add(Integer.parseInt(number));
		controller.setPuzzleInput(numbers);

		controller.runAllocator();
		update();
	}

}
