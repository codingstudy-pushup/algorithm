package p00;

import java.util.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class A022_WordLadder {

	public static void main(String[] args) {

		List<String> wordList = new ArrayList<>();
		wordList.add("hot");
		wordList.add("dot");
		wordList.add("lot");
		wordList.add("log");
		wordList.add("cog");

		String[] words = { "hot", "dot", "lot", "log", "cog" };

		System.out.println(solve("hit", "cog", wordList));
	}

	public static int solve(String beginWord, String endWord, List<String> wordList) {
		// 1. dataStructure
		if (wordList == null || !wordList.contains(endWord))
			return 0;
		Queue<String> queue = new LinkedList<>();
		Set<String> set = new HashSet<>(wordList);
		queue.offer(beginWord);
		set.remove(beginWord);
		int level = 1;

		// 2. while
		while (!queue.isEmpty()) {
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				String str = queue.poll();
				if (str.equals(endWord))
					return level;
				for (String n : neighbor(str, set)) {
					System.out.println("n " + n);
					queue.offer(n);
				}

			}
			level++;
		}
		return 0;
	}

	private static List<String> neighbor(String s, Set<String> set) {

		System.out.println("s "+s);
		List<String> res = new LinkedList<>();

		for (int i = 0; i < s.length(); i++) {
			char[] chars = s.toCharArray();
			for (char c = 'a'; c <= 'z'; c++) {
				chars[i] = c;
				String word = new String(chars);
				if (set.remove(word))
					res.add(word);
			}
		}
		return res;

	}
}
