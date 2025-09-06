package com.jellerijk.aoc.aoc2017.solutions.day10.view;

import com.jellerijk.aoc.aoc2017.common.gui.input.textarea.TextAreaWithButton;
import com.jellerijk.aoc.aoc2017.solutions.day10.controller.KnotHashController;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class Day10GUI extends BorderPane {
	private final KnotHashController controller;

	private TextAreaWithButton input;

	private TextField txfFirstNode;
	private TextField txfSecondNode;
	private TextField txfMultiplied;
	private TextField txfHash;

	public Day10GUI() {
		controller = KnotHashController.getInstance();
		buildGUI();
	}

	private void buildGUI() {
		input = new TextAreaWithButton();
		input.setOnAction(evt -> submit());

		VBox output = new VBox();
		txfFirstNode = new TextField();
		txfSecondNode = new TextField();
		txfMultiplied = new TextField();
		txfHash = new TextField();

		output.getChildren().add(new Label("First round results:"));
		addOutputField(output, "First Node", txfFirstNode);
		addOutputField(output, "Second Node", txfSecondNode);
		addOutputField(output, "Multiplied", txfMultiplied);
		output.getChildren().add(new Label("HASH CALCULATION"));
		addOutputField(output, "Hash", txfHash);

		setLeft(input);
		setRight(output);
	}

	private void addOutputField(VBox output, String labelText, TextField txf) {
		HBox outputField = new HBox();
		Label label = new Label(labelText);
		txf.setEditable(false);
		outputField.setSpacing(3);
		outputField.setPadding(new Insets(5));

		outputField.getChildren().addAll(label, txf);
		output.getChildren().add(outputField);

	}

	private void update() {

		int first = controller.getNodeFromFirstRound(0);
		int second = controller.getNodeFromFirstRound(1);
		int multiplied = first * second;

		txfFirstNode.setText(Integer.toString(first));
		txfSecondNode.setText(Integer.toString(second));
		txfMultiplied.setText(Integer.toString(multiplied));
	}

	private void submit() {
		input.getErrorLabel().clear();
		try {
			controller.calculateFirstRound(input.getInput());
			update();
		} catch (Exception e) {
			input.getErrorLabel().setText(String.format("%s: %s", e.getClass().getSimpleName(), e.getMessage()));
			e.printStackTrace();
		}
		txfHash.setText(controller.calculateHash(input.getInput()));
	}

}
