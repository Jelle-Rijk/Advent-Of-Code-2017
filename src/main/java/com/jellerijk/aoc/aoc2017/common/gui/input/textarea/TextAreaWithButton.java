package com.jellerijk.aoc.aoc2017.common.gui.input.textarea;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

public class TextAreaWithButton extends TextAreaInput {
	private Button submitButton;

	public TextAreaWithButton() {
		super();
		submitButton = new Button("Submit");
		buildGUI();
	}

	public Button getSubmitButton() {
		return submitButton;
	}

	public void setButtonText(String buttonText) {
		submitButton.setText(buttonText);
	}

	public void setOnAction(EventHandler<ActionEvent> evt) {
		submitButton.setOnAction(evt);
	}

	@Override
	protected void buildGUI() {
		getChildren().addAll(txa, submitButton, errorLabel);
	}

}
