package com.andersen.collectionzz;

import java.util.HashMap;
import java.util.Iterator;

public class CustomHashSet <T> {

	private HashMap<T, Object> map;
	private static final Object PRESENT = new Object();

	public CustomHashSet() {
		map = new HashMap<>();
	}

	public Iterator<T> iterator() {
		return map.keySet().iterator();
	}

	public boolean contains(Object o) {
		return map.containsKey(o);
	}

	public boolean add(T e) {
		return map.put(e, PRESENT) == null;
	}

	public boolean remove(T e) {
		return map.remove(e) == PRESENT;
	}

	@Override
	public String toString() {
		return map.keySet().toString();
	}
}
