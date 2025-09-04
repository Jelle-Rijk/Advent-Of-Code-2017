package com.jellerijk.aoc.aoc2017.solutions.day9.view;

import com.jellerijk.aoc.aoc2017.common.observer.Subscriber;
import com.jellerijk.aoc.aoc2017.solutions.day9.controller.StreamAnalysisController;

import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class OutputPanel extends VBox implements Subscriber {
	private StreamAnalysisController controller;

	private TextField txfGroupCount;
	private TextField txfGroupScore;
	private TextField txfGarbageCount;
	private Label lblProcessingTime;

	public OutputPanel() {
		controller = StreamAnalysisController.getInstance();
		controller.subscribe(this);
		buildGUI();
	}

	private void buildGUI() {
		txfGroupCount = new TextField();
		txfGroupScore = new TextField();
		txfGarbageCount = new TextField();
		lblProcessingTime = new Label("");

		addField("Groups", txfGroupCount);
		addField("Score", txfGroupScore);
		addField("Garbage", txfGarbageCount);

		getChildren().add(lblProcessingTime);
	}

	private void addField(String label, TextField txf) {
		Label lbl = new Label(label);
		txf.setEditable(false);
		HBox hbox = new HBox(lbl, txf);
		hbox.setSpacing(3);

		getChildren().add(hbox);
	}

	private void updateField(TextField txf, long value) {
		String valueStr = Long.toString(value);
		txf.setText(valueStr);
	};

	@Override
	public void update() {
		updateField(txfGroupCount, controller.getGroupCount());
		updateField(txfGroupScore, controller.getGroupScore());
		updateField(txfGarbageCount, controller.getGarbageCount());
		lblProcessingTime.setText(String.format("Processing time: %dms", controller.getProcessingCount()));
	}

}
