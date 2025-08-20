package com.jellerijk.aoc.aoc2017.solutions.day4.model.impl;

import java.util.Arrays;

import com.jellerijk.aoc.aoc2017.solutions.day4.model.Passphrase;
import com.jellerijk.aoc.aoc2017.solutions.day4.model.PassphrasePolicy;

public class StandardPolicy implements PassphrasePolicy {

	@Override
	public boolean isValid(Passphrase passphrase) {
		String[] words = passphrase.getWords();
		int distinctWordCount = (int) Arrays.stream(words).distinct().count();
		return words.length == distinctWordCount;
	}

}
