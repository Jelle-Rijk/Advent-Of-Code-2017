package com.jellerijk.aoc.aoc2017.common.gui.input.textfield;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;

public class TextFieldSubmitButton extends TextFieldInput {
	private Button submitButton;

	public TextFieldSubmitButton() {
		super();
		submitButton = createSubmitButton();
		buildGUI();
	}

	private Button createSubmitButton() {
		Button button = new Button(">");
		button.setPrefSize(USE_COMPUTED_SIZE, USE_COMPUTED_SIZE);
		button.setPadding(new Insets(3));
		return button;
	}

	@Override
	protected void buildGUI() {
		HBox fieldAndButton = new HBox(txf, submitButton);
		getChildren().addAll(fieldAndButton, errorLabel);
	}

	public void setSubmit(EventHandler<ActionEvent> evt) {
		txf.setOnAction(evt);
		submitButton.setOnAction(evt);
	}

}
