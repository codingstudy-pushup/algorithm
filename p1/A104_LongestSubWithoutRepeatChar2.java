package TwoPointers;

import java.util.HashMap;
import java.util.Map;

public class LongestSubWithoutRepeatChar2 {

	public static void main(String[] args) {
		String input = "pawwkea";
//		String input = "abcabcd";
		System.out.println(solve_map(input));
		System.out.println(solve_array(input));
	}

	public static int solve_array(String s) {
		int[] map = new int[128];
		int l = 0, r = 0, max = 0, counter = 0;

		while (r < s.length()) {
			char c1 = s.charAt(r);
			if (map[c1] > 0)
				counter++;
			map[c1]++;
			r++;

			while (counter > 0) {
				char c2 = s.charAt(l);
				if (map[c2] > 1)
					counter--;
				map[c2]--;
				l++;
			}

			max = Math.max(max, r - l);
		}
		return max;
	}

	public static int solve_map(String s) {
		// 1.ds
		Map<Character, Integer> map = new HashMap<>();
		int l = 0, r = 0, counter = 0, max = 0;

		// 2
		while (r < s.length()) {
			char c = s.charAt(r);
			map.put(c, map.getOrDefault(c, 0) + 1);
			if (map.get(c) > 1)
				counter++;
			r++;

			while (counter > 0) {
				char c2 = s.charAt(l); // p
				if (map.get(c2) > 1)
					counter--;
				map.put(c2, map.get(c2) - 1);
				l++;
				System.out.println("22222r " + r + " l " + l + " " + (r - l));

			}
			max = Math.max(max, r - l);
			System.out.println("r " + r + " l " + l + " " + (r - l));

		}
		return max;

	}

}
