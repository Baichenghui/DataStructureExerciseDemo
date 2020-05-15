package com.hh.circle;

import com.hh.AbstractList; 

/**
 * 双向循环链表	（对比双向链表需要在添加删除的时候处理结点指向））
 * @author b9i
 *
 * @param <E>
 */
public class CircleLinkedList<E> extends AbstractList<E> {
	
	private Node<E> first;
	private Node<E> last;
	private Node<E> current; 
	
	private static class Node<E> {
		E element;
		Node<E> prev;
		Node<E> next;
		
		public Node(E element,Node<E> prev,Node<E> next) {
			 this.element = element;
			 this.prev = prev;
			 this.next = next;
		}
		
		@Override
		public String toString() {
			StringBuilder sb = new StringBuilder();
			
			if (prev != null) {
				sb.append(prev.element);
			} else {
				sb.append("null");
			}
			
			sb.append("_").append(element).append("_");

			if (next != null) {
				sb.append(next.element);
			} else {
				sb.append("null");
			}
			
			return sb.toString();
		}
	}

	@Override
	public void clear() { 
		first = null;
		last = null;
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
		 
		if (index == size) {//往最后尾结点添加节点
			Node<E> oldLast = last; 
			last = new Node<>(element, oldLast, first);
			if (oldLast == null) {//往链表添加第一个节点
				first = last;
				first.next = first;
				first.prev = first;
			} else {
				oldLast.next = last; 
				first.prev = last;
			}
		} else {//往index节点前添加节点
			Node<E> next = node(index);
			Node<E> prev = next.prev;
			Node<E> node = new Node<>(element, prev, next);

			next.prev = node;
			prev.next = node; 
			
			if (first == last) {
				first = node;
			} 
		}
		 
		size++;
	}

	@Override
	public E remove(int index) { 
		rangeCheck(index);
		
		return remove(node(index));
	}

	@Override
	public int indexOf(E element) {
		Node<E> node = first;
		if (element == null) {
			for (int i = 0; i < size; i++) {
				if (node.element == null) {
					return i;
				}
			}
		} else {
			for (int i = 0; i < size; i++) {
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
	
	/**
	 * 移除current节点 
	 */
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
	
	/**
	 * current下一个节点 
	 */
	public E next() {
		if (current == null) {
			return null;
		} 
		current = current.next;
		return current.element;
	}
	
	/**
	 * 移除指定节点
	 * @param node 
	 */
	private E remove(Node<E> node) { 
		if (size == 1) {
			first = null;
			last = null;
		} else {
			Node<E> prev = node.prev;
			Node<E> next = node.next;
			
			prev.next = next;
			next.prev = prev;
			
			if (node == first) {
				first = next;
			}
			
			if (node == last) {
				last = prev;
			}
		}
		 
		size--;
		
		return node.element;
	}

	private Node<E> node(int index) { 
		rangeCheck(index);
		
		if (index < size >> 1) {//从头结点往后查
			Node<E> node = first;
			for (int i = 0; i < index; i++) {
				node = node.next;
			}
			return node;
		} else {//从尾结点往前查
			Node<E> node = last;
			for (int i = size - 1; i > index; i--) {
				node = node.prev;
			}
			return node;
		} 
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

 