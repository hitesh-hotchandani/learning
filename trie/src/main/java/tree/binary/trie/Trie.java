package tree.binary.trie;

public class Trie {

	private TrieNode root;

	Trie() {
		root = new TrieNode();
	}

	void insert(String word) {
		TrieNode current = root;
		for (int i = 0; i < word.length(); i++) {
			current = current.getChildren().computeIfAbsent(word.charAt(i), c -> new TrieNode());
		}
		current.setEndOfWord(true);
	}

	boolean delete(String word) {
		return delete(root, word, 0);
	}

	boolean containsWord(String word) {
		TrieNode current = root;

		for (int i = 0; i < word.length(); i++) {
			char     c    = word.charAt(i);
			TrieNode node = current.getChildren().get(c);
			if (node == null) return false;
			current = node;
		}
		return current.isEndOfWord();
	}

	boolean isEmpty() {
		return root == null || root.getChildren().isEmpty();
	}

	private boolean delete(TrieNode current, String word, int index) {
		if (index == word.length()) {
			if (!current.isEndOfWord()) {
				return false;
			}
			current.setEndOfWord(false);
			return current.getChildren().isEmpty();
		}
		char     c    = word.charAt(index);
		TrieNode node = current.getChildren().get(c);
		if (node == null) return false;

		if (delete(node, word, index + 1) && !node.isEndOfWord()) {
			current.getChildren().remove(c);
			return current.getChildren().isEmpty();
		}
		return false;
	}
}
