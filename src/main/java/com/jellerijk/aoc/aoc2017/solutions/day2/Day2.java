package com.jellerijk.aoc.aoc2017.solutions.day2;

import com.jellerijk.aoc.aoc2017.launcher.domain.solution.impl.SolutionImpl;
import com.jellerijk.aoc.aoc2017.solutions.day2.gui.Day2GUI;

import javafx.scene.Scene;

public class Day2 extends SolutionImpl {

	public Day2() {
		super(2, "Corruption Checksum");
	}

	@Override
	protected void initGUI() {
		Scene scene = new Scene(new Day2GUI());
		setGUI(scene);
	}

}
