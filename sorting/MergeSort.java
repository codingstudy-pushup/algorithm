package sort;

import java.util.*;

public class MergeSort {

	public static void main(String[] args) {
		MergeSort a = new MergeSort();

//		int[] array = { 6, 5, 4, 3, 2, 1, 7, 8, 9 };
		int[] array = { 4, 2, 6, 3, 7, 8, 5,1};
		a.print(array);
		a.mergeSort(array);
		a.print(array);
		System.out.println(a.sortArray(array));
	}

	private void mergeSort(int[] arr) {
		int[] tmp = new int[arr.length];
		mergeSort(arr, tmp, 0, arr.length - 1, 0);
	}

	public void print(int[] arr) {
		for (int a : arr)
			System.out.print(a + " ");

		System.out.println();
	}

	public void mergeSort(int[] arr, int[] tmp, int start, int end, int k) {
		k = k + 1;
		
		if (start < end) {
			System.out.println("start= " + start+" end "+end);
			int mid = (start + end) / 2;
			mergeSort(arr, tmp, start, mid, k);
			System.out.println("k= " + k);
			mergeSort(arr, tmp, mid + 1, end, k);
			System.out.println("2k= " + k);
			merge(arr, tmp, start, mid, end);
		}
	}

	public void merge(int[] arr, int[] tmp, int start, int mid, int end) {
		System.out.println("sssssssssssss " + start + " mid " + mid + " end " + end);
		for (int i = start; i <= end; i++) {
			tmp[i] = arr[i];
		}
		int part1 = start;
		int part2 = mid + 1;
		int index = start;
		while (part1 <= mid && part2 <= end) {
			if (tmp[part1] <= tmp[part2]) {
				arr[index] = tmp[part1];
				part1++;
			} else {
				arr[index] = tmp[part2];
				part2++;
			}
			index++;
		}
		for (int i = 0; i <= mid - part1; i++) {
			arr[index + i] = tmp[part1 + i];
		}
	}

	public List<Integer> sortArray(int[] nums) {
		List<Integer> res = new ArrayList<>();
		if (nums == null || nums.length == 0)
			return res;
		mergeSort(nums, 0, nums.length - 1);
		for (int i : nums)
			res.add(i);
		return res;
	}

	private void mergeSort(int[] nums, int l, int r) {
		if (l >= r)
			return;
		int mid = l + (r - l) / 2;
		mergeSort(nums, l, mid);
		mergeSort(nums, mid + 1, r);
		merge(nums, l, r);
	}

	private void merge(int[] nums, int l, int r) {
		int mid = l + (r - l) / 2;
		int[] tmp = new int[r - l + 1];
		int i = l, j = mid + 1, k = 0;
		while (i <= mid || j <= r) {
			if (i > mid || j <= r && nums[i] > nums[j]) {
				tmp[k++] = nums[j++];
			} else {
				tmp[k++] = nums[i++];
			}
		}
		System.arraycopy(tmp, 0, nums, l, r - l + 1);
	}

}
