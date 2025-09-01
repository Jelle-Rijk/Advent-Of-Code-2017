package com.jellerijk.aoc.aoc2017.solutions.day8.model;

import java.util.Collection;

public interface RAM {
	public int fetch(String register);

	public void write(String register, int value);

	public Collection<Register> getRegisters();

	public int calculateHighestRegisterValue();

	public void clear();

	public int getRecordValue();

}
