package com.jellerijk.aoc.aoc2017.solutions.day8.model;

import java.util.Map;

public record CPUInstruction(String registerToModify, int shift, String registerToCheck, BinaryOperator operator,
		int valueToCheck) {

	private static final Map<String, BinaryOperator> OPERATOR_MAP = Map.of("<=", BinaryOperator.LESS_OR_EQUAL, ">=",
			BinaryOperator.GREATER_OR_EQUAL, "<", BinaryOperator.LESS_THAN, ">", BinaryOperator.GREATER_THAN, "==",
			BinaryOperator.EQUAL, "!=", BinaryOperator.NOT);

	public static CPUInstruction fromString(String instruction) {
		if (!instruction.matches("^\\w+ (dec|inc) -?\\d+ if \\w+ (<=?|>=?|==|!=) -?\\d+$"))
			throw new IllegalArgumentException(String.format("Invalid instruction: %s", instruction));

		String[] parts = instruction.split(" ");

		String registerToModify = parts[0];
		int shift = parts[1].equals("dec") ? -Integer.parseInt(parts[2]) : Integer.parseInt(parts[2]);
		String registerToCheck = parts[4];
		BinaryOperator operator = OPERATOR_MAP.get(parts[5]);
		if (operator == null)
			throw new IllegalArgumentException(String.format("Unknown operator in instruction: %s", instruction));
		int valueToCheck = Integer.parseInt(parts[6]);

		return new CPUInstruction(registerToModify, shift, registerToCheck, operator, valueToCheck);
	}
}
