package com.hh;

import com.hh.circle.SingleCirclrLinkedList;

public class Main {
	
	public static void main(String[] args) {
		
		SingleCirclrLinkedList<Integer> linkedList = new SingleCirclrLinkedList<Integer>();
		for (int i = 1; i <= 8; i++) {
			linkedList.add(i );
		}
		
		linkedList.reset();
		 
		while (!linkedList.isEmpty()) {
			 linkedList.next();
			 linkedList.next();
			 linkedList.remove();
			 System.out.println("linkedList:"+linkedList ); 
		}
		 
	}

}
