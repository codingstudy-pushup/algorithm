package p1;

import java.util.*;

class TreeNode {
	int val;
	TreeNode left, right;

	TreeNode(int x) {
		this.val = x;
	}
}

public class LevelOrder {

	public static void main(String[] args) {
		TreeNode node = new TreeNode(1);
		node.left = new TreeNode(2);
		node.right = new TreeNode(3);
		node.left.left = new TreeNode(4);
		node.left.right = new TreeNode(5);
		System.out.println(solve(node));
	}

	public static List<List<Integer>> solve(TreeNode root) {
		// 1
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		List<List<Integer>> result = new ArrayList<>();

		while (!queue.isEmpty()) {

			int size = queue.size();
			List<Integer> level = new ArrayList<>();
			for (int i = 0; i < size; i++) {
				TreeNode curNode = queue.poll();
				level.add(curNode.val);
				if (curNode.left != null)
					queue.offer(curNode.left);
				if (curNode.right != null)
					queue.offer(curNode.right);
			}
			result.add(level);
		}
		return result;

	}
}
