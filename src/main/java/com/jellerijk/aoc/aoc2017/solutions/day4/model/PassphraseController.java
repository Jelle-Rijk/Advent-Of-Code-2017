package com.jellerijk.aoc.aoc2017.solutions.day4.model;

import java.util.ArrayList;
import java.util.List;

import com.jellerijk.aoc.aoc2017.common.observer.Publisher;
import com.jellerijk.aoc.aoc2017.common.observer.Subscriber;
import com.jellerijk.aoc.aoc2017.solutions.day4.model.impl.HeightenedPolicy;
import com.jellerijk.aoc.aoc2017.solutions.day4.model.impl.StandardPolicy;

public class PassphraseController implements Publisher {
	private static PassphraseController instance;

	private PassphraseRepository passRepo;
	private List<Subscriber> subs;

	private PassphraseController() {
		this.subs = new ArrayList<Subscriber>();
		this.passRepo = new PassphraseRepository();
	}

	public static PassphraseController getInstance() {
		if (instance == null)
			instance = new PassphraseController();
		return instance;
	}

	public void enterPassphrases(String input) {
		passRepo.clear();
		for (String phrase : input.split("\n"))
			addPassphrase(new Passphrase(phrase));
		updateSubs();
	}

	private void addPassphrase(Passphrase passphrase) {
		passRepo.addPassphrase(passphrase);
	}

	public int countValid(boolean heightenedPolicy) {
		PassphrasePolicy policy = heightenedPolicy ? new HeightenedPolicy() : new StandardPolicy();
		return passRepo.countValid(policy);
	}

	@Override
	public List<Subscriber> getSubscribers() {
		return subs;
	}

}
