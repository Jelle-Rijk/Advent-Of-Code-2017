package com.jellerijk.aoc.aoc2017.common.datastructures.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Tree<T> {
	List<TreeNode<T>> nodes;

	public Tree() {
		nodes = new ArrayList<TreeNode<T>>();
	}

	/**
	 * Adds a new TreeNode containing the data to the tree.
	 * 
	 * @param data The data that the node should contain.
	 */
	public void addNode(T data) {
		TreeNode<T> node = new TreeNode<T>(data);
		nodes.add(node);
	}

	/**
	 * Searches the tree for any nodes holding the data.
	 * 
	 * @param data The data for which to find nodes.
	 * @return A list of nodes containing the given data.
	 */
	public List<TreeNode<T>> search(T data) throws IllegalArgumentException {
		List<TreeNode<T>> results = nodes.stream().filter(node -> node.getData().equals(data))
				.collect(Collectors.toList());
		if (results.isEmpty())
			throw new IllegalArgumentException("Could not find any node matching the given data.");
		return results;
	}

	public TreeNode<T> getRoot() {
		return nodes.stream().filter(node -> node.getType() == TreeNodeType.ROOT).findAny().orElseThrow();
	}
}
