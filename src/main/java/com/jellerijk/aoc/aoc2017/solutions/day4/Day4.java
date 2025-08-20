package com.jellerijk.aoc.aoc2017.solutions.day4;

import com.jellerijk.aoc.aoc2017.launcher.domain.solution.impl.SolutionImpl;
import com.jellerijk.aoc.aoc2017.solutions.day4.gui.Day4GUI;

import javafx.scene.Scene;

public class Day4 extends SolutionImpl {

	public Day4() {
		super(4, "High-Entropy Passphrases");
	}

	@Override
	protected void initGUI() {
		setGUI(new Scene(new Day4GUI()));

	}

}
