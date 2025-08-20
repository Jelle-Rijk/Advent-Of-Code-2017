package com.jellerijk.aoc.aoc2017.solutions.day5.model;

public interface CPU {
	public int getCPUCycles();

	public default void run() {
		run(false);
	}

	public void run(boolean strangeJumps);

}
