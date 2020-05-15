package com.hh;

import com.hh.circle.CircleLinkedList;
import com.hh.circle.SingleCirclrLinkedList;

public class Main {
	
	public static void main(String[] args) {
		
		CircleLinkedList<Integer> linkedList = new CircleLinkedList<Integer>();
		for (int i = 1; i <= 8; i++) {
			linkedList.add(i);
		}
		System.out.println("linkedList:"+linkedList ); 
		linkedList.reset();
		 
		while (!linkedList.isEmpty()) {
			 linkedList.next();
			 linkedList.next();
			 Integer e = linkedList.remove();
			 System.out.println("remove:"+e ); 
			 System.out.println("linkedList:"+linkedList ); 
		}
		 
	}

}
