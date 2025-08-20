package com.jellerijk.aoc.aoc2017.solutions.day2.gui;

import com.jellerijk.aoc.aoc2017.common.gui.input.textarea.TextAreaWithButton;
import com.jellerijk.aoc.aoc2017.common.gui.output.labels.ErrorLabel;
import com.jellerijk.aoc.aoc2017.common.observer.Subscriber;
import com.jellerijk.aoc.aoc2017.solutions.day2.domain.SpreadsheetController;

import javafx.geometry.Insets;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class Day2GUI extends HBox implements Subscriber {
	SpreadsheetController controller;

	TextAreaWithButton inputPanel;
	TextField checksum;
	TextField userOutput;

	public Day2GUI() {
		controller = SpreadsheetController.getInstance();
		controller.subscribe(this);
		buildGUI();
	}

	private void buildGUI() {
		inputPanel = new TextAreaWithButton();
		inputPanel.setOnAction(evt -> submit(inputPanel.getErrorLabel()));

		setSpacing(10);
		setPadding(new Insets(5));

		getChildren().addAll(inputPanel, buildOutputPanel());
	};

	private VBox buildOutputPanel() {
		Label lblChecksum = new Label("Checksum");
		checksum = new TextField();
		Label lblUserOutput = new Label("User Output");
		userOutput = new TextField();

		return new VBox(lblChecksum, checksum, lblUserOutput, userOutput);

	}

	private void submit(ErrorLabel err) {
		err.clear();
		try {
			controller.createSpreadsheet(inputPanel.getInput());
		} catch (Exception e) {
			err.setText(e.getMessage());
		}
	}

	@Override
	public void update() {
		try {
			checksum.setText(Integer.toString(controller.getChecksum()));
			userOutput.setText(Integer.toString(controller.getUserOutput()));
		} catch (Exception e) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("An exception was thrown");
			alert.setHeaderText(e.getClass().getSimpleName());
			alert.setContentText(e.getMessage());
		}
	}

}
