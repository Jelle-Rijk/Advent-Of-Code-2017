package com.jellerijk.aoc.aoc2017.solutions.day10;

import com.jellerijk.aoc.aoc2017.launcher.domain.solution.impl.SolutionImpl;
import com.jellerijk.aoc.aoc2017.solutions.day10.view.Day10GUI;

import javafx.scene.Scene;

public class Day10 extends SolutionImpl {

	public Day10() {
		super(10, "Knot Hash");
	}

	@Override
	protected void initGUI() {
		setGUI(new Scene(new Day10GUI()));
	}

}
