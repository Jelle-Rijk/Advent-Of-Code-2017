package com.jellerijk.aoc.aoc2017.solutions.day6.controllers;

import java.util.ArrayList;
import java.util.List;

import com.jellerijk.aoc.aoc2017.solutions.day6.model.Duplicate;
import com.jellerijk.aoc.aoc2017.solutions.day6.model.MemoryAllocator;
import com.jellerijk.aoc.aoc2017.solutions.day6.model.MemoryBank;
import com.jellerijk.aoc.aoc2017.solutions.day6.model.impl.MemoryAllocatorImpl;
import com.jellerijk.aoc.aoc2017.solutions.day6.model.impl.MemoryBankImpl;

public class MemoryControllerImpl implements MemoryController {

	private static MemoryControllerImpl instance;
	private List<Integer> blockCounts;
	private MemoryAllocator allocator;

	private MemoryControllerImpl() {
	}

	public static MemoryControllerImpl getInstance() {
		if (instance == null)
			instance = new MemoryControllerImpl();
		return instance;
	}

	@Override
	public void setPuzzleInput(List<Integer> blockCounts) {
		this.blockCounts = blockCounts;
	}

	@Override
	public void runAllocator() {
		int number = 0;
		List<MemoryBank> banks = new ArrayList<MemoryBank>();
		for (int blockCount : blockCounts) {
			MemoryBank bank = new MemoryBankImpl(number, blockCount);
			banks.add(bank);
			number++;
		}
		allocator = new MemoryAllocatorImpl(banks);
		allocator.run();

	}

	@Override
	public Duplicate getFirstDuplicate() {
		if (allocator == null)
			throw new IllegalArgumentException("Allocator has not run yet");
		return allocator.getFirstDuplicate();
	}
}
