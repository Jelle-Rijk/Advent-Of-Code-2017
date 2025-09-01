package com.jellerijk.aoc.aoc2017.solutions.day8.view;

import com.jellerijk.aoc.aoc2017.common.observer.Subscriber;
import com.jellerijk.aoc.aoc2017.solutions.day8.controllers.CPUController;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;

public class TopBar extends HBox implements Subscriber {
	private CPUController controller;

	private TextField txfHighestValue;
	private TextField txfRecordValue;

	public TopBar() {
		controller = CPUController.getInstance();
		controller.subscribe(this);
		buildGUI();
	}

	private void buildGUI() {
		Label lblHighestValue = new Label("Current highest value: ");
		txfHighestValue = new TextField();
		txfHighestValue.setMaxWidth(65);
		txfHighestValue.setEditable(false);

		Label lblRecordValue = new Label("Record: ");
		txfRecordValue = new TextField();
		txfRecordValue.setMaxWidth(65);
		txfRecordValue.setEditable(false);

		setSpacing(3);
		setPadding(new Insets(5));
		getChildren().addAll(lblHighestValue, txfHighestValue, lblRecordValue, txfRecordValue);
	}

	public void update() {
		txfHighestValue.setText(Integer.toString(controller.getHighestRegisterValue()));
		txfRecordValue.setText(Integer.toString(controller.getRecordValue()));
	}
}
