package com.jellerijk.aoc.aoc2017.solutions.day4.gui;

import com.jellerijk.aoc.aoc2017.common.gui.input.textarea.TextAreaWithButton;
import com.jellerijk.aoc.aoc2017.common.observer.Subscriber;
import com.jellerijk.aoc.aoc2017.solutions.day4.model.PassphraseController;

import javafx.geometry.Insets;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class Day4GUI extends HBox implements Subscriber {
	PassphraseController controller;

	CheckBox cbxPolicy;
	TextField resultField;

	public Day4GUI() {
		this.controller = PassphraseController.getInstance();
		controller.subscribe(this);
		buildGUI();
	}

	private void buildGUI() {
		VBox inputPanel = buildInput();

		Label lblValid = new Label("Valid passphrases");
		resultField = new TextField();
		cbxPolicy = new CheckBox("Use heightened security");
		cbxPolicy.setOnAction(evt -> update());
		VBox outputPanel = new VBox(lblValid, resultField, cbxPolicy);
		outputPanel.setPadding(new Insets(5));

		getChildren().addAll(inputPanel, outputPanel);
		setSpacing(10);
	}

	private VBox buildInput() {
		TextAreaWithButton textInput = new TextAreaWithButton();
		textInput.setOnAction(evt -> submit(textInput.getInput()));
		return textInput;
	}

	private void submit(String input) {
		controller.enterPassphrases(input);
	}

	@Override
	public void update() {
		resultField.setText(Integer.toString(controller.countValid(cbxPolicy.isSelected())));
	}

}
