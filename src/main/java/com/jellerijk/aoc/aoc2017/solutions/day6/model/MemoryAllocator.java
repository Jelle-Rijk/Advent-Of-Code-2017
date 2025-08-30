package com.jellerijk.aoc.aoc2017.solutions.day6.model;

import java.util.List;

public interface MemoryAllocator {
	public void setBanks(List<MemoryBank> banks);

	public List<MemoryBank> getBanks();

	public void run();

	/**
	 * Returns the amount of cycles before a duplicate configuration was found.
	 * 
	 * @return
	 */
	public Duplicate getFirstDuplicate();

}
