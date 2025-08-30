package com.jellerijk.aoc.aoc2017.solutions.day6.controllers;

import java.util.List;

import com.jellerijk.aoc.aoc2017.solutions.day6.model.Duplicate;

public interface MemoryController {
	public static MemoryController getInstance() {
		return MemoryControllerImpl.getInstance();
	}

	/**
	 * Sets the data for the initial memory bank configuration.
	 * 
	 * @param blockCounts
	 */
	public void setPuzzleInput(List<Integer> blockCounts);

	public void runAllocator();

	public Duplicate getFirstDuplicate();

}
