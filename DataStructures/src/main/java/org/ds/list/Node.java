package org.ds.list;

public class Node<K> {
	boolean isLastNode = false;

	private K       data;
	private Node<K> next;

	Node getNextNode() {
		return next;
	}

	void setNextNode(Node<K> node) {
		this.next = node;
	}

	K getData() {
		return this.data;
	}

	void setData(K k) {
		this.data = k;
	}

	public boolean isLastNode() {
		return isLastNode;
	}

	public void setLastNode(boolean lastNode) {
		isLastNode = lastNode;
	}
}
