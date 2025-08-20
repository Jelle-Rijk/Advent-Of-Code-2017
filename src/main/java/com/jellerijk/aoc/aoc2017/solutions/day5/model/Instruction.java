package com.jellerijk.aoc.aoc2017.solutions.day5.model;

public interface Instruction {
	/**
	 * Gets the jump instruction from the code at given index.
	 * 
	 * @param index - the jump instruction to get
	 * @return the distance the cpu needs to jump
	 */
	public int getJump(int index);

	/**
	 * Sets the jump instruction at the given index.
	 * 
	 * @param index
	 * @param value
	 */
	public void setInstruction(int index, int value);

	public int getInstructionLength();

}
