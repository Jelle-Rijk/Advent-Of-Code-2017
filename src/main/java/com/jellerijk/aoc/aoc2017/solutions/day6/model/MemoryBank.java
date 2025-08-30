package com.jellerijk.aoc.aoc2017.solutions.day6.model;

public interface MemoryBank {
	public int getBlockCount();

	public int getNumber();

	public void insertMemoryBlock();

	public void clear();

}
