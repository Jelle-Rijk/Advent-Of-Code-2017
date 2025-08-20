package com.jellerijk.aoc.aoc2017.solutions.day1;

import com.jellerijk.aoc.aoc2017.launcher.domain.solution.impl.SolutionImpl;
import com.jellerijk.aoc.aoc2017.solutions.day1.gui.Day1GUI;

import javafx.scene.Scene;

public class Day1 extends SolutionImpl {

	public Day1() {
		super(1, "Inverse Captcha");
	}

	@Override
	protected void initGUI() {
		Day1GUI root = new Day1GUI();
		Scene scene = new Scene(root);
		setGUI(scene);
	}

}
