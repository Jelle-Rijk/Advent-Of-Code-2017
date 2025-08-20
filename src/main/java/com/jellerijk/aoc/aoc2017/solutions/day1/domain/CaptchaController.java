package com.jellerijk.aoc.aoc2017.solutions.day1.domain;

import java.util.ArrayList;
import java.util.List;

import com.jellerijk.aoc.aoc2017.common.observer.Publisher;
import com.jellerijk.aoc.aoc2017.common.observer.Subscriber;

public class CaptchaController implements Publisher {
	private static CaptchaController instance;

	private Captcha captcha;
	private List<Subscriber> subs;

	private CaptchaController() {
		this.subs = new ArrayList<Subscriber>();

	}

	public static CaptchaController getInstance() {
		if (instance == null)
			instance = new CaptchaController();
		return instance;
	}

	public void submitInput(String input) {
		captcha = new CaptchaImpl(input);
		updateSubs();
	}

	public long getSumOfDoubles() {
		return captcha.getSumOfDoubles();
	}

	public long getSumOfOpposites() {
		return captcha.getSumOfOpposites();
	}

	@Override
	public List<Subscriber> getSubscribers() {
		return subs;
	}
}
