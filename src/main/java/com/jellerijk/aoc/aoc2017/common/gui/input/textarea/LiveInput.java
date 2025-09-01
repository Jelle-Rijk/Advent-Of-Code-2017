package com.jellerijk.aoc.aoc2017.common.gui.input.textarea;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.input.KeyEvent;

public class LiveInput extends TextAreaInput {

	public LiveInput() {
		super();
		buildGUI();
	}

	@Override
	protected void buildGUI() {
		getChildren().addAll(txa, errorLabel);
	}

	public void setOnAction(EventHandler<? super KeyEvent> evt) {
		txa.setOnKeyTyped(evt);
	}

}
