package p1;

import java.util.*;

public class A011_ConnectingCitiesWithMinCost {

	public static void main(String[] args) {
		int N = 3;
		int[][] connections = { { 1, 2, 5 }, { 1, 3, 6 }, { 2, 3, 1 } };
		A011_ConnectingCitiesWithMinCost a = new A011_ConnectingCitiesWithMinCost();
		System.out.println(a.solve_pq(N, connections));
		System.out.println(a.solve_unionFiind(N, connections));

	}
	
	int[] parent;
	int n;

	private void union(int x, int y) {
		int px = find(x);
		int py = find(y);

		if (px != py) {
			parent[px] = py;
			n--;
		}
	}

	private int find(int x) {
		if (parent[x] == x) {
			return parent[x];
		}
		parent[x] = find(parent[x]); // path compression
		return parent[x];
	}

	public int solve_unionFiind(int N, int[][] connections) {
		parent = new int[N + 1];
		n = N;
		for (int i = 0; i <= N; i++) {
			parent[i] = i;
		}

		Arrays.sort(connections, (a, b) -> (a[2] - b[2]));

		int res = 0;

		for (int[] c : connections) {
			int x = c[0], y = c[1];
			if (find(x) != find(y)) {
				res += c[2];
				union(x, y);
			}
		}

		return n == 1 ? res : -1;
	}

	public int solve_pq(int N, int[][] connections) {
		List<List<int[]>> graph = new ArrayList<>();
		for (int i = 0; i <= N; i++)
			graph.add(new ArrayList<>()); // start from 0
		for (int[] c : connections) {
			graph.get(c[0]).add(new int[] { c[1], c[2] });
			graph.get(c[1]).add(new int[] { c[0], c[2] });
		}

		Queue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]); // minHeap compare with cost
		boolean[] visited = new boolean[N + 1];
		pq.offer(new int[] { 1, 0 }); // suppose there is a start 0 node with 0-1 cost is 0.
		int numberOfCitiesVisited = 0, cost = 0;
		while (!pq.isEmpty()) {
			int[] cur = pq.poll();
			if (visited[cur[0]])
				continue;

			cost += cur[1];
			visited[cur[0]] = true;
			numberOfCitiesVisited++; // not all node may be visited.

			List<int[]> neis = graph.get(cur[0]);
			for (int[] nei : neis) {
				if (visited[nei[0]])
					continue; // if already visted, it means there is a path with smaller cost that can get to
								// it, so we do not need to access it again.
				pq.offer(nei);
			}
		}
		return numberOfCitiesVisited == N ? cost : -1;
	}

	
}
