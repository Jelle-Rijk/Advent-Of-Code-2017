package com.jellerijk.aoc.aoc2017.solutions.day4.model;

public class Passphrase {

	private String[] words;

	public Passphrase(String phrase) {
		calculateWords(phrase);
	}

	private void calculateWords(String phrase) {
		setWords(phrase.split("\\s+"));
	}

	private void setWords(String[] words) {
		if (words == null || words.length == 0)
			throw new IllegalArgumentException("A passphrase needs at least one word");
		this.words = words;
	}

	public String[] getWords() {
		return words;
	}

}
