package com.jellerijk.aoc.aoc2017.launcher.domain.solution;

import javafx.scene.Scene;

public interface Solution {
	public int getDay();

	public String getTitle();

	public Scene getGUI();

	/*
	 * Loads the Solution's Controller and GUI. This is used by the SolutionLoader
	 * to return a new Stage representing this Solution.
	 */
	public void load();

}
