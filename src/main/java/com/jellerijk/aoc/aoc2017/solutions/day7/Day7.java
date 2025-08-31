package com.jellerijk.aoc.aoc2017.solutions.day7;

import com.jellerijk.aoc.aoc2017.launcher.domain.solution.impl.SolutionImpl;
import com.jellerijk.aoc.aoc2017.solutions.day7.view.Day7GUI;

import javafx.scene.Scene;

public class Day7 extends SolutionImpl {

	public Day7() {
		super(7, "Recursive Circus");
	}

	@Override
	protected void initGUI() {
		setGUI(new Scene(new Day7GUI()));
	}

}
