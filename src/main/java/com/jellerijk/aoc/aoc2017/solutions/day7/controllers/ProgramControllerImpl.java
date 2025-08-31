package com.jellerijk.aoc.aoc2017.solutions.day7.controllers;

import com.jellerijk.aoc.aoc2017.solutions.day7.model.InputParser;
import com.jellerijk.aoc.aoc2017.solutions.day7.model.Program;
import com.jellerijk.aoc.aoc2017.solutions.day7.model.ProgramDTO;
import com.jellerijk.aoc.aoc2017.solutions.day7.model.ProgramRepository;

public class ProgramControllerImpl implements ProgramController {

	private static ProgramControllerImpl instance;
	private ProgramRepository repo;

	private ProgramControllerImpl() {
		repo = new ProgramRepository();
	}

	public static ProgramControllerImpl getInstance() {
		if (instance == null)
			instance = new ProgramControllerImpl();
		return instance;
	}

	@Override
	public ProgramDTO getRootProgram() {
		Program root = repo.getRoot();
		return new ProgramDTO(root.getName(), root.getWeight());
	}

	@Override
	public void parsePuzzleInput(String input) {
		repo.clear();
		InputParser.parseInput(input, repo);
	}

	@Override
	public ProgramDTO getFaultyProgram() {
		return repo.findFaultyProgram();
	}

}
