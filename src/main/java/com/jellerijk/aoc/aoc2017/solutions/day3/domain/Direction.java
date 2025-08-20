package com.jellerijk.aoc.aoc2017.solutions.day3.domain;

public enum Direction {
	RIGHT(1, 0), UP(0, 1), LEFT(-1, 0), DOWN(0, -1);

	private int deltaX;
	private int deltaY;

	private Direction(int deltaX, int deltaY) {
		this.deltaX = deltaX;
		this.deltaY = deltaY;
	}

	public int getDeltaX() {
		return deltaX;
	}

	public int getDeltaY() {
		return deltaY;
	}

	/**
	 * Returns an array with all directions in order of movement.
	 * 
	 * @return An array consisting of RIGHT, UP, LEFT, DOWN
	 */
	public static Direction[] getAsOrderedArray() {
		return new Direction[] { RIGHT, UP, LEFT, DOWN };
	}

}
