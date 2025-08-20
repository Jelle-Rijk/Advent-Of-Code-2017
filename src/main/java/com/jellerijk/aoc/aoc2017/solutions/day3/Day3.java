package com.jellerijk.aoc.aoc2017.solutions.day3;

import com.jellerijk.aoc.aoc2017.launcher.domain.solution.impl.SolutionImpl;
import com.jellerijk.aoc.aoc2017.solutions.day3.gui.Day3GUI;

import javafx.scene.Scene;

public class Day3 extends SolutionImpl {

	public Day3() {
		super(3, "Spiral Memory");
	}

	@Override
	protected void initGUI() {
		setGUI(new Scene(new Day3GUI()));
	}

}
