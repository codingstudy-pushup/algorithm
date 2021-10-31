class TreeNode {
	int val;
	TreeNode left, right;

	TreeNode(int x) {
		this.val = x;
	}
}

public class A124_BinaryTreeMaxPath {

	public static void main(String[] args) {
//		TreeNode tree = new TreeNode(1);
//		tree.left = new TreeNode(2);
//		tree.right = new TreeNode(3);

//		-10,9,20,null,null,15,7
		TreeNode tree = new TreeNode(-10);
		tree.left = new TreeNode(9);
		tree.right = new TreeNode(20);
		tree.right.left = new TreeNode(15);
		tree.right.right = new TreeNode(7);
		A124_BinaryTreeMaxPath a = new A124_BinaryTreeMaxPath();
		System.out.println(a.maxPathSum(tree));

	}
	
	int maxValue;

	public int maxPathSum(TreeNode root) {
		maxValue = Integer.MIN_VALUE;
		maxPathDown(root);
		return maxValue;
	}

	private int maxPathDown(TreeNode node) {
		if (node == null)
			return 0;
		int left = Math.max(0, maxPathDown(node.left));
		int right = Math.max(0, maxPathDown(node.right));
		maxValue = Math.max(maxValue, left + right + node.val);
		return Math.max(left, right) + node.val;
	}
	

}
