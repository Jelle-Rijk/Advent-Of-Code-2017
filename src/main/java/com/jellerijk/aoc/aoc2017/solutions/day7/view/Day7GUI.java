package com.jellerijk.aoc.aoc2017.solutions.day7.view;

import com.jellerijk.aoc.aoc2017.common.gui.input.textarea.TextAreaWithButton;
import com.jellerijk.aoc.aoc2017.solutions.day7.controllers.ProgramController;
import com.jellerijk.aoc.aoc2017.solutions.day7.model.ProgramDTO;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class Day7GUI extends HBox {
	private ProgramController controller;
	private TextAreaWithButton input;

	private TextField txfRoot;
	private TextField txfUnbalanced, txfUnbalancedWeight, txfCorrectedWeight;

	public Day7GUI() {
		controller = ProgramController.getInstance();
		buildGUI();
	}

	private void buildGUI() {
		input = new TextAreaWithButton();
		input.setButtonText("Submit program data");
		input.setOnAction(evt -> submitData());

		getChildren().add(input);
		buildOutput();
	}

	private void buildOutput() {
		Label lblResults = new Label("Results");
		lblResults.setStyle("-fx-font-size: 18px; -fx-font-weight: bold");

		Label lblRoot = new Label("Root node: ");
		txfRoot = new TextField();
		txfRoot.setEditable(false);
		HBox rootField = new HBox(lblRoot, txfRoot);
		rootField.setSpacing(3);

		Label lblErrorCorrection = new Label("Error correction");
		lblErrorCorrection.setStyle("-fx-font-weight: bold");
		txfUnbalanced = new TextField();
		HBox unbalancedField = new HBox(new Label("Faulty program: "), txfUnbalanced);
		unbalancedField.setSpacing(3);
		Label lblUnbalancedWeight = new Label("Weight: ");
		Label lblCorrectedWeight = new Label("Corrected: ");
		txfUnbalancedWeight = new TextField();
		txfCorrectedWeight = new TextField();
		HBox unbalancedWeight = new HBox(lblUnbalancedWeight, txfUnbalancedWeight, lblCorrectedWeight,
				txfCorrectedWeight);
		unbalancedWeight.setSpacing(3);
		VBox output = new VBox(lblResults, rootField, lblErrorCorrection, unbalancedField, unbalancedWeight);

		for (TextField outputField : new TextField[] { txfRoot, txfUnbalanced, txfUnbalancedWeight,
				txfCorrectedWeight }) {
			outputField.setEditable(false);
			outputField.setPrefWidth(60);
		}
		output.setSpacing(5);
		output.setPadding(new Insets(5));
		getChildren().add(output);
	}

	public void update() {
		txfRoot.setText(controller.getRootProgram().name());

		ProgramDTO faultyProgram = controller.getFaultyProgram();
		txfUnbalanced.setText(faultyProgram.name());
		txfUnbalancedWeight.setText(Integer.toString(faultyProgram.weight()));
		txfCorrectedWeight.setText(Integer.toString(faultyProgram.correctedWeight()));

	}

	private void submitData() {
		try {
			controller.parsePuzzleInput(input.getInput());
			update();
		} catch (Exception e) {
			input.getErrorLabel().setText(String.format("%s: %s", e.getClass().getSimpleName(), e.getMessage()));
			e.printStackTrace();
		}
	}
}
