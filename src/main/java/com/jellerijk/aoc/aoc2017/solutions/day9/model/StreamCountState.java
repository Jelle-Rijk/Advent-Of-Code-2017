package com.jellerijk.aoc.aoc2017.solutions.day9.model;

import java.util.HashMap;
import java.util.Map;

public enum StreamCountState {
	DEFAULT, GROUP_OPEN, GROUP_CLOSE, GARBAGE, IGNORE, IGNORE_GARBAGE;

	private final Map<Character, StreamCountState> transitions = new HashMap<Character, StreamCountState>();

	static {
		DEFAULT.addTransition('{', GROUP_OPEN); // OPEN the group
		DEFAULT.addTransition('}', GROUP_CLOSE);
		DEFAULT.addTransition('<', GARBAGE);
		DEFAULT.addTransition('!', IGNORE);

		GROUP_OPEN.addTransition('}', GROUP_CLOSE); // CLOSES the group immediately
		GROUP_OPEN.addTransition('<', GARBAGE); // Start the GARBAGE sequence
		GROUP_OPEN.addTransition('!', IGNORE); // Ignore next character
		GROUP_OPEN.addTransition(',', DEFAULT); // Skip to next character

		GROUP_CLOSE.addTransition('{', GROUP_OPEN); //
		GROUP_CLOSE.addTransition('<', GARBAGE);
		GROUP_CLOSE.addTransition('!', IGNORE);
		GROUP_CLOSE.addTransition(',', DEFAULT);

		// When in garbage skip everything until >. Ignore > if ! shows up.
		GARBAGE.addTransition('!', IGNORE_GARBAGE);
		GARBAGE.addTransition('>', DEFAULT);

		IGNORE.addTransition('{', GROUP_OPEN); // OPEN the group
		IGNORE.addTransition('}', GROUP_CLOSE);
		IGNORE.addTransition('<', GARBAGE);
		IGNORE.addTransition('!', IGNORE);
	}

	private void addTransition(char c, StreamCountState nextState) {
		transitions.put(c, nextState);
	}

	// Returns the next state or the same state if no transition is found in the
	// transitions HashMap
	public StreamCountState nextState(char c) {
		return transitions.getOrDefault(c, this);
	}

}
