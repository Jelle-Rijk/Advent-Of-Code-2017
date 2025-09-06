package com.jellerijk.aoc.aoc2017.solutions.day10.model;

import java.util.ArrayList;
import java.util.List;

public abstract class InputParser {
	public static List<Integer> convertToInts(String input) {
		validateInput(input);

		List<Integer> numbers = new ArrayList<Integer>();
		for (String numberStr : input.split(",")) {
			int number = Integer.parseInt(numberStr);
			numbers.add(number);
		}
		return numbers;
	}

	public static List<Integer> convertToASCII(String input) {
		List<Integer> asciiCodes = new ArrayList<Integer>();
		for (char c : input.toCharArray()) {
			asciiCodes.add((int) c);
		}
		return asciiCodes;
	}

	public static void validateInput(String input) {
		if (!input.matches("^\\d+(,\\d+)*$"))
			throw new IllegalArgumentException("Input is in an invalid format");
	}

}
