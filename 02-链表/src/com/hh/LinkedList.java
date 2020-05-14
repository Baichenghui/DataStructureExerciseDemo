package com.hh;

public class LinkedList<E> extends AbstractList<E> {
	
	private Node<E> first;
	private Node<E> last;
	
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
			last = new Node<>(element, oldLast.prev, null);
			if (oldLast == null) {//往链表添加第一个节点
				first = last;
			} else {
				oldLast.next = last; 
			}
		} else {//往index节点前添加节点
			Node<E> next = node(index);
			Node<E> prev = next.prev;
			Node<E> node = new Node<>(element, prev, next);
			
			if (prev == null) {//添加至头结点
				first = node;
			} else {
				prev.next = node; 
			}
		}
		 
		size++;
	}

	@Override
	public E remove(int index) { 
		rangeCheck(index);
		
		Node<E> node = node(index);
		Node<E> prev = node.prev;
		Node<E> next = node.next;
		
		if (prev == null) { //删除的是头结点
			first = next; 
		} else {  
			prev.next = next;
		}

		if (next == null) { //删除的是尾结点
			last = prev; 
		} else {
			next.prev = prev;
		} 
		
		size--;
		
		return node.element;
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
}

 