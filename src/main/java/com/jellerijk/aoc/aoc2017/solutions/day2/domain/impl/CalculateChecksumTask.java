package com.jellerijk.aoc.aoc2017.solutions.day2.domain.impl;

import java.util.List;

import javafx.concurrent.Task;

public class CalculateChecksumTask extends Task<Integer> {
	public List<List<Integer>> rows;

	public CalculateChecksumTask(List<List<Integer>> rows) {
		this.rows = rows;
	}

	@Override
	protected Integer call() throws Exception {
		int result = rows.stream().map(row -> {
			int max = row.stream().max(Integer::compare).orElseThrow();
			int min = row.stream().min(Integer::compare).orElseThrow();
			return max - min;
		}).reduce(Integer::sum).orElseThrow();
		return result;
	}

}
