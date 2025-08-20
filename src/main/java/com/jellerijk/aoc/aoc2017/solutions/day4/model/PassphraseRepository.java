package com.jellerijk.aoc.aoc2017.solutions.day4.model;

import java.util.ArrayList;
import java.util.List;

public class PassphraseRepository {
	private List<Passphrase> passphrases;

	public PassphraseRepository() {
		this.passphrases = new ArrayList<Passphrase>();
	}

	public void addPassphrase(Passphrase passphrase) {
		passphrases.add(passphrase);
	}

	public int countValid(PassphrasePolicy policy) {
		return (int) passphrases.stream().filter(passphrase -> policy.isValid(passphrase)).count();
	}

	public void clear() {
		this.passphrases = new ArrayList<Passphrase>();
	}

}
