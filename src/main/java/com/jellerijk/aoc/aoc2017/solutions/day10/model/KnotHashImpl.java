package com.jellerijk.aoc.aoc2017.solutions.day10.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class KnotHashImpl implements KnotHash {
	public final static int HASH_LENGTH = 256;
	private List<Integer> values;
	private int skipSize;
	private int currentPosition;

	/*
	 * CONSTRUCTORS
	 */
	public KnotHashImpl() {
		this(0, 0, initValues());
	}

	public KnotHashImpl(int currentPosition, int skipSize, List<Integer> values) {
		setValues(values);
		setCurrentPosition(currentPosition);
		setSkipSize(skipSize);
	}

	/*
	 * PUBLIC METHODS
	 */

	@Override
	public int get(int index) {
		if (index >= HASH_LENGTH)
			throw new IllegalArgumentException(
					String.format("Index needs to be in the interval [0,%d], was %d", HASH_LENGTH, index));
		return values.get(index);
	}

	@Override
	public String toString() {
		return values.stream().map(value -> {
			if (get(currentPosition) == value)
				return String.format("[%d]", value);
			return value.toString();
		}).collect(Collectors.joining(" "));
	}

	@Override
	public List<Integer> calculateSparseHash(List<Integer> lengths) {
		lengths.forEach(length -> twist(length));
		return values;
	}

	/*
	 * PRIVATE METHODS
	 */

	private void twist(int length) {
		if (length > HASH_LENGTH)
			throw new IllegalArgumentException(
					String.format("Cannot twist with a length longer than the hash's length"));

		List<Integer> right = values.subList(currentPosition, values.size());
		List<Integer> left = values.subList(0, currentPosition);
		List<Integer> combined = Stream.of(right, left).flatMap(Collection::stream)
				.collect(Collectors.toCollection(ArrayList::new));
		reverse(combined, length);
		right = combined.subList(0, right.size());
		left = combined.subList(right.size(), combined.size());
		setValues(Stream.of(left, right).flatMap(Collection::stream).collect(Collectors.toCollection(ArrayList::new)));

		moveToNextPosition(length);
	}

	private void reverse(List<Integer> list, int length) {
		for (int firstIndex = 0; firstIndex < length / 2; firstIndex++) {
			int secondIndex = length - firstIndex - 1;
			int firstElement = list.get(firstIndex);
			list.set(firstIndex, list.get(secondIndex));
			list.set(secondIndex, firstElement);
		}
	}

	private static List<Integer> initValues() {
		List<Integer> values = new ArrayList<Integer>(HASH_LENGTH);
		for (int value = 0; value < HASH_LENGTH; value++) {
			values.add(value);
		}
		return values;
	}

	private void moveToNextPosition(int length) {
		int newPosition = (currentPosition + length + skipSize) % HASH_LENGTH;
		setCurrentPosition(newPosition);
		skipSize++;
	}

	/*
	 * GETTERS - SETTERS
	 */
	private void setValues(List<Integer> values) {
		if (values.size() != HASH_LENGTH)
			throw new IllegalArgumentException(String.format("KnotHashes need %d values", HASH_LENGTH));
		this.values = values;
	}

	public int getCurrentPosition() {
		return currentPosition;
	}

	private void setCurrentPosition(int currentPosition) {
		this.currentPosition = currentPosition;
	};

	public int getSkipSize() {
		return skipSize;
	}

	public List<Integer> getValues() {
		return values;
	}

	private void setSkipSize(int skipSize) {
		this.skipSize = skipSize;
	}

}
