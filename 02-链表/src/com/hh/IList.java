package com.hh;

public interface IList<E> {

	static final int NOT_FOUND_ELEMENTS = -1;
 
	void clear();
 
	int size();
 
	boolean isEmpty();
 
	boolean contains(E element);
 
	void add(E element);
 
	E get(int index);
 
	E set(int index, E element);
 
	void add(int index, E element);
 
	E remove(int index);
 
	int indexOf(E element);
}
