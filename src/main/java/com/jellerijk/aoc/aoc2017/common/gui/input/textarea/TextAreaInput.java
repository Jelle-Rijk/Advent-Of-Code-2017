package com.jellerijk.aoc.aoc2017.common.gui.input.textarea;

import com.jellerijk.aoc.aoc2017.common.gui.output.labels.ErrorLabel;

import javafx.geometry.Insets;
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;

public abstract class TextAreaInput extends VBox {
	TextArea txa;
	ErrorLabel errorLabel;

	public final static String DEFAULT_PROMPT = "Please enter your puzzle input";

	public TextAreaInput() {
		txa = new TextArea();
		errorLabel = new ErrorLabel();
		setPrompt(DEFAULT_PROMPT);
		setLayout();
	}

	public void setLayout() {
		setPrefWidth(300);
		setSpacing(5);
		setPadding(new Insets(5));
	}

	public TextArea getTextArea() {
		return txa;
	}

	protected abstract void buildGUI();

	public void setPrompt(String prompt) {
		if (prompt == null)
			throw new IllegalArgumentException("Prompt was null");
		txa.setPromptText(prompt);
	}

	public String getInput() {
		return txa.getText();
	}

	public ErrorLabel getErrorLabel() {
		return errorLabel;
	}

	public void clear() {
		txa.clear();
	}

}
