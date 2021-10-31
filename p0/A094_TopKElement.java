

import java.util.*;

public class TopKElement {

	public static void main(String[] args) {
		TopKElement a = new TopKElement();
		int[] nums = { 1, 1, 1, 2, 2, 3,5,5,5,5 };
		int k = 2;
		System.out.println(a.solve_List(nums, k));
		System.out.println(a.solve_pq(nums, k));
		System.out.println(a.solve_treeMap(nums, k));
	}

	public static List<Integer> solve_List(int[] nums, int k) {
		Map<Integer, Integer> map = new HashMap<>();
		for (int n : nums) {
			map.put(n, map.getOrDefault(n, 0) + 1);
		}

		List<Integer>[] bucket = new List[nums.length + 1];
		for (int n : map.keySet()) {
			int freq = map.get(n);
			if (bucket[freq] == null)
				bucket[freq] = new LinkedList<>();
			bucket[freq].add(n);
		}

		List<Integer> res = new LinkedList<>();
		for (int i = bucket.length - 1; i > 0 && k > 0; --i) {
			if (bucket[i] != null) {
				List<Integer> list = bucket[i];
				res.addAll(list);
				k -= list.size();
			}
		}

		return res;
	}

	public List<Integer> solve_pq(int[] nums, int k) {
		Map<Integer, Integer> map = new HashMap<>();
		for(int n : nums)
			map.put(n, map.getOrDefault(n,0)+1);
		Queue<Map.Entry<Integer, Integer>> maxHeap = new PriorityQueue<>((a,b)->b.getValue()-a.getValue());
		for(Map.Entry<Integer, Integer> entry: map.entrySet())
			maxHeap.offer(entry);
		
		List<Integer> res = new ArrayList<>();
		while(res.size()<k) {
			Map.Entry<Integer, Integer> entry = maxHeap.poll();
			res.add(entry.getKey());
		}
		return res;
	}
	
	public List<Integer> solve_treeMap(int[] nums, int k){
		
		Map<Integer, Integer> map = new HashMap<>();
		for(int n : nums)
			map.put(n, map.getOrDefault(n, 0)+1);
		
		TreeMap<Integer, List<Integer>> treeMap= new TreeMap<>();
		for(int num: map.keySet()) {
			int value = map.get(num);
			if(!treeMap.containsKey(value)) {
				treeMap.put(value, new LinkedList<>());
			}
			treeMap.get(value).add(num);
		}
		
		List<Integer> res = new ArrayList<>();
		while(res.size()<k) {
			Map.Entry<Integer, List<Integer>> entry = treeMap.pollLastEntry();
			res.addAll(entry.getValue());
		}
		return res;
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
