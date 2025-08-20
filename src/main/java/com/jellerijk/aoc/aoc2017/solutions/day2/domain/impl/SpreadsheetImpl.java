package com.jellerijk.aoc.aoc2017.solutions.day2.domain.impl;

import java.util.List;

import com.jellerijk.aoc.aoc2017.solutions.day2.domain.Spreadsheet;

public class SpreadsheetImpl implements Spreadsheet {
	private List<List<Integer>> data;

	public SpreadsheetImpl(List<List<Integer>> data) {
		this.data = data;
	}

	@Override
	public long calculateChecksum() throws Exception {
		return new CalculateChecksumTask(data).call();
	}

	@Override
	public int getUserResult() throws Exception {
		try {
			int result = new UserResultTask(data).call();
			return result;
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		throw new IllegalArgumentException("Could not get user's result");
	}

}
