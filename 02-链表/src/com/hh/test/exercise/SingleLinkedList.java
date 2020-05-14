package com.hh.test.exercise;
  
import com.hh.AbstractList;

public class SingleLinkedList<E> extends AbstractList<E> {
	
	private Node<E>	first;
	
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
		
		if (index == 0) {
			first = new Node<>(element, first);
		} else { 
			Node<E> prev = node(index - 1);
			prev.next = new Node<>(element, prev.next);
		}
		
		size++;
	}

	@Override
	public E remove(int index) { 
		rangeCheck(index);
		
		Node<E> node = first;
		if (index == 0) {
			first = first.next;
		} else {
			Node<E> prev = node(index - 1);
			node = prev.next;
			prev.next = node.next;
		}
		
		size--;
		
		return node.element;
	}

	@Override
	public int indexOf(E element) { 
		
		if (element == null) {
			for (int i = 0; i < size; i++) {
				if (node(i).element == null) {
					return i;
				}
			}
		} else {
			for (int i = 0; i < size; i++) {
				if (node(i).element == element) {
					return i;
				}
			}
		}
		
		return NOT_FOUND_ELEMENTS;
	}
	
	private Node<E> node(int index){ 
		rangeCheck(index);
		
		Node<E> node = first;
		for (int i = 0; i < index; i++) {
			node = node.next;
		}
		
		return node;
	}

}
