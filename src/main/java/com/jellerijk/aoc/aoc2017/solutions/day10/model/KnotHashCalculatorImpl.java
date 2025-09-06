package com.jellerijk.aoc.aoc2017.solutions.day10.model;

import java.util.ArrayList;
import java.util.List;

public class KnotHashCalculatorImpl implements KnotHashCalculator {
	private final static int ROUNDS = 64;
	private final static int[] STANDARD_LENGTH_SUFFIX_VALUES = new int[] { 17, 31, 73, 47, 23 };

	private final static int BLOCK_SIZE = 16;
	private final static int BLOCKS = KnotHashImpl.HASH_LENGTH / BLOCK_SIZE;

	private final List<Integer> lengthSequence;

	public KnotHashCalculatorImpl(List<Integer> lengthSequence) {
		for (int i : STANDARD_LENGTH_SUFFIX_VALUES)
			lengthSequence.add(i);
		this.lengthSequence = lengthSequence;
	}

	@Override
	public List<Integer> calculateSparseHash() {
		int currentPosition = 0, skipSize = 0;
		KnotHash knotHash = new KnotHashImpl();
		List<Integer> sparseHash = null;

		for (int i = 0; i < ROUNDS; i++) {
			sparseHash = knotHash.calculateSparseHash(lengthSequence);
			currentPosition = knotHash.getCurrentPosition();
			skipSize = knotHash.getSkipSize();
			knotHash = new KnotHashImpl(currentPosition, skipSize, knotHash.getValues());
		}

		if (sparseHash == null)
			throw new IllegalArgumentException("Could not calculate sparse hash");
		return sparseHash;
	}

	@Override
	public String calculateDenseHash(List<Integer> sparseHash) {
		if (sparseHash.size() != 256)
			throw new IllegalArgumentException(
					String.format("Sparse Hash has unexpected length: %d", sparseHash.size()));

		List<Integer> denseHash = new ArrayList<Integer>();
		for (int block = 0; block < BLOCKS; block++) {
			int result = sparseHash.get(block * BLOCK_SIZE);
			for (int element = 1; element < BLOCK_SIZE; element++) {
				result ^= sparseHash.get(block * BLOCK_SIZE + element);
			}
			denseHash.add(result);
		}
		return convertToHexadecimal(denseHash);

	}

	private String convertToHexadecimal(List<Integer> denseHash) {
		StringBuilder sb = new StringBuilder();
		for (int value : denseHash) {
			sb.append(String.format("%02x", value)); // always 2 hex digits
		}
		return sb.toString();
	}

}
