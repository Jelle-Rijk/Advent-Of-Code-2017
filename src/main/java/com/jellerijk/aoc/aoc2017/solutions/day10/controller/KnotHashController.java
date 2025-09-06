package com.jellerijk.aoc.aoc2017.solutions.day10.controller;

import java.util.List;

import com.jellerijk.aoc.aoc2017.solutions.day10.model.InputParser;
import com.jellerijk.aoc.aoc2017.solutions.day10.model.KnotHash;
import com.jellerijk.aoc.aoc2017.solutions.day10.model.KnotHashCalculator;
import com.jellerijk.aoc.aoc2017.solutions.day10.model.KnotHashCalculatorImpl;
import com.jellerijk.aoc.aoc2017.solutions.day10.model.KnotHashImpl;

public class KnotHashController {
	private KnotHash firstRound;
	private static KnotHashController instance;

	private KnotHashController() {
	}

	public static KnotHashController getInstance() {
		if (instance == null)
			instance = new KnotHashController();
		return instance;
	}

	public String calculateHash(String input) {
		List<Integer> lengths = InputParser.convertToASCII(input);
		KnotHashCalculator calculator = new KnotHashCalculatorImpl(lengths);
		List<Integer> sparseHash = calculator.calculateSparseHash();
		return calculator.calculateDenseHash(sparseHash);
	}

	public void calculateFirstRound(String input) {
		List<Integer> lengths = InputParser.convertToInts(input);
		firstRound = new KnotHashImpl();
		firstRound.calculateSparseHash(lengths);
	}

	public int getNodeFromFirstRound(int index) {
		if (firstRound == null)
			throw new IllegalArgumentException("KnotHash has not been twisted");
		return firstRound.get(index);
	}

}
