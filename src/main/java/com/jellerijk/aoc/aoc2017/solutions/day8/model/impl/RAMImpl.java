package com.jellerijk.aoc.aoc2017.solutions.day8.model.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

import com.jellerijk.aoc.aoc2017.solutions.day8.model.RAM;
import com.jellerijk.aoc.aoc2017.solutions.day8.model.Register;

public class RAMImpl implements RAM {
	HashMap<String, Integer> registers;
	int recordValue;

	public RAMImpl() {
		this.registers = new HashMap<String, Integer>();
	}

	@Override
	public int fetch(String register) {
		if (!registers.containsKey(register))
			registers.put(register, 0);
		return registers.get(register);
	}

	@Override
	public Collection<Register> getRegisters() {
		List<Register> dtos = new ArrayList<Register>();
		registers.forEach((name, value) -> dtos.add(new Register(name, value)));
		return dtos;
	}

	@Override
	public void clear() {
		registers.clear();
		setRecordValue(0);
	}

	@Override
	public int calculateHighestRegisterValue() {
		if (registers == null || registers.isEmpty())
			return 0;
		return registers.values().stream().max(Integer::compare).orElseThrow();
	}

	@Override
	public void write(String register, int value) {
		registers.put(register, value);
		if (value > recordValue)
			setRecordValue(value);
	}

	public int getRecordValue() {
		return recordValue;
	}

	private void setRecordValue(int recordValue) {
		this.recordValue = recordValue;
	}

}
