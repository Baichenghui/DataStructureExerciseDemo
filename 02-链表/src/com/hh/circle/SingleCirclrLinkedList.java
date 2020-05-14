package com.hh.circle;

import com.hh.AbstractList; 

/**
 * 单向循环链表  （对比单向链表需要在添加删除的时候处理结点指向）
 * @author b9i
 *
 * @param <E>
 */
public class SingleCirclrLinkedList<E> extends AbstractList<E> {
	
	private Node<E> first;
	
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
			if (size == 0) { 
				first.next = first;
			} else {
				Node<E> last = node(size - 1);
				last.next = first;
			}
		} else {
			Node<E>	prev = node(index - 1);
			prev.next = new Node<>(element,prev.next);
		}
		
		size++;
	}

	@Override
	public E remove(int index) {
		rangeCheck(index);

		Node<E> node = first; 
		if (index == 0) {
			if (size == 1) { 
				first = null;
			} else { 
				first = first.next;
				Node<E> last = node(size - 1);
				last.next = first;
			}
		} else {
			Node<E>	prev = node(index - 1);
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
		
		Node<E> node = first;
		for (int i = 0; i < index; i++) {
			node = node.next;
		}
		
		return node;
	}
}
