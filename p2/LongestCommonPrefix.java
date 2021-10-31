

public class LongestCommonPrefix {

	public static void main(String[] args) {
		String[] strs = { "flower", "flow", "flight" };
		System.out.println(solve(strs));
	}

	public static String solve(String[] strs) {
		if (strs == null || strs.length == 0)
			return "";
		String pre = strs[0];
		for (int i = 1; i < strs.length; i++) {
			System.out.println(""+strs[i]);
			while (strs[i].indexOf(pre) != 0) {
				System.out.println(" "+strs[i].indexOf(pre));
				pre = pre.substring(0, pre.length() - 1);
				System.out.println("pre "+pre);
			}
		}
		return pre;
	}

	public String longestCommonPrefix2(String[] strs) {
		StringBuilder result = new StringBuilder();

		if (strs != null && strs.length > 0) {

			Arrays.sort(strs);

			char[] a = strs[0].toCharArray();
			char[] b = strs[strs.length - 1].toCharArray();

			for (int i = 0; i < a.length; i++) {
				if (b.length > i && b[i] == a[i]) {
					result.append(b[i]);
				} else {
					return result.toString();
				}
			}
			return result.toString();
		}
	}

}
