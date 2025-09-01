package com.jellerijk.aoc.aoc2017.solutions.day8.controllers;

import java.util.Collection;

import com.jellerijk.aoc.aoc2017.common.observer.Publisher;
import com.jellerijk.aoc.aoc2017.solutions.day8.model.Register;

public interface CPUController extends Publisher {
	public void runProgram(String instructions);

	public Collection<Register> getRegisters();

	public int getHighestRegisterValue();

	public int getRecordValue();

	public static CPUController getInstance() {
		return CPUControllerImpl.getInstance();
	}

}
