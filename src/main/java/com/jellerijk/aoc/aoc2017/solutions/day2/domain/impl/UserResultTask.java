package com.jellerijk.aoc.aoc2017.solutions.day2.domain.impl;

import java.util.List;

import javafx.concurrent.Task;

public class UserResultTask extends Task<Integer> {
	private final List<List<Integer>> data;

	public UserResultTask(List<List<Integer>> data) {
		this.data = data;
	}

	@Override
	protected Integer call() throws Exception {
		int result = 0;
		for (List<Integer> row : data) {
			result += getRowResult(row);
		}
		return result;
	}

	private int getRowResult(List<Integer> row) {
		for (int i = 0; i < row.size() - 1; i++) {
			int dividend = row.get(i);
			for (int j = i + 1; j < row.size(); j++) {
				int divisor = row.get(j);
				if (dividend % divisor == 0) {
					return dividend / divisor;
				} else if (divisor % dividend == 0) {
					return divisor / dividend;
				}
			}
		}
		throw new IllegalArgumentException("This row does not have two evenly divisible integers");

	}

}
