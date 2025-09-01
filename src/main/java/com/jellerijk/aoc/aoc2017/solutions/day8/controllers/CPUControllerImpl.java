package com.jellerijk.aoc.aoc2017.solutions.day8.controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import com.jellerijk.aoc.aoc2017.common.observer.Subscriber;
import com.jellerijk.aoc.aoc2017.solutions.day8.model.CPU;
import com.jellerijk.aoc.aoc2017.solutions.day8.model.CPUInstruction;
import com.jellerijk.aoc.aoc2017.solutions.day8.model.RAM;
import com.jellerijk.aoc.aoc2017.solutions.day8.model.Register;
import com.jellerijk.aoc.aoc2017.solutions.day8.model.impl.CPUImpl;
import com.jellerijk.aoc.aoc2017.solutions.day8.model.impl.RAMImpl;

public class CPUControllerImpl implements CPUController {

	private static CPUControllerImpl instance;

	private final RAM ram;
	private final CPU cpu;
	private final List<Subscriber> subscribers;

	private CPUControllerImpl() {
		this.ram = new RAMImpl();
		this.cpu = new CPUImpl(ram);
		this.subscribers = new ArrayList<Subscriber>();

	}

	public static CPUControllerImpl getInstance() {
		if (instance == null)
			instance = new CPUControllerImpl();
		return instance;
	}

	@Override
	public void runProgram(String instructions) {
		ram.clear();
		Arrays.stream(instructions.split("\n")).forEach(str -> {
			CPUInstruction instruction = CPUInstruction.fromString(str);
			cpu.execute(instruction);
		});
		updateSubs();
	}

	@Override
	public Collection<Register> getRegisters() {
		return ram.getRegisters();
	}

	@Override
	public int getHighestRegisterValue() {
		return ram.calculateHighestRegisterValue();
	}

	@Override
	public List<Subscriber> getSubscribers() {
		return this.subscribers;
	}

	@Override
	public int getRecordValue() {
		return ram.getRecordValue();
	}
}
