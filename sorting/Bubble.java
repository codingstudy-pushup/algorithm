
public class BubbleSort {

	public static void main(String[] args) {
		BubbleSort a = new BubbleSort();
		int[] nums = {4,3,2,1,5} ;
		a.solve(nums, nums.length-1);
		for(int val : nums)
			System.out.print(val +" ");
	}
	private void solve(int[] nums, int last) {
		if(last>0) {
			for(int i=1; i<=last; i++) {
				if(nums[i-1] > nums[i]) {
					swap(nums, i-1,i);
				}
			}
			solve(nums, last-1);
		}
	}
	private void swap(int[] nums, int a, int b) {
		
		int tmp = nums[a];
		nums[a] = nums[b];
		nums[b] = tmp;
	}
}
