package com.jellerijk.aoc.aoc2017.common.observer;

import java.util.List;

public interface Publisher {
	public List<Subscriber> getSubscribers();

	public default void subscribe(Subscriber sub) {
		getSubscribers().add(sub);
	}

	public default void unsubscribe(Subscriber sub) {
		getSubscribers().remove(sub);
	}

	public default void updateSubs() {
		getSubscribers().forEach(sub -> sub.update());
	}

}
