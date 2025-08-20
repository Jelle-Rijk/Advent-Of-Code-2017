package com.jellerijk.aoc.aoc2017.launcher.domain.solution;

import javafx.stage.Stage;

public interface SolutionLoader {
	/**
	 * Loads the SolutionLoader's solution and returns the Stage in which the solution was loaded.
	 * @return
	 */
	public Stage load();

}
