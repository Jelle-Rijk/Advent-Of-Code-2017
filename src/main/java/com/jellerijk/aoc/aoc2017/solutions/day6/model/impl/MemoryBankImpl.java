package com.jellerijk.aoc.aoc2017.solutions.day6.model.impl;

import com.jellerijk.aoc.aoc2017.solutions.day6.model.MemoryBank;

public class MemoryBankImpl implements MemoryBank {
	private final int number;
	private int blockCount;

	public MemoryBankImpl(int number, int blockCount) {
		this.number = number;
		setBlockCount(blockCount);
	}

	@Override
	public void insertMemoryBlock() {
		setBlockCount(blockCount + 1);
	}

	@Override
	public void clear() {
		setBlockCount(0);
	}

	/*
	 * GETTERS - SETTERS
	 */

	@Override
	public int getBlockCount() {
		return blockCount;
	}

	private final void setBlockCount(int blockCount) {
		if (blockCount < 0)
			throw new IllegalArgumentException("Block count went below zero.");
		this.blockCount = blockCount;
	}

	@Override
	public int getNumber() {
		return number;
	}

	@Override
	public String toString() {
		return String.format("%s with number %d and %d blocks", getClass().getSimpleName(), number, blockCount);
	}

}
