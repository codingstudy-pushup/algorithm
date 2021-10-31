
import java.util.*;

public class A098_ConnectingCitiesWithMinCost {

	public static void main(String[] args) {
		int N = 3;
		int[][] connections = { { 1, 2, 5 }, 
                            { 1, 3, 6 }, 
                            { 2, 3, 1 } };
		A098_ConnectingCitiesWithMinCost a = new A098_ConnectingCitiesWithMinCost();
		a.solve_pq(N, connections);

	}

	public int solve_pq(int N, int[][] connections) {
		Map<Integer, List<int[]>> graph = new HashMap<>();
		PriorityQueue<int[]> heap = new PriorityQueue<>((a, b) -> a[2] - b[2]);
		Set<Integer> visited = new HashSet<>();
		int costs = 0;

		for (int[] conn : connections) {
			int n1 = conn[0], n2 = conn[1], cost = conn[2];

			graph.computeIfAbsent(n1, (k) -> new ArrayList<>());
			graph.computeIfAbsent(n2, (k) -> new ArrayList<>());
			graph.get(n1).add(new int[] { n2, cost });
			graph.get(n2).add(new int[] { n1, cost });
		}

		heap.add(new int[] { 1, 1, 0 });
		while (!heap.isEmpty()) {
			int[] conn = heap.poll();
			int n1 = conn[0], n2 = conn[1], cost = conn[2];

			if (!visited.contains(n2)) {
				costs += cost;
				visited.add(n2);
				for (int[] next : graph.get(n2)) {
					heap.add(new int[] { n2, next[0], next[1] });
				}
			}
		}

		return visited.size() == N ? costs : -1;
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

	public int minimumCost(int N, int[][] connections) {
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
}
