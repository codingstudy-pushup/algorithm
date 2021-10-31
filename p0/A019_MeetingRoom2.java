package p00;

import java.util.*;

public class MeetingRoom2 {
	
	public static void main(String[] args) {
		MeetingRoom2 a = new MeetingRoom2();
		int[][] rooms= {{5,10},
				        {8,20},
				        {0,3}};
		System.out.println(a.solve(rooms));
		System.out.println(a.solve(rooms));
	}
	
	public int solve(int[][] intervals) {
		int n = intervals.length, rooms =0;
		int[] start = new int[n];
		int[] end = new int[n];
		
		for(int i=0; i<n; i++) {
			start[i]=intervals[i][0];
			end[i] =intervals[i][1];
		}
		Arrays.sort(start);
		Arrays.sort(end);
		
		int endIdx=0;
		for(int startIdx=0; startIdx<start.length; startIdx++) {
			if(start[startIdx] < end[endIdx])
				rooms++;
			else endIdx++;
		}
		return rooms ;
	}
	
	//pq 1차원
	public int solve_pq(int[][] intervals) {
		Arrays.sort(intervals , (a,b)->a[0]-b[0]);
		Queue<Integer> minHeap = new PriorityQueue<>();
		//기준 만들기
		minHeap.offer(intervals[0][1]);
		
		for(int i=0; i<intervals.length; i++) {
			if(minHeap.peek() <= intervals[i][0])
				minHeap.poll();
			minHeap.offer(intervals[i][1]);
		}
		return minHeap.size();
	}

}
