package com.jellerijk.aoc.aoc2017.launcher.domain.solution;

import java.util.List;

public class SolutionsRepository {
	private List<Solution> solutions;

	public SolutionsRepository() {
		this.solutions = SolutionsDictionary.getSolutions();
	}

	public List<Solution> getSolutions() {
		return solutions;
	}

}
