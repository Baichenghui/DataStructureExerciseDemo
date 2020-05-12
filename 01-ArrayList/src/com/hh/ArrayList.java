package com.hh;

@SuppressWarnings("unchecked")
public class ArrayList<E> {

	private static final int DEFAULT_CAPACITY = 10;
	private static final int NOT_FOUND_ELEMENTS = -1;
	
	private int size;
	private E[] elements;
	
	public ArrayList() {
		this(DEFAULT_CAPACITY);
	}
	
	public ArrayList(int capacity) {
		if (capacity < DEFAULT_CAPACITY) {
			capacity = DEFAULT_CAPACITY;
		}
		elements = (E[]) new Object[capacity];
	}

	public int size() {
		return size;
	}
	
	public boolean isEmpty() {
		return size == 0;
	}
	
	public boolean contains(E element) { 
		return indexOf(element) != NOT_FOUND_ELEMENTS;
	}
	
	public void add(E element) { 
		add(size, element);
	}
	
	public E get(int index) {
		rangeCheck(index); 
		return elements[index];
	}
	
	public E set(int index, E element) {
		rangeCheck(index);
		E oldElement = elements[index];
		elements[index] = element;
		 
		return oldElement;
	}
	
	public void add(int index, E element) {
		rangeCheckForAdd(index); 
		
		ensureCapacity(size + 1);
 
		for (int i = size; i > index; i--) {
			elements[i] = elements[i-1];
		}
		elements[index] = element;
		size++; 
	}

	public E remove(int index) {
		rangeCheck(index); 
		E oldElement = elements[index];
		for (int i = index + 1; i < size; i++) {
			elements[i - 1] = elements[i];
		}
		elements[size--] = null; 
		return oldElement;
	}
	
	public int indexOf(E element) {
		if (element == null) {
			for (int i = 0; i < size; i++) {
				if (elements[i] == null) {
					return i;
				}
			}
		} else {
			for (int i = 0; i < size; i++) {
				if (element.equals(elements[i])) {
					return i;
				}
			}
		}
		
		return NOT_FOUND_ELEMENTS;
	}
	
	public void clear() {  
		for (int i = 0; i < size; i++) {
			elements[i] = null;
		}
		size = 0;
	}
	
	private void ensureCapacity(int capacity) {
		int oldCapacity = elements.length;
		if (oldCapacity >= capacity) {
			return;
		}
		
		//1.5倍
		int newCapacity = oldCapacity +(oldCapacity >> 1);
		E[] newElements = (E[])new Object[newCapacity];
		for (int i = 0; i < size; i++) {
			newElements[i] = elements[i];
		}
		elements = newElements; 
		
		System.out.println(oldCapacity + "扩容:" + newCapacity);
	}
	
	private void rangeCheck(int index) {
		if (index >= size || index < 0) {
			outOfBounds(index);
		}
	}
	
	private void rangeCheckForAdd(int index) {
		if (index < 0 || index > size) {
			outOfBounds(index);
		}
	}
	
	private void outOfBounds(int index) { 
		throw new IndexOutOfBoundsException("index:"+index +", size:"+size);
	}
	
	@Override
	public String toString() { 
		StringBuilder string = new StringBuilder();
		string.append("size=").append(size).append(", [");
		for (int i = 0; i < size; i++) {
			if (i != 0) {
				string.append(", ");
			}
			
			string.append(elements[i]); 
		}
		string.append("]");
		return string.toString();
	}
}
