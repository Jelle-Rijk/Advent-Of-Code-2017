package com.jellerijk.aoc.aoc2017.solutions.day3.domain;

import javafx.concurrent.Task;

public class ManhattanDistanceTask extends Task<Integer> {
	final private int goal;
	private int distance;
	private int x;
	private int y;
	private int currentDirection;

	public final static int START_X = 0;
	public final static int START_Y = 0;
	public final static int START_VALUE = 1;
	public final static int START_DISTANCE = 1;
	public final static Direction[] directions = Direction.getAsOrderedArray();

	public ManhattanDistanceTask(int goal) {
		setX(START_X);
		setY(START_Y);
		if (goal <= 0)
			throw new IllegalArgumentException("The goal should be a positive integer");
		this.goal = goal;
		this.distance = START_DISTANCE;
	}

	@Override
	protected Integer call() throws Exception {
		int currentValue = START_VALUE;
		Direction dir = directions[currentDirection];
		int counter = 1;

		while (currentValue < goal) {
			currentValue = extendSpiral(dir, distance, currentValue);
			dir = getNextDirection();
			counter++;
			if (counter % 2 == 0)
				distance++;
		}
		if (currentValue > goal)
			backTrack(getNextDirection(), currentValue, goal);

		return getManhattanDistance(START_X, START_Y, x, y);

	}

	/**
	 * Hops to the next corner of the Spiral Memory, sets X and Y accordingly.
	 * 
	 * @param dir      - Direction in which to move
	 * @param distance - Distance in which to move
	 * @return The value of the current coordinate
	 */
	private int extendSpiral(Direction dir, int distance, int value) {
		int newX = x + distance * dir.getDeltaX();
		int newY = y + distance * dir.getDeltaY();
		setX(newX);
		setY(newY);
		return value + distance;
	}

	private void backTrack(Direction dir, int currentValue, int goal) {
		int distance = currentValue - goal;
		int newX = x + distance * dir.getDeltaX();
		int newY = y + distance * dir.getDeltaY();
		setX(newX);
		setY(newY);
	}

	private Direction getNextDirection() {
		currentDirection++;
		return directions[currentDirection % directions.length];
	}

	private int getManhattanDistance(int x1, int y1, int x2, int y2) {
		return Math.abs(x1 - x2) + Math.abs(y1 - y2);
	}

	private int getX() {
		return x;
	}

	private int getY() {
		return y;
	}

	private void setX(int x) {
		this.x = x;
	}

	private void setY(int y) {
		this.y = y;
	}

}
