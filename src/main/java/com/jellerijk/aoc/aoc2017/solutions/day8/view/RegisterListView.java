package com.jellerijk.aoc.aoc2017.solutions.day8.view;

import java.util.Collection;

import com.jellerijk.aoc.aoc2017.common.observer.Subscriber;
import com.jellerijk.aoc.aoc2017.solutions.day8.controllers.CPUController;
import com.jellerijk.aoc.aoc2017.solutions.day8.model.Register;

import javafx.geometry.Insets;
import javafx.scene.control.ListView;

public class RegisterListView extends ListView<String> implements Subscriber {
	private CPUController controller;

	public RegisterListView() {
		controller = CPUController.getInstance();
		controller.subscribe(this);
		setPadding(new Insets(5));
	}

	public void update() {
		getItems().clear();
		Collection<Register> registers = controller.getRegisters();
		registers.forEach(register -> {
			getItems().add(String.format("%s\t->\t%s", register.name(), register.value()));
		});

	};

}
