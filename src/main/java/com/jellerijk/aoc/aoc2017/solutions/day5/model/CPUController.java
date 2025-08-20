package com.jellerijk.aoc.aoc2017.solutions.day5.model;

import java.util.ArrayList;
import java.util.List;

import com.jellerijk.aoc.aoc2017.common.observer.Publisher;
import com.jellerijk.aoc.aoc2017.common.observer.Subscriber;
import com.jellerijk.aoc.aoc2017.solutions.day5.model.impl.CPUImpl;
import com.jellerijk.aoc.aoc2017.solutions.day5.model.impl.InstructionImpl;

public class CPUController implements Publisher {
	private static CPUController instance;
	private final List<Subscriber> subs;

	private CPU cpu;

	private CPUController() {
		this.subs = new ArrayList<Subscriber>();
	}

	public static CPUController getInstance() {
		if (instance == null)
			instance = new CPUController();
		return instance;
	}

	public void createInstruction(String input, boolean strangeJumps) {
		String[] lines = input.split("\n");
		int[] instructions = new int[lines.length];
		
		int index = 0;
		for (String line : input.split("\n")) {
			try {
				instructions[index] = Integer.parseInt(line);
				index++;
			} catch (NumberFormatException nfe) {
				throw new IllegalArgumentException(String.format("Instruction on line %d is not an integer.", index));
			}
		}

		cpu = new CPUImpl(new InstructionImpl(instructions));
		cpu.run(strangeJumps);
		updateSubs();
	}

	@Override
	public List<Subscriber> getSubscribers() {
		return subs;
	}

	public int getCPUCycles() {
		return cpu.getCPUCycles();
	}

}
