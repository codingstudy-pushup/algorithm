
public class SelectionSort {
	
	public static void main(String[] args) {
		SelectionSort a = new SelectionSort();
		int[] arr = {4,3,1,2,5};
		a.solve(arr,0);
		print(arr);
	}
	
	public void solve(int[] arr, int s) {
		int e = arr.length;
		if(s<e-1) {
			int min = s;
			for(int i=s; i< e; i++) {
				if(arr[i]< arr[min]) min =i;
			}
			swap(arr, s, min);
			solve(arr, s+1);
		}
	}
	private void swap(int[] arr, int a , int b) {
		int tmp = arr[a];
		arr[a] =arr[b];
		arr[b] = tmp;
	}
	private static void print(int[] arr) {
		for(int val : arr) {
			System.out.print(val+" ");
		}
		System.out.println();
	}

}
