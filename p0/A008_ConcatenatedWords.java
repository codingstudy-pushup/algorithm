package ama001;

import java.util.*;

public class A010_ConcatenatedWords {

	public static void main(String[] args) {
		String[] str = { "cat", "cats", "catsdogcats", "dog", "dogcatsdog", "hippopotamuses", "rat", "ratcatdogcat" };

		A010_ConcatenatedWords a = new A010_ConcatenatedWords();
		System.out.println(a.solve(str));
	}

	public static List<String> solve(String[] words) {
		List<String> result = new ArrayList<>();
		Set<String> set = new HashSet<>();
		Arrays.sort(words, (a, b) -> a.length() - b.length());

		for (int i = 0; i < words.length; i++) {
			if (checkForm(words[i], set)) {
				result.add(words[i]);
			}
			set.add(words[i]);
		}
		return result;
	}

	private static boolean checkForm(String word, Set<String> dict) {
		if (dict.isEmpty()) return false;
		System.out.println("word: "+word);
		boolean[] dp = new boolean[word.length() + 1];
		dp[0] = true;

		for (int i = 1; i <= word.length(); i++) {
			for (int j = 0; j < i; j++) {
				System.out.println("11 dp[" + j + "] " + dp[j]);
				if (!dp[j]) {
					System.out.println("22 dp[" + j + "] " + dp[j]);
					continue;
				}
			
				if (dict.contains(word.substring(j, i))) {
					System.out.println("word.substring(" + j + " " + i + " ): " + word.substring(j, i));
					dp[i] = true;
					break;
				}
			}
		}
		return dp[word.length()];
	}

	// 2 tri DFS
	public List<String> solve_trieDFs(String[] words) {
		List<String> res = new ArrayList<String>();
		if (words == null || words.length == 0) return res;
		
		TrieNode root = new TrieNode();
		for (String word : words) {
			if (word.length() == 0) {
				continue;
			}
			addWord(word, root);
		}
		for (String word : words) {
			if (word.length() == 0) {
				continue;
			}
			if (testWord(word.toCharArray(), 0, root, 0)) {
				res.add(word);
			}
		}
		return res;
	}

	public boolean testWord(char[] chars, int index, TrieNode root, int count) {

		TrieNode cur = root;
		int n = chars.length;
		for (int i = index; i < n; i++) {
			if (cur.sons[chars[i] - 'a'] == null) {
				return false;
			}
			if (cur.sons[chars[i] - 'a'].isEnd) {
				if (i == n - 1) {
					return count >= 1;
				}
				if (testWord(chars, i + 1, root, count + 1)) {
					return true;
				}
			}
			cur = cur.sons[chars[i] - 'a'];
		}
		return false;
	}

	public void addWord(String str, TrieNode root) {
		char[] chars = str.toCharArray();
		TrieNode cur = root;
		for (char c : chars) {
			if (cur.sons[c - 'a'] == null) {
				cur.sons[c - 'a'] = new TrieNode();
			}
			cur = cur.sons[c - 'a'];
		}
		cur.isEnd = true;
	}
}

class TrieNode {
	TrieNode[] sons;
	boolean isEnd;

	public TrieNode() {
		sons = new TrieNode[26];
	}
}
