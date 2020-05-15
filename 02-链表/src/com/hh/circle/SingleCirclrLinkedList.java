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
	private Node<E> current; 
	
	private static class Node<E> {
		E element;
		Node<E> next;
		
		public Node(E element,Node<E> next) {
			 this.element = element;
			 this.next = next;
		}
		
		@Override
		public String toString() {
			StringBuilder sb = new StringBuilder();
			sb.append(element).append("_").append(next.element);
			return sb.toString();
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
				//先取出最后的节点，然后再做删除操作，不然先删除再取最后一个节点就不准确了
				Node<E> last = node(size - 1);
				first = first.next;
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
	
	public E getCurrent() {
		if (current == null) {
			return null;
		}
		
		return current.element;
	}

	public void reset() {
		current = first;
	}
	
	public E remove() {
		if (current == null) {
			return null;
		}
		Node<E> next = current.next; 
		E element = remove(current);
		if (size == 0) {
			current = null;
		} else {
			current = next;
		} 
		return element;
	}
	
	public E next() {
		if (current == null) {
			return null;
		} else {
			current = current.next; 
			return current.element;
		}
	}
	
	private E remove(Node<E> node) {
		if (node == null) {
			return null;
		} 
		int index = indexOf(node.element);
		E element = remove(index); 
		  
		return element;
	}

	private Node<E> node(int index) {
		rangeCheck(index);
		
		Node<E> node = first;
		for (int i = 0; i < index; i++) {
			node = node.next;
		}
		
		return node;
	}
	
	@Override
	public String toString() {
		StringBuilder string = new StringBuilder();
		string.append("size=").append(size).append(", [");
		Node<E> node = first;
		for (int i = 0; i < size; i++) {
			if (i != 0) {
				string.append(", ");
			}
			
			string.append(node);
			
			node = node.next;
		}
		string.append("]");
		return string.toString();
	}
}
