package com.jellerijk.aoc.aoc2017.solutions.day9.model;

public class DataStreamImpl implements DataStream {
	private final String data;

	private StreamCountResults results;

	public DataStreamImpl(String data) {
		validateData(data);
		this.data = data;
	}

	@Override
	public String getData() {
		return data;
	}

	private void count() {
		try {
			results = new StreamCountingTask(data).call();
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println("Something went wrong while counting the groups and garbage.");
		}
	}

	@Override
	public long getGroupCount() {
		if (results == null)
			count();
		return results.groups();
	}

	@Override
	public long getGarbageCount() {
		if (results == null)
			count();
		return results.garbage();
	}

	@Override
	public long getProcessingTime() {
		if (results == null)
			count();
		return results.time();
	}

	/**
	 * PRIVATE METHODS
	 */
	private void validateData(String data) {
		if (data.length() == 0)
			return;
		if (data.charAt(0) != '{')
			throw new IllegalArgumentException(
					"Data is not in a valid format. Make sure it starts with { and ends with }");
	}

	@Override
	public long getGroupScore() {
		if (results == null)
			count();
		return results.groupScore();
	}

}
