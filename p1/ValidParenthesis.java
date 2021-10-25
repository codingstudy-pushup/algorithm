package p1;

import java.util.Stack;

public class ValidParenthesis {

	public static void main(String[] args) {
		String s = "{}";
		System.out.println(solve(s));
	}

	public static boolean solve(String s) {

		Stack<Character> stack = new Stack<>();
		char[] chArr = s.toCharArray();
		for (int i = 0; i < chArr.length; i++) {
			if ('(' == chArr[i])
				stack.push(')');
			else if ('{' == chArr[i])
				stack.push('}');
			else if ('[' == chArr[i])
				stack.push(']');
			else if (stack.isEmpty() || stack.pop() != chArr[i])
				return false;
		}
		return stack.isEmpty();

	}
}
