package com.jellerijk.aoc.aoc2017.solutions.day7.controllers;

import com.jellerijk.aoc.aoc2017.solutions.day7.model.ProgramDTO;

public interface ProgramController {
	public static ProgramController getInstance() {
		return ProgramControllerImpl.getInstance();
	}

	public void parsePuzzleInput(String input);

	public ProgramDTO getRootProgram();

	public ProgramDTO getFaultyProgram();

}
