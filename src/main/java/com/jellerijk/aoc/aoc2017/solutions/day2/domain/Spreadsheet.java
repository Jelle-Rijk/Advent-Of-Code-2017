package com.jellerijk.aoc.aoc2017.solutions.day2.domain;

public interface Spreadsheet {
	public long calculateChecksum() throws Exception;

	public int getUserResult() throws Exception;
}
