package com.jellerijk.aoc.aoc2017.launcher.domain.solution.impl;

import com.jellerijk.aoc.aoc2017.launcher.domain.solution.Solution;

import javafx.scene.Scene;

public abstract class SolutionImpl implements Solution {
	private int day;
	private String title;
	private Scene GUI;

	public SolutionImpl(int day, String title) {
		setDay(day);
		setTitle(title);
	}

	@Override
	public void load() {
		initGUI();
	}

	/**
	 * Creates a Scene object that is then set as the GUI for this Solution.
	 */
	protected abstract void initGUI();

	// GETTERS - SETTERS

	public int getDay() {
		return day;
	}

	protected void setDay(int day) {
		if (day <= 0)
			throw new IllegalArgumentException("Day needs to be a positive integer.");
		this.day = day;
	}

	public String getTitle() {
		return title;
	}

	protected void setTitle(String title) {
		if (title == null || title.isBlank())
			throw new IllegalArgumentException("Title cannot be null, empty or blank.");
		this.title = title;
	}

	public Scene getGUI() {
		if (GUI == null)
			initGUI();
		return GUI;
	}

	protected final void setGUI(Scene gui) {
		this.GUI = gui;
	}

}
