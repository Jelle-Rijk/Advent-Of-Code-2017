package com.jellerijk.aoc.aoc2017.solutions.day5.model.impl;

import com.jellerijk.aoc.aoc2017.solutions.day5.model.Instruction;

public class InstructionImpl implements Instruction {

	private int[] instructions;

	public InstructionImpl(int[] instructions) {
		this.instructions = instructions;
	}

	@Override
	public int getJump(int index) {
		return instructions[index];
	}

	@Override
	public void setInstruction(int index, int value) {
		instructions[index] = value;
	}

	@Override
	public int getInstructionLength() {
		return instructions.length;
	}

}
