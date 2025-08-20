package com.jellerijk.aoc.aoc2017.solutions.day1.domain;

import java.util.Arrays;

public class CaptchaImpl implements Captcha {
	private int[] digits;

	public CaptchaImpl(String digits) {
		calculateDigits(digits);
	}

	@Override
	public long getSumOfDoubles() {
		long result = 0;

		for (int i = 0; i < digits.length; i++) {
			if (digits[i] == digits[(i + 1) % digits.length])
				result += digits[i];
		}
		return result;
	}

	@Override
	public long getSumOfOpposites() {
		long result = 0;

		for (int i = 0; i < digits.length; i++) {
			if (digits[i] == digits[(i + digits.length / 2) % digits.length])
				result += digits[i];
		}

		return result;
	}

	private void calculateDigits(String input) {
		if (input == null || !input.matches("\\d+"))
			throw new IllegalArgumentException("Invalid captcha");

		int[] digits = Arrays.stream(input.split("")).mapToInt(string -> Integer.parseInt(string)).toArray();
		setDigits(digits);
	}

	private void setDigits(int[] digits) {
		this.digits = digits;
	}

}
