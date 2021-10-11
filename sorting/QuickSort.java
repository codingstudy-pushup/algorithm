package sort;

import java.util.ArrayList;
import java.util.List;

public class QuickSort {

	public static void main(String[] args) {
		QuickSort a = new QuickSort();
		a.solve();
		int[] array = { 6, 5, 4, 3, 2, 1 };
		System.out.println(a.sortArray(array));
	}

	public List<Integer> sortArray(int[] nums) {
		List<Integer> res = new ArrayList<>();
		if (nums == null || nums.length == 0)
			return res;
		quickSort(nums, 0, nums.length - 1);
		for (int i : nums)
			res.add(i);
		return res;
	}

	private void quickSort(int[] nums, int l, int r) {
		if (l >= r)
			return;
		int mid = partition2(nums, l, r);
		quickSort(nums, l, mid);
		quickSort(nums, mid + 1, r);
	}

	private int partition2(int[] nums, int l, int r) {
		int pivot = nums[l];
		while (l < r) {
			while (l < r && nums[r] >= pivot)
				r--;
			nums[l] = nums[r];
			while (l < r && nums[l] <= pivot)
				l++;
			nums[r] = nums[l];
		}
		nums[l] = pivot;
		return l;
	}

	private void solve() {
		int[] array = { 6, 5, 4, 3, 2, 1 };
		quicksort(array, 0, array.length - 1);

		for (int v : array) {
			System.out.print(v + " ");
		}
	}

	public void quicksort(int[] array, int left, int right) {
		if (left >= right) {
			return;
		}
		int pi = partition(array, left, right);
		quicksort(array, left, pi - 1);
		quicksort(array, pi + 1, right);
	}

	public int partition(int[] array, int left, int right) {
		int mid = (left + right) / 2;
		swap(array, left, mid);

		int pivot = array[left];
		int i = left, j = right;

		while (i < j) {
			while (pivot < array[j]) {
				j--;
			}

			while (i < j && pivot >= array[i]) {
				i++;
			}
			swap(array, i, j);
		}
		array[left] = array[i];
		array[i] = pivot;
		return i;
	}

	public void swap(int[] array, int a, int b) {
		int temp = array[b];
		array[b] = array[a];
		array[a] = temp;
	}

}
