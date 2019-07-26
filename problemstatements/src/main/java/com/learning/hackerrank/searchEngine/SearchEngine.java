package com.learning.hackerrank.searchEngine;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SearchEngine {
	public static void main(String[] args) throws IOException {
		Trie trie = new Trie();
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			String[] ip          = br.readLine().split(" ");
			int      inputCases  = getInt(0, ip);
			int      searchCases = getInt(1, ip);
			for (int i = 0; i < inputCases; i++) {
				String[] s      = br.readLine().split(" ");
				String   word   = s[0];
				int      weight = Integer.parseInt(s[1]);
				trie.insert(word, weight);
			}
			for (int i = 0; i < searchCases; i++) {
				System.out.println(trie.getMaxWeight(br.readLine()));
			}
		}
	}

	private static int getInt(int i, String[] ip) {
		return Integer.parseInt(ip[i]);
	}
}

class Trie {
	private TrieNode root;

	Trie() {
		this.root = new TrieNode();
	}

	void insert(String word, int weight) {
		TrieNode current = root;
		for (Character c : word.toCharArray()) {
			current = current.getChildren().computeIfAbsent(c, character -> new TrieNode());
		}
		current.setEndOfWord();
		current.setWeight(weight);
	}

	int getMaxWeight(String suffix) {
		TrieNode current = root;
		for (Character c : suffix.toCharArray()) {
			current = current.getChildren().get(c);
			if (current == null) return -1;
		}

		return getMaxWeight(current);
	}

	private int getMaxWeight(TrieNode current) {
		return getMaxWeight(getLeafNodes(current));
	}

	private int getMaxWeight(List<TrieNode> nodeList) {
		int max = 0;
		int weight;
		for (TrieNode trieNode : nodeList) {
			if ((weight = trieNode.getWeight()) > max) {
				max = weight;
			}
		}
		return max;
	}

	private List<TrieNode> getLeafNodes(TrieNode current) {
		List<TrieNode> nodeList = new ArrayList<>();
		if (current.isEndOfWord()) {
			nodeList.add(current);
		}
		for (Map.Entry<Character, TrieNode> entry : current.getChildren().entrySet()) {
			nodeList.addAll(getLeafNodes(entry.getValue()));
		}
		return nodeList;
	}
}

class TrieNode {
	private final Map<Character, TrieNode> children    = new HashMap<>();
	private       int                      charWeight  = -1;
	private       boolean                  isEndOfWord = false;

	Map<Character, TrieNode> getChildren() {
		return children;
	}

	int getWeight() {
		return charWeight;
	}

	void setWeight(int charWeight) {
		this.charWeight = charWeight;
	}

	boolean isEndOfWord() {
		return isEndOfWord;
	}

	void setEndOfWord() {
		isEndOfWord = true;
	}
}