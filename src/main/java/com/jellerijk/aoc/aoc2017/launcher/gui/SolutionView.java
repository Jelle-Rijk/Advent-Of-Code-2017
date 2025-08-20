package com.jellerijk.aoc.aoc2017.launcher.gui;

import com.jellerijk.aoc.aoc2017.launcher.domain.LauncherController;
import com.jellerijk.aoc.aoc2017.launcher.domain.solution.Solution;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Border;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

public class SolutionView extends VBox {
	public Solution solution;

	public SolutionView(Solution solution) {
		if (solution == null)
			throw new IllegalArgumentException("SolutionView did not receive a Solution");
		this.solution = solution;
		buildGUI();
	}

	private void buildGUI() {
		// COMPONENTS
		Label day = new Label(String.format("Day %d", solution.getDay()));
		Label title = new Label(solution.getTitle());
		title.setStyle("-fx-font-weight: bold");

		Button btnLaunch = new Button("Launch");
		btnLaunch.setOnAction(evt -> launch());

		getChildren().addAll(day, title, btnLaunch);

		// LAYOUT
		this.setBorder(Border.stroke(Color.BLACK));
		this.setPadding(new Insets(10));
		this.setSpacing(4);
		this.setAlignment(Pos.CENTER);
	}

	private void launch() {
		LauncherController.getInstance().launch(solution);
	}

}
