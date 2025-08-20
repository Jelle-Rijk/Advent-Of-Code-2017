package com.jellerijk.aoc.aoc2017.solutions.day4.model.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.jellerijk.aoc.aoc2017.solutions.day4.model.Passphrase;
import com.jellerijk.aoc.aoc2017.solutions.day4.model.PassphrasePolicy;

public class HeightenedPolicy implements PassphrasePolicy {

	@Override
	public boolean isValid(Passphrase passphrase) {
		String[] words = passphrase.getWords();
		List<String> sortedWords = new ArrayList<String>();

		for (String word : words) {
			sortedWords.add(rewriteAlphabetically(word));
		}
		int uniqueSortedWords = (int) sortedWords.stream().distinct().count();
		return words.length == uniqueSortedWords;
	}

	private String rewriteAlphabetically(String word) {
		char[] chars = word.toCharArray();
		Arrays.sort(chars);
		return new String(chars);
	}

}
