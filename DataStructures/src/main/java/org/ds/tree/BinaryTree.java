package org.ds.tree;

class BinaryTree {
	private Node root;
	private int  base;

	private BinaryTree() {
	}

	public BinaryTree(int base) {
		this.base = base;
		root = new Node(base, base);
		root.setPseudoValue();
	}

	public Node insert(int value) {
		if (value <= base) {
			return addNode(root, value, base);
		}
		return null;
	}

	private Node addNode(Node node, int value, int base) {
		if (node == null) {
			return new Node(value, base);
		}
		if (value < node.getValue() / 2) {
			return addNode(node.getLeft(), value, base);
		} else if (value > node.getValue() / 2) {
			return addNode(node.getRight(), value, base);
		}

		return node;
	}

	class Node {
		private Node left, right;
		private int     value         = 0;
		private int     base          = 0;
		private boolean isPseudoValue = false;

		private Node() {
		}

		public Node(int value, int base) {
			this.base = base;
			this.value = value;
		}

		public int getValue() {
			return value;
		}

		public Node getLeft() {
			return this.left;
		}

		public void setLeft(Node left) {
			this.left = left;
		}

		public Node getRight() {
			return right;
		}

		public void setRight(Node right) {
			this.right = right;
		}

		boolean isPseudoValue() {
			return isPseudoValue;
		}

		void setPseudoValue() {
			isPseudoValue = true;
		}

		public int getBase() {
			return base;
		}
	}
}


