package com.jellerijk.aoc.aoc2017.common.datastructures.tree;

import java.util.ArrayList;
import java.util.List;

public class TreeNode<T> {
	private final T data;
	private TreeNode<T> parent;
	private List<TreeNode<T>> children;

	public TreeNode(T data) {
		this.data = data;
	}

	public T getData() {
		return data;
	}

	public List<TreeNode<T>> getChildren() {
		return children;
	}

	public TreeNode<T> getParent() {
		return parent;
	}
	
	public TreeNodeType getType() {
		if (parent == null)
			return TreeNodeType.ROOT;
		if (children == null || children.isEmpty())
			return TreeNodeType.LEAF;
		return TreeNodeType.BRANCH;
	}

	public void addChild(TreeNode<T> child) {
		if (children == null)
			children = new ArrayList<TreeNode<T>>();
		children.add(child);
	}

	public void removeChildren() {
		children = null;
	}

	public void removeParent() {
		setParent(null);
	}

	public void setParent(TreeNode<T> parent) {
		this.parent = parent;
	}


}
