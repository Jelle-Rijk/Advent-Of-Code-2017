package com.jellerijk.aoc.aoc2017.solutions.day2.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class InputParser {

	public static List<List<Integer>> parseSpreadsheetData(String input) {
		List<List<Integer>> data = new ArrayList<List<Integer>>();

		String[] rows = input.split("\n");
		for (String row : rows) {
			if (!row.matches("^(\\d+\\s+)*\\d+$"))
				throw new IllegalArgumentException("Invalid row");

			List<Integer> rowData = new ArrayList<Integer>();
			Arrays.stream(row.split("\\s+")).forEach(string -> rowData.add(Integer.parseInt(string)));

			data.add(rowData);
		}
		return data;
	}

}
