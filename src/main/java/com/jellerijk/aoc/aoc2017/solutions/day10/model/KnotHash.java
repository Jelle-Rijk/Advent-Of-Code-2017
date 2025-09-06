package com.jellerijk.aoc.aoc2017.solutions.day10.model;

import java.util.List;

public interface KnotHash {

	public List<Integer> calculateSparseHash(List<Integer> lengths);

	/**
	 * Returns the integer in the hash at the given index.
	 * 
	 * @param index
	 * @return the integer at index
	 */
	public int get(int index);

	public int getCurrentPosition();

	public int getSkipSize();

	public List<Integer> getValues();

}
