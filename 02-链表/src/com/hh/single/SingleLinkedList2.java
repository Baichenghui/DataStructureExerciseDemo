package com.hh.single;

import com.hh.AbstractList; 

public class SingleLinkedList2<E> extends AbstractList<E> {
	
	private Node<E> first;
	
	public SingleLinkedList2() {
		first = new Node<>(null, null);
	}
	
	private static class Node<E> {
		E element;
		Node<E> next;
		
		public Node(E element,Node<E> next) {
			 this.element = element;
			 this.next = next;
		}
	}

	@Override
	public void clear() {
		first = null;
		size = 0;
	}

	@Override
	public E get(int index) { 
		return node(index).element;
	}

	@Override
	public E set(int index, E element) {
		rangeCheck(index);
		
		Node<E> node = node(index);
		E old = node.element;
		node.element = element; 
		
		return old;
	}

	@Override
	public void add(int index, E element) {
		rangeCheckForAdd(index);
   
		Node<E>	prev = index == 0 ? first : node(index - 1);
		prev.next = new Node<>(element,prev.next);
		
		size++;
	}

	@Override
	public E remove(int index) {
		rangeCheck(index);

		Node<E>	prev = index == 0 ? first : node(index - 1);
		Node<E> node = prev.next;
		prev.next = node.next;
		 
		size--;
		
		return node.element;
	}

	@Override
	public int indexOf(E element) {
		if (element == null) { 
			for (int i = 0; i < size; i++) {
				Node<E> node = node(i);
				if (node.element == null) {
					return i;
				}
			}
		} else {
			for (int i = 0; i < size; i++) {
				Node<E> node = node(i);
				if (node.element.equals(element)) {
					return i;
				}
			}
		}
		
		return NOT_FOUND_ELEMENTS;
	}

	private Node<E> node(int index) {
		rangeCheck(index);
		
		Node<E> node = first.next;
		for (int i = 0; i < index; i++) {
			node = node.next;
		}
		
		return node;
	}
}
