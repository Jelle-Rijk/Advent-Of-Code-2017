package com.jellerijk.aoc.aoc2017.launcher.domain.solution;

import java.util.ArrayList;
import java.util.List;

import com.jellerijk.aoc.aoc2017.solutions.day1.Day1;
import com.jellerijk.aoc.aoc2017.solutions.day2.Day2;

public abstract class SolutionsDictionary {

	public static List<Solution> getSolutions() {
		List<Solution> solutions = new ArrayList<Solution>();

		solutions.add(new Day1());
		solutions.add(new Day2());

		return solutions;
	}

}
