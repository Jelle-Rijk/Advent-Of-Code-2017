package com.jellerijk.aoc.aoc2017.solutions.day5.model.impl;

import com.jellerijk.aoc.aoc2017.solutions.day5.model.CPU;
import com.jellerijk.aoc.aoc2017.solutions.day5.model.Instruction;

public class CPUImpl implements CPU {

	private int cycles;
	private int pointer;
	private final Instruction instructions;

	public CPUImpl(Instruction instructions) {
		if (instructions == null)
			throw new IllegalArgumentException("The CPU needs an instruction set");
		this.instructions = instructions;
	}

	public void run(boolean strangeJumps) {
		int goal = instructions.getInstructionLength();
		while (pointer < goal && pointer >= 0) {
			executeCycle(strangeJumps);
			cycles++;
		}
	}

	public void executeCycle(boolean strangeJumps) {
		int jumpDistance = instructions.getJump(pointer);
		
		if (!strangeJumps || jumpDistance < 3)
			instructions.setInstruction(pointer, jumpDistance + 1);
		else
			instructions.setInstruction(pointer, jumpDistance - 1);
		pointer += jumpDistance;
	}

	@Override
	public int getCPUCycles() {
		return cycles;
	}

}
