package com.jellerijk.aoc.aoc2017.common.gui.input.textfield;

import javafx.event.EventHandler;
import javafx.scene.input.KeyEvent;

public class TextFieldLiveInput extends TextFieldInput {

	@Override
	protected void buildGUI() {
		getChildren().addAll(txf, errorLabel);
	}

	public void setSubmit(EventHandler<? super KeyEvent> evt) {
		txf.setOnKeyTyped(evt);
	}

}
