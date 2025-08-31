package com.jellerijk.aoc.aoc2017.solutions.day7.model;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class InputParser {
	private final static Matcher numberMatcher = Pattern.compile("\\d+").matcher("");
	private final static Matcher nameMatcher = Pattern.compile("\\w+").matcher("");

	public static void parseInput(String input, ProgramRepository repo) {
		for (String line : input.split("\\n"))
			parseLine(line, repo);
	}

	private static void parseLine(String line, ProgramRepository repo) {
		String[] words = line.split(" ");

		// Insert the program before the ->
		numberMatcher.reset(words[1]);
		numberMatcher.find();
		int weight = Integer.parseInt(numberMatcher.group());
		Program p = repo.getProgram(words[0]);
		p.setWeight(weight);

		// Set the other programs as children
		if (line.contains(" -> ")) {
			for (int index = 3; index < words.length; index++) {
				nameMatcher.reset(words[index]);
				nameMatcher.find();
				Program child = repo.getProgram(nameMatcher.group());
				p.addToDisc(child);
			}
		}
	}
}
