package com.jellerijk.aoc.aoc2017.common.gui.input.textfield;

import com.jellerijk.aoc.aoc2017.common.gui.output.labels.ErrorLabel;

import javafx.geometry.Insets;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

public abstract class TextFieldInput extends VBox {
	protected TextField txf;
	protected ErrorLabel errorLabel;

	public TextFieldInput() {
		txf = new TextField();
		errorLabel = new ErrorLabel();
		setLayout();
	}

	private void setLayout() {
		setPrefWidth(150);
		setSpacing(5);
		setPadding(new Insets(5));
	}

	public TextField getTextField() {
		return txf;
	}

	protected abstract void buildGUI();

	public String getInput() {
		return txf.getText();
	}

	public ErrorLabel getErrorLabel() {
		return errorLabel;
	}

	public void clear() {
		txf.clear();
	}

}
