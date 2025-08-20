package com.jellerijk.aoc.aoc2017.common.gui.output.labels;

import javafx.scene.control.Label;

public class ErrorLabel extends Label {
	public ErrorLabel() {
		super();
		this.setStyle("-fx-text-fill: red; -fx-font-weight: bold");
	}

	public void clear() {
		setText("");
	}

}
