package com.jellerijk.aoc.aoc2017.solutions.day2.domain;

import java.util.ArrayList;
import java.util.List;

import com.jellerijk.aoc.aoc2017.common.observer.Publisher;
import com.jellerijk.aoc.aoc2017.common.observer.Subscriber;
import com.jellerijk.aoc.aoc2017.solutions.day2.domain.impl.SpreadsheetImpl;

public class SpreadsheetController implements Publisher {
	private Spreadsheet spreadsheet;
	private static SpreadsheetController instance;

	private List<Subscriber> subs;

	private SpreadsheetController() {
		this.subs = new ArrayList<Subscriber>();
	}

	public static SpreadsheetController getInstance() {
		if (instance == null)
			instance = new SpreadsheetController();
		return instance;
	}

	public void createSpreadsheet(String input) {
		spreadsheet = new SpreadsheetImpl(InputParser.parseSpreadsheetData(input));
		updateSubs();
	}

	public int getChecksum() throws Exception {
		validateSpreadsheet();
		return (int) spreadsheet.calculateChecksum();
	}

	public int getUserOutput() throws Exception {
		validateSpreadsheet();
		return spreadsheet.getUserResult();
	}

	private void validateSpreadsheet() {
		if (spreadsheet == null)
			throw new IllegalArgumentException("No spreadsheet has been set yet.");
	}

	@Override
	public List<Subscriber> getSubscribers() {
		return subs;
	}

}
