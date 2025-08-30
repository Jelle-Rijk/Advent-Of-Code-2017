package com.jellerijk.aoc.aoc2017.solutions.day6;

import com.jellerijk.aoc.aoc2017.launcher.domain.solution.impl.SolutionImpl;
import com.jellerijk.aoc.aoc2017.solutions.day6.view.Day6GUI;

import javafx.scene.Scene;

public class Day6 extends SolutionImpl {

	public Day6() {
		super(6, "Memory Reallocation");
	}

	@Override
	protected void initGUI() {
		setGUI(new Scene(new Day6GUI()));
	}

}
