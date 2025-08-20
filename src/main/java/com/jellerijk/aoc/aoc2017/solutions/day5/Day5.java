package com.jellerijk.aoc.aoc2017.solutions.day5;

import com.jellerijk.aoc.aoc2017.launcher.domain.solution.impl.SolutionImpl;
import com.jellerijk.aoc.aoc2017.solutions.day5.view.Day5GUI;

import javafx.scene.Scene;

public class Day5 extends SolutionImpl {

	public Day5() {
		super(5, "A Maze of Twisty Trampolines, All Alike");
	}

	@Override
	protected void initGUI() {
		setGUI(new Scene(new Day5GUI()));
	}

}
