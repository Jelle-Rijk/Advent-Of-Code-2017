package com.jellerijk.aoc.aoc2017.solutions.day10.model;

import java.util.List;

public interface KnotHashCalculator {
	/**
	 * Calculates the sparse hash 
	 * @param lengths
	 * @return
	 */
	public List<Integer> calculateSparseHash();

	/**
	 * Returns the hexadecimal representation of the dense hash for a given sparse hash.
	 * @return dense hash in hexadecimal notation
	 */
	public String calculateDenseHash(List<Integer> sparseHash);

}
