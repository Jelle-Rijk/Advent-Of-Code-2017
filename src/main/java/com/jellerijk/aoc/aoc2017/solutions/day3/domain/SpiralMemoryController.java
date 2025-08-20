package com.jellerijk.aoc.aoc2017.solutions.day3.domain;

import java.util.ArrayList;
import java.util.List;

import com.jellerijk.aoc.aoc2017.common.observer.Publisher;
import com.jellerijk.aoc.aoc2017.common.observer.Subscriber;

public class SpiralMemoryController implements Publisher {
	private List<Subscriber> subs;
	private static SpiralMemoryController instance;

	private int goal;

	private SpiralMemoryController() {
		subs = new ArrayList<Subscriber>();
	}

	public static SpiralMemoryController getInstance() {
		if (instance == null)
			instance = new SpiralMemoryController();
		return instance;
	}

	public void inputGoal(String goal) {
		try {
			this.goal = Integer.parseInt(goal);
			updateSubs();
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException("Please enter a valid integer");
		}
	}

	@Override
	public List<Subscriber> getSubscribers() {
		return subs;
	}

	public int getManhattanDistance() throws Exception {
		return new ManhattanDistanceTask(goal).call();
	}

	public int getSmallestLargerNumber() {
		return 0;
	}

}
