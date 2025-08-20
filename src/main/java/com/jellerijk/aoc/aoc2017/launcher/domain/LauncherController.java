package com.jellerijk.aoc.aoc2017.launcher.domain;

import java.util.List;

import com.jellerijk.aoc.aoc2017.launcher.domain.solution.Solution;
import com.jellerijk.aoc.aoc2017.launcher.domain.solution.SolutionLoader;
import com.jellerijk.aoc.aoc2017.launcher.domain.solution.SolutionsRepository;
import com.jellerijk.aoc.aoc2017.launcher.domain.solution.impl.SolutionLoaderImpl;

import javafx.scene.Scene;
import javafx.stage.Stage;

public class LauncherController {
	private static LauncherController instance;

	private SolutionsRepository solutionRepo;

	private LauncherController() {
		this.solutionRepo = new SolutionsRepository();
	}

	public static LauncherController getInstance() {
		if (instance == null)
			instance = new LauncherController();
		return instance;
	}

	public List<Solution> getSolutions() {
		return solutionRepo.getSolutions();
	}

	public void launch(Solution solution) {
		SolutionLoader loader = new SolutionLoaderImpl(solution);
		Stage stage = loader.load();
		Scene scene = stage.getScene();

		stage.getScene().getRoot().layout();
		stage.show();
		stage.setWidth(scene.getWidth());
		stage.setHeight(scene.getHeight());
	}

}
