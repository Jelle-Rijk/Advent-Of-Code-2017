package com.jellerijk.aoc.aoc2017.solutions.day9.controller;

import java.util.ArrayList;
import java.util.List;

import com.jellerijk.aoc.aoc2017.common.observer.Publisher;
import com.jellerijk.aoc.aoc2017.common.observer.Subscriber;

public class StreamAnalysisController implements Publisher {
	private String stream;
	private final List<Subscriber> subs;

	public StreamAnalysisController() {
		subs = new ArrayList<Subscriber>();
	}

	public void setStream(String stream) {
		this.stream = stream;
		updateSubs();
	}

	@Override
	public List<Subscriber> getSubscribers() {
		return subs;
	}

}
