package com.jellerijk.aoc.aoc2017.solutions.day6.model.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.jellerijk.aoc.aoc2017.solutions.day6.model.AllocatorHistory;
import com.jellerijk.aoc.aoc2017.solutions.day6.model.Duplicate;
import com.jellerijk.aoc.aoc2017.solutions.day6.model.MemoryAllocator;
import com.jellerijk.aoc.aoc2017.solutions.day6.model.MemoryBank;

public class MemoryAllocatorImpl implements MemoryAllocator {
	private final AllocatorHistory history;
	private List<MemoryBank> banks;

	public MemoryAllocatorImpl(List<MemoryBank> banks) {
		this.history = new AllocatorHistoryImpl();
		setBanks(banks);
	}

	@Override
	public void setBanks(List<MemoryBank> banks) {
		if (banks == null || banks.isEmpty())
			throw new IllegalArgumentException("The memory allocator needs at least a single memory bank");
		this.banks = banks;
	}

	@Override
	public List<MemoryBank> getBanks() {
		return banks;
	}

	@Override
	public void run() {
		while (!history.hasDuplicate())
			executeCycle();
	}

	private void executeCycle() {
		int maxBlocks = banks.stream().max(Comparator.comparing(MemoryBank::getBlockCount))
				.map(bank -> bank.getBlockCount()).orElseThrow();
		MemoryBank biggestBank = banks.stream().filter(bank -> bank.getBlockCount() == maxBlocks)
				.min(Comparator.comparing(MemoryBank::getNumber)).orElseThrow();
		Collections.sort(banks, Comparator.comparing(MemoryBank::getNumber));

		int blocks = biggestBank.getBlockCount();
		biggestBank.clear();
		int index = (banks.indexOf(biggestBank) + 1) % banks.size();

		while (blocks > 0) {
			banks.get(index).insertMemoryBlock();
			index = (index + 1) % banks.size();
			blocks--;
		}

		List<Integer> configuration = new ArrayList<Integer>();
		banks.forEach(bank -> configuration.add(bank.getBlockCount()));
		history.addCycle(configuration);
	}

	@Override
	public Duplicate getFirstDuplicate() {
		return history.getFirstDuplicate();
	}

}
