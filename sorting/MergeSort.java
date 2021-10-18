import java.util.*;

public class MergeSort {

	public static void main(String[] args) {
		MergeSort a = new MergeSort();

		int[] array = { 4, 2, 6, 3, 7, 8,5, 1 };
		a.print(array);
		a.mergeSort(array);
		a.print(array);
	}

	private void mergeSort(int[] arr) {
		int[] tmp = new int[arr.length];
		mergeSort(arr, tmp, 0, arr.length - 1, );
	}

	public void print(int[] arr) {
		for (int a : arr)
			System.out.print(a + " ");
		System.out.println();
	}

	public void mergeSort(int[] arr, int[] tmp, int start, int end) {

		if (start < end) {
		
			int mid = (start + end) / 2;
			mergeSort(arr, tmp, start, mid, );
		
			mergeSort(arr, tmp, mid + 1, end, );
	
			merge(arr, tmp, start, mid, end);
		}
	}

	public void merge(int[] arr, int[] tmp, int start, int mid, int end) {
	
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

//	public List<Integer> sortArray(int[] nums) {
//		List<Integer> res = new ArrayList<>();
//		if (nums == null || nums.length == 0)
//			return res;
//		mergeSort(nums, 0, nums.length - 1);
//		for (int i : nums)
//			res.add(i);
//		return res;
//	}
//
//	private void mergeSort(int[] nums, int l, int r) {
//		if (l >= r)
//			return;
//		int mid = l + (r - l) / 2;
//		mergeSort(nums, l, mid);
//		mergeSort(nums, mid + 1, r);
//		merge(nums, l, r);
//	}
//	private void merge(int[] nums, int l, int r) {
//		int mid = l + (r - l) / 2;
//		int[] tmp = new int[r - l + 1];
//		int i = l, j = mid + 1, k = 0;
//		while (i <= mid || j <= r) {
//			if (i > mid || j <= r && nums[i] > nums[j]) {
//				tmp[k++] = nums[j++];
//			} else {
//				tmp[k++] = nums[i++];
//			}
//		}
//		System.arraycopy(tmp, 0, nums, l, r - l + 1);
//	}

}
