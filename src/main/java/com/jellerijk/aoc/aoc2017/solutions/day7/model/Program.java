package com.jellerijk.aoc.aoc2017.solutions.day7.model;

import java.util.List;

public interface Program {
	public List<Program> getDisc();

	public String getName();

	public int calculateTotalWeight();

	public int getWeight();

	public void setWeight(int weight);

	public void addToDisc(Program subprogram);

	public boolean isParentOf(Program child);

	/**
	 * Returns whether this tower is balanced.
	 * 
	 * @return
	 */
	public boolean isBalanced();

	/**
	 * Returns whether all of this tower's children are balanced.
	 * 
	 * @return
	 */
	public boolean areChildrenBalanced();

	public int calculateCorrectChildWeight();
}
