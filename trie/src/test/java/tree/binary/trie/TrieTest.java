package tree.binary.trie;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TrieTest {

	@Test
	public void testInsert() {
		Trie trie = loadTrie();
		Assert.assertTrue(trie.containsWord("help"));
		Assert.assertTrue(trie.containsWord("worry"));
	}

	@Test
	public void testContainsWord() {
		Trie    trie         = loadTrie();
		boolean containsWord = trie.containsWord("world");
		Assert.assertTrue(containsWord);
	}

	@Test
	public void testDelete() {
		Trie    trie   = loadTrie();
		boolean delete = trie.delete("hello");
		Assert.assertFalse(delete);
		Assert.assertTrue(trie.containsWord("help"));
		Assert.assertFalse(trie.containsWord("hello"));
		trie.delete("world");
		Assert.assertFalse(trie.containsWord("world"));
	}

	@Test
	public void testIsEmpty() {
		Trie trie = new Trie();
		Assert.assertTrue(trie.isEmpty());
		trie = loadTrie();
		Assert.assertFalse(trie.isEmpty());
	}

	private Trie loadTrie() {
		Trie trie = new Trie();
		trie.insert("help");
		trie.insert("hello");
		trie.insert("world");
		trie.insert("worry");
		return trie;
	}
}