package com.andersen.collectionzz;

import java.util.ArrayList;
import java.util.Arrays;

public class CustomArrayList<T> {

	private int size;

	private static final int DEFAULT_CAPACITY = 10;

	private static final Object[] EMPTY_ELEMENT_DATA= {};

	private Object[] elements;

	public CustomArrayList() {
		this.elements = new Object[DEFAULT_CAPACITY];
	}

	public CustomArrayList(int initialCapacity) {
		if (initialCapacity > 0) {
			this.elements = new Object[initialCapacity];
		} else if (initialCapacity == 0) {
			this.elements = EMPTY_ELEMENT_DATA;
		} else {
			throw new IllegalArgumentException("Illegal Capacity: " + initialCapacity);
		}
	}

	public T get(int index) {
		if (index >= capacity() || index < 0) {
			throw new IndexOutOfBoundsException("index: " + index +", size" + capacity());
		}
		return (T) elements[index];
	}

	public void add(T element) {
		if (size == capacity()) {
			grow();
		}
		elements[size++] = element;
	}

	public int size() {
		return size;
	}

	public void remove (int index) {

		if (index >= size || index < 0) {
			throw new IndexOutOfBoundsException("index: " + index +", size: " + size);
		}

		var newArray = shrink();

		for (int i = 0; i < size; i++) {
			if (i == index) {
				continue;
			}
			newArray[i] = elements[i];
		}
		size--;
		elements = Arrays.copyOf(newArray, newArray.length);
	}

	public boolean contains(Object o) {
		int start = 0;
		int end = size;
		if (o != null) {
			for (int i = start; i < end; i++) {
				if (o.equals(elements[i])) {
					return true;
				}
			}
		}
		return false;
	}

	private Object[] shrink() {
		Object[] array = new Object[capacity() -1];
		return array;
	}

	private void grow() {
		int newCapacity = capacity() * 2;
		elements = Arrays.copyOf(elements, newCapacity);

	}

	private int capacity() {
		return elements.length;
	}

	@Override
	public String toString() {
		return Arrays.toString(Arrays.copyOfRange(elements, 0, size));
	}
}
