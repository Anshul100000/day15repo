package com.bridgelab;

import java.util.Map;
import java.util.Scanner;


public class freqrunner {
	
	

	public class HashMapRunner {
	static Hashmap<String, Integer> Hashmap = new Hashmap<>();
	static Scanner sc = new Scanner(System.in);

	/*
	* UC1..Ability to find frequency of words in a sentence like (�To be or not to
	* be�)
	*/
	public void findFrequency() {
	// (eg : To be or not to be)
	// System.out.print("Enter a string: ");
	String message = "To be or not to be";
	String[] messagearray = message.toLowerCase().split(" ");
	for (String word : messagearray) {
	Integer value = Hashmap.get(word);
	// System.out.println(value);
	if (value == null) {
	value = 1;
	} else {
	value++;
	}
	Hashmap.add(word, value);
	}
	System.out.println(Hashmap);
	}

	public static void main(String[] args) {
	// creating Object
		freqrunner hash = new freqrunner();

	hash.findFrequency(); // UC1
	}
	}
}



