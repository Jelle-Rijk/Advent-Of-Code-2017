package com.jellerijk.aoc.aoc2017.solutions.day9;

import com.jellerijk.aoc.aoc2017.launcher.domain.solution.impl.SolutionImpl;
import com.jellerijk.aoc.aoc2017.solutions.day9.view.Day9GUI;

import javafx.scene.Scene;

public class Day9 extends SolutionImpl {

	public Day9() {
		super(9, "Stream Processing");
	}

	@Override
	protected void initGUI() {
		setGUI(new Scene(new Day9GUI()));
	}

}
