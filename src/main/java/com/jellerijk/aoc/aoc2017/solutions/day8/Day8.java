package com.jellerijk.aoc.aoc2017.solutions.day8;

import com.jellerijk.aoc.aoc2017.launcher.domain.solution.impl.SolutionImpl;
import com.jellerijk.aoc.aoc2017.solutions.day8.view.Day8GUI;

import javafx.scene.Scene;

public class Day8 extends SolutionImpl {

	public Day8() {
		super(8, "I Heard You Like Registers");
	}

	@Override
	protected void initGUI() {
		setGUI(new Scene(new Day8GUI()));
	}

}
