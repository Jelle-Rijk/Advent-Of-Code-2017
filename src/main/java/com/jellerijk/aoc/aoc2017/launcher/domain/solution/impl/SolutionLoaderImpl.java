package com.jellerijk.aoc.aoc2017.launcher.domain.solution.impl;

import com.jellerijk.aoc.aoc2017.launcher.domain.solution.Solution;
import com.jellerijk.aoc.aoc2017.launcher.domain.solution.SolutionLoader;

import javafx.scene.Scene;
import javafx.stage.Stage;

public class SolutionLoaderImpl implements SolutionLoader {
	private final Solution solution;

	public SolutionLoaderImpl(Solution solution) {
		if (solution == null)
			throw new IllegalArgumentException("SolutionLoader needs a provided Solution, was null");
		this.solution = solution;
	}

	@Override
	public Stage load() {
		solution.load();
		Scene scene = solution.getGUI();

		Stage stage = new Stage();
		stage.setScene(scene);
		stage.setTitle(String.format("AOC17 - Day %d - %s", solution.getDay(), solution.getTitle()));
		return stage;
	}

}
