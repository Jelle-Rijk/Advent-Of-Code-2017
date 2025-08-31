package com.jellerijk.aoc.aoc2017.solutions.day6.model.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.jellerijk.aoc.aoc2017.solutions.day6.model.AllocatorHistory;
import com.jellerijk.aoc.aoc2017.solutions.day6.model.Duplicate;

public class AllocatorHistoryImpl implements AllocatorHistory {
	private int cycle;
	private final HashMap<List<Integer>, List<Integer>> history;

	private Duplicate firstDuplicate;

	public AllocatorHistoryImpl() {
		this.cycle = 1;
		this.history = new HashMap<List<Integer>, List<Integer>>();
	}

	@Override
	public void addCycle(List<Integer> configuration) {
		if (history.containsKey(configuration)) {
			history.get(configuration).add(cycle);
			if (firstDuplicate == null)
				setFirstDuplicate(configuration, history.get(configuration));
		} else {
			List<Integer> cycles = new ArrayList<Integer>();
			cycles.add(cycle);
			history.put(configuration, cycles);
		}
//		System.out.printf("Cycle: %d -> %s%n", cycle,
//				configuration.stream().map(integer -> Integer.toString(integer)).collect(Collectors.joining(", ")));
		cycle++;
	}

	public boolean hasDuplicate() {
		return firstDuplicate != null;
	}

	public void setFirstDuplicate(List<Integer> configuration, List<Integer> cycles) {
		int originalCycle = cycles.stream().min(Integer::compare).orElseThrow();
		cycles.remove(cycles.indexOf(originalCycle));
		this.firstDuplicate = new Duplicate(configuration, originalCycle, cycles);

	}

	@Override
	public Duplicate getFirstDuplicate() {
		return firstDuplicate;
	}

}
