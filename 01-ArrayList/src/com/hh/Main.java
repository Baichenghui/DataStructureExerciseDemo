package com.hh;
 

public class Main {
	public static void main(String[] args) {
		test2();
	}
	
	static void test1() {   
		ArrayList<Integer> ints  = new ArrayList<>();
		ints.add(10);
		ints.add(10);
		ints.add(10);
		ints.add(10);
		ints.add(10); 
		ints.add(10); 
		ints.add(10); 
		ints.add(10); 
		ints.add(10); 
		ints.add(10); 
		ints.add(22);
		ints.add(22);
		ints.add(22);
		ints.add(22);
		ints.add(22);
		ints.add(33);
		ints.add(33);
		System.out.println(ints);
	}
	
	static void test2() {   
		ArrayList<Integer> ints  = new ArrayList<>();
		ints.add(10);
		ints.add(10);
		ints.add(10);
		ints.add(10);
		ints.add(10); 
		ints.add(10); 
		ints.add(10); 
		ints.add(10); 
		ints.add(10); 
		ints.add(10); 
		ints.add(22);
		ints.add(22);
		ints.add(22);
		ints.add(22);
		ints.add(22);
		ints.add(33);
		ints.add(33);

		ints.remove(0);
		ints.remove(0);
		ints.remove(0);
		ints.remove(0);
		ints.remove(0);
		ints.remove(0);
		ints.remove(0);
		ints.remove(0);
		ints.remove(0);
		ints.remove(0);
		ints.remove(0);
		ints.remove(0);
		
		System.out.println(ints);
	}
}
