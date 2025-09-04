package com.jellerijk.aoc.aoc2017.solutions.day9.model;

public interface DataStream {
	public String getData();

	public long getGroupCount();

	public long getGroupScore();

	public long getGarbageCount();

	public long getProcessingTime();
}
