package sort;

import java.util.ArrayList;
import java.util.List;

public class QuickSort {

	public static void main(String[] args) {
		QuickSort a = new QuickSort();
		int[] nums = { 6, 5, 4, 3, 2, 1 };
		a.quick(nums, 0, nums.length - 1);
		for (int val : nums)
			System.out.print(val + " ");
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
