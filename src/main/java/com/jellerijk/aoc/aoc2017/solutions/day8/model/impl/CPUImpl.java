package com.jellerijk.aoc.aoc2017.solutions.day8.model.impl;

import com.jellerijk.aoc.aoc2017.solutions.day8.model.BinaryOperator;
import com.jellerijk.aoc.aoc2017.solutions.day8.model.CPU;
import com.jellerijk.aoc.aoc2017.solutions.day8.model.CPUInstruction;
import com.jellerijk.aoc.aoc2017.solutions.day8.model.RAM;

public class CPUImpl implements CPU {
	private final RAM ram;

	public CPUImpl(RAM ram) {
		this.ram = ram;
	}

	@Override
	public void execute(CPUInstruction instruction) {
		if (!evaluate(instruction.registerToCheck(), instruction.operator(), instruction.valueToCheck()))
			return;
		
		int newValue = ram.fetch(instruction.registerToModify()) + instruction.shift();
		ram.write(instruction.registerToModify(), newValue);
	}

	private boolean evaluate(String register, BinaryOperator operator, int valueToCheck) {
		int value = ram.fetch(register);

		return switch (operator) {
		case EQUAL -> value == valueToCheck;
		case GREATER_OR_EQUAL -> value >= valueToCheck;
		case GREATER_THAN -> value > valueToCheck;
		case LESS_OR_EQUAL -> value <= valueToCheck;
		case LESS_THAN -> value < valueToCheck;
		case NOT -> value != valueToCheck;
		};
	}
}
