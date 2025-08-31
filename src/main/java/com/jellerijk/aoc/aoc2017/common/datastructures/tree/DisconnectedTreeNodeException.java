package com.jellerijk.aoc.aoc2017.common.datastructures.tree;

public class DisconnectedTreeNodeException extends RuntimeException {

	private static final long serialVersionUID = -7334028460382322597L;
	private final static String DEFAULT_MESSAGE = "This node is not connected to any other node.";

	public DisconnectedTreeNodeException() {
		super(DEFAULT_MESSAGE);
	}

	public DisconnectedTreeNodeException(String message) {
		super(message);
	}

	public DisconnectedTreeNodeException(String message, Throwable cause) {
		super(message, cause);
	}

	public DisconnectedTreeNodeException(Throwable cause) {
		super(DEFAULT_MESSAGE, cause);
	}
}
