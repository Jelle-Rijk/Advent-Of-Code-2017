package com.jellerijk.aoc.aoc2017.solutions.day3.domain;

import java.util.HashMap;
import java.util.Objects;

import javafx.concurrent.Task;

public class SmallestLargerNumberTask extends Task<Integer> {
	private final int goal;

	private int x;
	private int y;

	private HashMap<Coordinate, Integer> exploredTiles;

	public final static int STARTING_X = 0;
	public final static int STARTING_Y = 0;
	public final static int STARTING_VALUE = 1;
	public final static int STARTING_EDGE_LENGTH = 1;
	public final static Direction[] directions = Direction.getAsOrderedArray();

	public SmallestLargerNumberTask(int goal) {
		this.goal = goal;
		exploredTiles = new HashMap<Coordinate, Integer>();
		exploredTiles.put(new Coordinate(STARTING_X, STARTING_Y), STARTING_VALUE);
	}

	@Override
	protected Integer call() throws Exception {
		int edgeCounter = 0;
		int currentValue = STARTING_VALUE;
		int currentDirection = 0;
		int edgeLength = STARTING_EDGE_LENGTH;
		int edgeStepCounter = 0;

		while (currentValue <= goal) {
			Coordinate nextTile = getNextTile(directions[currentDirection]);
			edgeStepCounter++;
			if (edgeStepCounter == edgeLength) {
				edgeStepCounter = 0;
				edgeCounter++;
				currentDirection = (currentDirection + 1) % directions.length;
				// Add distance every two edges
				if (edgeCounter % 2 == 0)
					edgeLength++;
			}
			currentValue = calculateTileValue(nextTile.getX(), nextTile.getY());
			this.x = nextTile.getX();
			this.y = nextTile.getY();
		}
		return currentValue;
	}

	private Coordinate getNextTile(Direction dir) {
		return new Coordinate(x + dir.getDeltaX(), y + dir.getDeltaY());
	}

	/**
	 * Calculates the tile's value, puts it in the exploredtiles HashMap and returns
	 * the currentTile's value
	 * 
	 * @param x
	 * @param y
	 * @return Value of the tile at coordinate x, y
	 */
	private int calculateTileValue(int x, int y) {
		Coordinate coord = new Coordinate(x, y);
		int result = 0;
		for (Coordinate neighbor : coord.getNeighboringCoordinates()) {
			if (exploredTiles.containsKey(neighbor)) {
				result += exploredTiles.get(neighbor);
			}
		}
		exploredTiles.put(coord, result);
		return result;
	}

	private class Coordinate {

		private final int x;
		private final int y;

		public Coordinate(int x, int y) {
			this.x = x;
			this.y = y;
		}

		public int getX() {
			return x;
		}

		public int getY() {
			return y;
		}

		public Coordinate[] getNeighboringCoordinates() {
			Coordinate[] coordinates = new Coordinate[8];
			int index = 0;
			for (int col = -1; col <= 1; col++) {
				for (int row = -1; row <= 1; row++) {
					if (row == 0 && col == 0)
						continue;
					coordinates[index] = new Coordinate(x + col, y + row);
					index++;
				}
			}
			for (Coordinate coordinate : coordinates) {
				System.out.println(coordinate);
			}
			return coordinates;
		}

		@Override
		public boolean equals(Object o) {
			if (this == o)
				return true;
			if (o == null || o.getClass() != this.getClass())
				return false;
			Coordinate c = (Coordinate) o;
			return c.x == x && c.y == y;
		}

		@Override
		public int hashCode() {
			return Objects.hash(x, y);
		}

		@Override
		public String toString() {
			return String.format("(%d, %d)", x, y);
		}
	};

}
