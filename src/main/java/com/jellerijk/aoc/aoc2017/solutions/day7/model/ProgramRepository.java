package com.jellerijk.aoc.aoc2017.solutions.day7.model;

import java.util.HashSet;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.Set;

import com.jellerijk.aoc.aoc2017.solutions.day7.model.impl.ProgramImpl;

public class ProgramRepository {
	Set<Program> programs;

	public ProgramRepository() {
		programs = new HashSet<Program>();
	}

	public void addProgram(Program p) {
		if (!programs.add(p)) {
			getProgram(p.getName()).setWeight(p.getWeight());
		}
	}

	/**
	 * Returns the program with the given name. If the program does not exist this
	 * function will create it and return the newly made program.
	 * 
	 * @param name
	 * @return
	 */
	public Program getProgram(String name) {
		try {
			return programs.stream().filter(program -> program.getName().equals(name)).findAny().orElseThrow();
		} catch (NoSuchElementException nse) {
			Program p = new ProgramImpl(name);
			addProgram(p);
			return p;
		}
	}

	/**
	 * Returns an optional parent program for the given child
	 * 
	 * @param child
	 * @return The child's parent program, if any exist.
	 */
	public Optional<Program> getParent(Program child) {
		return programs.stream().filter(program -> program.isParentOf(child)).findAny();
	}

	/**
	 * Returns the root program
	 * 
	 * @return The root program.
	 */
	public Program getRoot() {
		Program currentNode = programs.stream().findAny().orElseThrow();
		boolean stop = getParent(currentNode).isEmpty();

		do {
			Optional<Program> parent = getParent(currentNode);
			if (parent.isPresent()) {
				currentNode = parent.get();
			} else {
				stop = true;
			}
		} while (!stop);
		return currentNode;
	}

	public ProgramDTO findFaultyProgram() {
		try {
			// Find the faulty program by looking for a balanced program with an unbalanced
			// parent.
			Program faultyProgram = programs.stream().filter(program -> {
				System.out.printf("Checking: %s%n", program.toString());
				if (!program.isBalanced())
					return false;
				System.out.printf("\tBalanced%n");
				Optional<Program> parent = getParent(program);
				if (parent.isPresent() && !parent.get().isBalanced()) {
					return parent.get().calculateCorrectChildWeight() != program.calculateTotalWeight();
				}
				return false;
			}).findAny().orElseThrow();

			// Calculate the needed information about the faulty program
			int correctTotalWeight = getParent(faultyProgram).get().calculateCorrectChildWeight();
			int faultyTotalWeight = faultyProgram.calculateTotalWeight();
			int correctedWeight = faultyProgram.getWeight() + (correctTotalWeight - faultyTotalWeight);

			return new ProgramDTO(faultyProgram.getName(), faultyProgram.getWeight(), correctedWeight);
		} catch (

		NoSuchElementException nse) {
			System.err.println("No faulty program was found");
		}
		return null;

	}

	public void clear() {
		programs.clear();
	}

}
