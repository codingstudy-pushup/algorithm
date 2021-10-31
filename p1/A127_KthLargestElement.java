package p00;

import java.util.*;

public class FindKthLargest {

	public static void main(String[] args) {
		int[] nums = { 3, 2, 1, 5, 6, 4 };
		int k = 2;
		FindKthLargest a = new FindKthLargest();
		System.out.println(a.solve(nums, k));
		System.out.println(a.solve_pq(nums, k));
		System.out.println(a.quick(nums, k));
	}

	public int solve(int[] nums, int k) {
		int leng = nums.length;
		Arrays.sort(nums);
		return nums[leng - k];
	}

	public int solve_pq(int[] nums, int k) {
		Queue<Integer> pq = new PriorityQueue<>();

		for (int n : nums) {
			pq.offer(n);
			if (pq.size() > k)
				pq.poll();
		}
		return pq.peek();
	}

	public int solve_partition(int[] nums, int lo, int hi) {
		int pivot = nums[lo];
		while (lo < hi) {
			while (lo < hi && nums[hi] > pivot)
				--hi;
			nums[lo] = nums[hi];
			while (lo < hi && nums[lo] < pivot)
				++lo;
			nums[hi] = nums[lo];
		}
		nums[lo] = pivot;
		return lo;
	}

	private int quick(int[] nums, int k) {

		quick(nums, 0, nums.length - 1);
		return nums[nums.length - k];
	}

	private void quick(int[] arr, int s, int e) {
		int part = partition(arr, s, e);
		if (s < part - 1) {
			quick(arr, s, part - 1);
		}
		if (part < e) {
			quick(arr, part, e);
		}
	}

	private int partition(int[] arr, int s, int e) {
		int pivot = arr[(s + e) / 2];
		while (s <= e) {
			while (arr[s] < pivot)
				s++;
			while (arr[e] > pivot)
				e--;
			if (s <= e) {
				swap(arr, s, e);
				s++;
				e--;
			}
		}
		return s;
	}

	public void swap(int[] array, int a, int b) {
		int temp = array[b];
		array[b] = array[a];
		array[a] = temp;
	}

}
