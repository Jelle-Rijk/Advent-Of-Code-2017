package com.jellerijk.aoc.aoc2017.launcher.gui;

import java.util.ArrayList;
import java.util.List;

import com.jellerijk.aoc.aoc2017.launcher.domain.LauncherController;

import javafx.scene.layout.VBox;

public class MainScreen extends VBox {
	private LauncherController controller;

	private LaunchPane launchPane;

	public MainScreen() {
		this.controller = LauncherController.getInstance();
		buildGUI();
	}

	private void buildGUI() {
		List<SolutionView> solViews = new ArrayList<SolutionView>();
		controller.getSolutions().forEach(solution -> solViews.add(new SolutionView(solution)));
		launchPane = new LaunchPane(solViews);

		getChildren().addAll(launchPane);
	}

}
