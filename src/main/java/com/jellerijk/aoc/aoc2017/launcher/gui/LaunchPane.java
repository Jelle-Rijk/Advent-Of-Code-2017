package com.jellerijk.aoc.aoc2017.launcher.gui;

import java.util.List;

import javafx.scene.layout.FlowPane;

public class LaunchPane extends FlowPane {
	public List<SolutionView> solutionLaunchers;

	public LaunchPane(List<SolutionView> solutionLaunchers) {
		this.solutionLaunchers = solutionLaunchers;
		buildGUI();
	}

	private void buildGUI() {
		solutionLaunchers.forEach(view -> getChildren().add(view));
	}

}
