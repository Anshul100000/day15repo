package com.bridgelab;


import java.nio.channels.FileChannel.MapMode;
import java.util.ArrayList;

public class Hashmap<K,V> {
	
	HashNode head;
	HashNode tail;
	int size;
	private final int numOfBuckets;
	ArrayList<HashNode<K, V>> sizeOfBucket;

	/*
	* contontor
	*/
	public Hashmap() {
	this.numOfBuckets = 20;
	sizeOfBucket = new ArrayList<>();
	for (int i = 0; i < numOfBuckets; i++) {
	sizeOfBucket.add(null);
	}
	}

	/*
	* Adding Key value
	*/
	public void add(K key, V value) {
	int index = getKeyIndex(key);
	HashNode<K, V> node = sizeOfBucket.get(index);
	if (node == null) {
	node = new HashNode<>(key, value);
	sizeOfBucket.set(index, node);
	}
	node = searchNode(key);
	if (node == null) {
	node = new HashNode<>(key, value);
	append(node);

	} else {
	node.setValue(value);
	}
	}

	/*
	* appending Key value at last
	*/
	private void append(HashNode<K, V> node) {
	if (head == null) {
	head = node;
	}
	if (tail == null) {
	tail = node;
	} else {
	tail.setNext(node);
	tail = node;
	}

	}
	/*
	* Get the values by using key index
	*/
	public V get(K key) {
	int index = getKeyIndex(key);
	HashNode<K, V> head = sizeOfBucket.get(index);
	while (head != null) {
	if (head.key.equals(key)) {
	return head.value;
	}
	head = head.next;
	}
	return null;
	}
	/*
	* Serching the node using keys
	*/
	public HashNode<K, V> searchNode(K key) {
	HashNode node = head;
	int countposition = 0;
	while (node != null) {
	countposition++;
	if (node.getKey().equals(key)) {
	return node;
	}
	node = node.getNext();
	}
	return node;
	}
	/*
	* Get the values by using index using hashcode() method
	*/
	public int getKeyIndex(K word) {
	// System.out.println(word);
	int hashcode = Math.abs(word.hashCode());
	// System.out.println(hashcode);
	int index = hashcode % numOfBuckets; // fixing the index for one word

	return index;

	}
	/*
	* Removing the value
	*/
	public void remove(K word) {
	HashNode currentNode = head;
	HashNode previousNode = null;
	while (currentNode != null && currentNode.getKey().equals(word)) {
	head = currentNode.getNext();
	return;
	}
	while (currentNode != null && !(currentNode.getKey().equals(word))) {
	previousNode = currentNode;
	currentNode = currentNode.getNext();
	}
	if (currentNode != null) {
	previousNode.next = currentNode.next;
	}
	}

	public String toString() {
	return "Mylist{" + head + "}";
	}
}



