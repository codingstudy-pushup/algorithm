package topInterview;

import java.util.*;

public class MergeInterval {

	public static void main(String[] args) {
		int[][] intervals = { { 1, 3 }, { 2, 6 }, { 8, 10 }, { 15, 18 } };
		MergeInterval a = new MergeInterval();
		int[][] res = a.solve(intervals);
		for (int i = 0; i < res.length; i++) {
			for (int j = 0; j < res[i].length; j++) {
				System.out.print(res[i][j] + " ");
			}
			System.out.println();
		}

		System.out.println("========list call===");
		List<List<Integer>> resList = new ArrayList<>();
		List<Integer> list1 = new ArrayList<>();
		list1.add(1);
		list1.add(2);
		List<Integer> list2 = new ArrayList<>();
		list2.add(2);
		list2.add(6);
		List<Integer> list3 = new ArrayList<>();
		list3.add(8);
		list3.add(10);
		List<Integer> list4 = new ArrayList<>();
		list4.add(15);
		list4.add(18);
		resList.add(list1);
		resList.add(list2);
		resList.add(list3);
		resList.add(list4);
		System.out.println(a.solveList(resList));

	}

	public List<List<Integer>> solveList(List<List<Integer>> res) {

		List<List<Integer>> resList = new ArrayList<>();
		Collections.sort(res, (a, b) -> a.get(0) - b.get(0));
		int start = res.get(0).get(0);
		int end = res.get(0).get(1);

		for (int i = 1; i < res.size(); i++) {
			if (end >= res.get(i).get(0)) {
				end = Math.max(end, res.get(i).get(1));
			} else {
				List<Integer> list = new ArrayList<>();
				list.add(start);
				list.add(end);
				resList.add(list);
				start = res.get(i).get(0);
				end = res.get(i).get(1);
			}
		}
		List<Integer> list2 = new ArrayList<>();
		list2.add(start);
		list2.add(end);
		resList.add(list2);
		return resList;
	}

	public int[][] solve(int[][] intervals) {
		if (intervals.length <= 1)
			return intervals;

		// 1
		List<int[]> res = new ArrayList<>();
		Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
		int start = intervals[0][0];
		int end = intervals[0][1];

		for (int i = 1; i < intervals.length; i++) {
			if (end >= intervals[i][0]) {
				end = Math.max(end, intervals[i][1]);
			} else {
				res.add(new int[] { start, end });
				start = intervals[i][0];
				end = intervals[i][1];
			}
		}
		res.add(new int[] { start, end });
		return res.toArray(new int[res.size()][]);
	}

}
