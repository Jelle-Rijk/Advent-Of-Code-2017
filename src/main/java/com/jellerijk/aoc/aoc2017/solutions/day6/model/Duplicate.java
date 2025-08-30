package com.jellerijk.aoc.aoc2017.solutions.day6.model;

import java.util.List;

public record Duplicate(List<Integer> data, int originalCycle, List<Integer> duplicateCycles) {

}
