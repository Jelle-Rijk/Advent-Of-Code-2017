package com.jellerijk.aoc.aoc2017.solutions.day7.model.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.jellerijk.aoc.aoc2017.solutions.day7.model.Program;

public class ProgramImpl implements Program {
	private List<Program> disc;
	private String name;
	private int weight;

	public ProgramImpl(String name) {
		this.name = name;
		disc = new ArrayList<Program>();
	}

	public ProgramImpl(String name, int weight) {
		this(name);
		setWeight(weight);
	}

	@Override
	public List<Program> getDisc() {
		return disc;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public void addToDisc(Program subprogram) {
		disc.add(subprogram);
	}

	@Override
	public boolean isParentOf(Program child) {
		return disc.contains(child);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || o.getClass() != getClass())
			return false;
		ProgramImpl p = (ProgramImpl) o;
		return p.name.equals(name);
	}

	@Override
	public int hashCode() {
		return Objects.hash(name);
	}

	@Override
	public String toString() {
		return String.format("Program %s%s", name,
				weight == 0 ? "" : String.format(" (weight: %d)", calculateTotalWeight()));
	}

	@Override
	public int getWeight() {
		return weight;
	}

	@Override
	public void setWeight(int weight) {
		this.weight = weight;
	}

	@Override
	public int calculateTotalWeight() {
		if (disc.isEmpty()) {
			return weight;
		}
		return disc.stream().mapToInt(child -> child.calculateTotalWeight()).reduce(weight, Integer::sum);
	}

	@Override
	public boolean isBalanced() {
		if (disc.isEmpty())
			return true;
		return disc.stream().mapToInt(child -> child.calculateTotalWeight()).distinct().count() == 1;
	}

	@Override
	public boolean areChildrenBalanced() {
		for (Program child : disc) {
			if (!child.isBalanced())
				return false;
		}
		return true;
	}

	@Override
	public int calculateCorrectChildWeight() {
		if (disc.size() == 2)
			throw new IllegalArgumentException(
					"Cannot calculate the correct weight for a program with exactly 2 children");
		int firstWeight = disc.getFirst().calculateTotalWeight();
		int lastWeight = disc.getLast().calculateTotalWeight();
		if (firstWeight == lastWeight || firstWeight == disc.get(1).calculateTotalWeight())
			return firstWeight;

		int secondWeight = disc.get(1).calculateTotalWeight();
		return firstWeight == secondWeight ? firstWeight : secondWeight;
	}

}
