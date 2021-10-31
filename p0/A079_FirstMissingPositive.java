package topInterview;

public class FirstMissingPositive {

	public static void main(String[] args) {
//		int[] nums = {1,2,0};
		int[] nums = { 3, 4, -1, -2, 1, 5, 16, 0, 2, 0 };
		System.out.println(solve(nums));
	}

	public static int solve(int[] nums) {
		int n = nums.length;

		for (int i = 0; i < n; i++) {
			if (nums[i] <= 0 || nums[i] > n) {
				nums[i] = n + 1;
			}
		}

		for (int i = 0; i < n; i++) {
			int num = Math.abs(nums[i]);
			if (num > n) {
				continue;
			}
			num--;
			if (nums[num] > 0) {
				nums[num] = -1 * nums[num];
			}
		}

		for (int i = 0; i < n; i++) {
			if (nums[i] >= 0) {
				return i + 1;
			}
		}

		return n + 1;
	}
}
