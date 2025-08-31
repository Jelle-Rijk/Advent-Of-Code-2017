package com.jellerijk.aoc.aoc2017.solutions.day7.model;

public record ProgramDTO(String name, int weight, int correctedWeight) {
	public ProgramDTO(String name, int weight) {
		this(name, weight, weight);
	}
}
