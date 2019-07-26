package org.ds.list;

import java.util.List;

public class LinkedList<K> {

	private Node<K> root;
	private Node<K> last;

	private int size;

	public LinkedList() {
		List list = new java.util.LinkedList();
		root = last = new Node<>();
	}

	public void insert(K data) {
		Node<K> node = new Node<>();
		node.setData(data);
		last = node;
	}

	public boolean find(K search) {
		return find(search, root);
	}


	private boolean find(K k, Node node) {
		if (node == null) return false;
		if (node.getNextNode().equals(k)) {
			return true;
		}
		return find(k, node.getNextNode());
	}


}
