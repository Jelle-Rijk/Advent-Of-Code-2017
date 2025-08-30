package com.jellerijk.aoc.aoc2017.solutions.day6.model;

import java.util.List;

public interface AllocatorHistory {
	public void addCycle(List<Integer> configuration);

	public boolean hasDuplicate();

	public Duplicate getFirstDuplicate();

}
