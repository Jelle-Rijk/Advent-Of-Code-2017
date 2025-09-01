package com.jellerijk.aoc.aoc2017.launcher.domain.solution;

import java.util.ArrayList;
import java.util.List;

import com.jellerijk.aoc.aoc2017.solutions.day1.Day1;
import com.jellerijk.aoc.aoc2017.solutions.day2.Day2;
import com.jellerijk.aoc.aoc2017.solutions.day3.Day3;
import com.jellerijk.aoc.aoc2017.solutions.day4.Day4;
import com.jellerijk.aoc.aoc2017.solutions.day5.Day5;
import com.jellerijk.aoc.aoc2017.solutions.day6.Day6;
import com.jellerijk.aoc.aoc2017.solutions.day7.Day7;
import com.jellerijk.aoc.aoc2017.solutions.day8.Day8;

public abstract class SolutionsDictionary {

	public static List<Solution> getSolutions() {
		List<Solution> solutions = new ArrayList<Solution>();

		solutions.add(new Day1());
		solutions.add(new Day2());
		solutions.add(new Day3());
		solutions.add(new Day4());
		solutions.add(new Day5());
		solutions.add(new Day6());
		solutions.add(new Day7());
		solutions.add(new Day8());

		return solutions;
	}

}
