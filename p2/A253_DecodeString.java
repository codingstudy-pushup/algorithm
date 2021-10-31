package p1;

import java.util.*;

public class G038_DecodeString {

	public static void main(String[] args) {
		String s = "3[a]2[bc]";
		G038_DecodeString a = new G038_DecodeString();
		System.out.println(a.decodeString(s));
		System.out.println(a.decodeString_1(s));
		System.out.println(a.decodeString_dfs(s));
	}

	// stack
	public String decodeString(String s) {
		String res = "";
		Stack<Integer> countStack = new Stack<>();
		Stack<String> resStack = new Stack<>();
		int idx = 0;
		while (idx < s.length()) {
			if (Character.isDigit(s.charAt(idx))) {
				int count = 0;
				while (Character.isDigit(s.charAt(idx))) {
					count = 10 * count + (s.charAt(idx) - '0');
					idx++;
				}
				countStack.push(count);
			} else if (s.charAt(idx) == '[') {
				resStack.push(res);
				res = "";
				idx++;
			} else if (s.charAt(idx) == ']') {
				StringBuilder temp = new StringBuilder(resStack.pop());
				int repeatTimes = countStack.pop();
				for (int i = 0; i < repeatTimes; i++) {
					temp.append(res);
				}
				res = temp.toString();
				idx++;
			} else {
				res += s.charAt(idx++);
			}
		}
		return res;
	}

	public String decodeString_1(String s) {
		if (s.length() == 0)
			return "";
		Stack<String> stack = new Stack<>();
		String curr = "";
		int i = s.length() - 1;
		while (i >= 0) {
			char ch = s.charAt(i);
			if (ch != '[' && ch != ']') {
				curr = ch + curr;
				i--;
			} else if (ch == ']') {
				stack.push(curr);
				curr = "";
				i--;
			} else if (ch == '[') {
				int j = i;
				while (j > 0 && Character.isDigit(s.charAt(j - 1))) {
					j--;
				}
				int count = Integer.parseInt(s.substring(j, i));
				StringBuilder sb = new StringBuilder();
				for (int k = 0; k < count; k++) {
					sb.append(curr);
				}
				curr = sb.append(stack.pop()).toString();
				i = j - 1;
			}
		}

		while (!stack.isEmpty()) {
			curr += stack.pop();
		}
		return curr;
	}

	// dfs
	private int pos = 0;

	public String decodeString_dfs(String s) {
		StringBuilder sb = new StringBuilder();
		String num = "";
		for (int i = pos; i < s.length(); i++) {
			if (s.charAt(i) != '[' && s.charAt(i) != ']' && !Character.isDigit(s.charAt(i))) {
				sb.append(s.charAt(i));
			} else if (Character.isDigit(s.charAt(i))) {
				num += s.charAt(i);
			} else if (s.charAt(i) == '[') {
				pos = i + 1;
				String next = decodeString_dfs(s);
				for (int n = Integer.valueOf(num); n > 0; n--)
					sb.append(next);
				num = "";
				i = pos;
			} else if (s.charAt(i) == ']') {
				pos = i;
				return sb.toString();
			}
		}
		return sb.toString();
	}
}
