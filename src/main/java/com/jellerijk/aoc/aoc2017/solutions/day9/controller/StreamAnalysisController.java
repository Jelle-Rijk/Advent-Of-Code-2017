package com.jellerijk.aoc.aoc2017.solutions.day9.controller;

import java.util.ArrayList;
import java.util.List;

import com.jellerijk.aoc.aoc2017.common.observer.Publisher;
import com.jellerijk.aoc.aoc2017.common.observer.Subscriber;
import com.jellerijk.aoc.aoc2017.solutions.day9.model.DataStream;
import com.jellerijk.aoc.aoc2017.solutions.day9.model.DataStreamImpl;

public class StreamAnalysisController implements Publisher {
	private DataStream stream;
	private static StreamAnalysisController instance;
	private final List<Subscriber> subs;

	private StreamAnalysisController() {
		subs = new ArrayList<Subscriber>();
	}

	public static StreamAnalysisController getInstance() {
		if (instance == null)
			instance = new StreamAnalysisController();
		return instance;
	}

	public void setStream(String stream) {
		this.stream = new DataStreamImpl(stream);
		updateSubs();
	}

	public long getGroupCount() {
		validateStream();
		return stream.getGroupCount();
	}

	public long getGroupScore() {
		validateStream();
		return stream.getGroupScore();
	}

	public long getGarbageCount() {
		validateStream();
		return stream.getGarbageCount();
	}

	public long getProcessingCount() {
		validateStream();
		return stream.getProcessingTime();
	}

	@Override
	public List<Subscriber> getSubscribers() {
		return subs;
	}

	private void validateStream() {
		if (stream == null)
			throw new IllegalArgumentException("Stream was not set yet.");
	}

}
