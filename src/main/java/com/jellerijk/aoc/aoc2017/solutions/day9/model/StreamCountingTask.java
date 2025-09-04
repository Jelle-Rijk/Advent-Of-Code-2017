package com.jellerijk.aoc.aoc2017.solutions.day9.model;

import java.time.Duration;
import java.time.Instant;

import javafx.concurrent.Task;

public class StreamCountingTask extends Task<StreamCountResults> {

	private final String data;

	public StreamCountingTask(String data) {
		this.data = data;
	}

	@Override
	protected StreamCountResults call() throws Exception {
		long groups = 0, groupScore = 0, garbage = 0, level = 0;
		Instant start = Instant.now();

		StreamCountState oldState = StreamCountState.DEFAULT;
		// ALGORITHM
		for (int i = 0; i < data.length(); i++) {
			char currentChar = data.charAt(i);

			// Ignore this character
			if (oldState == StreamCountState.IGNORE) {
				oldState = StreamCountState.DEFAULT;
				continue;
			} else if (oldState == StreamCountState.IGNORE_GARBAGE) {
				oldState = StreamCountState.GARBAGE;
				continue;
			}

			StreamCountState newState = oldState.nextState(currentChar);
			switch (newState) {
			case StreamCountState.GROUP_OPEN:
				level++;
				groups++;
				break;
			case StreamCountState.GROUP_CLOSE:
				System.out.println(level);
				groupScore += level;
				level--;
				break;
			case StreamCountState.GARBAGE:
				if (newState == oldState && currentChar != '>')
					garbage++;
				break;
			default:
				break;
			}

			oldState = newState;
		}

		// PREPARE RETURN OBJECT
		Instant finish = Instant.now();
		long timeElapsed = Duration.between(start, finish).toMillis();

		return new StreamCountResults(groups, groupScore, garbage, timeElapsed);
	}

}
