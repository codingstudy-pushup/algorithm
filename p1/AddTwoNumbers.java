package p1;

class ListNode{
	int val;
	ListNode next;
	ListNode(int x){
		this.val = x;
	}
}
public class AddTwoNumbers02 {

	public static void main(String[] args) {
		ListNode a = new ListNode(2);
		a.next = new ListNode(4);
		a.next.next = new ListNode(3);
		
		ListNode b = new ListNode(5);
		b.next = new ListNode(6);
		b.next.next = new ListNode(2);
		ListNode node = solve(a,b);
		while(node !=null) {
			System.out.println(node.val);
			node = node.next;
		}
	}
	private static ListNode solve(ListNode a, ListNode b) {
		ListNode resultNode = new ListNode(0);
		ListNode p1 =a, p2=b, p3 = resultNode;
		int carry =0;
		
		while(p1 != null && p2 != null) {
			if(p1 != null) {
				carry += p1.val;
				p1 = p1.next;
			}
			if(p2 != null) {
				carry += p2.val;
				p2 = p2.next;
			}
			p3.next = new ListNode(carry %10);
			p3 = p3.next;
			carry /=10;
		}
		if(carry==1) p3.next = new ListNode(1);
		return resultNode.next;

	}
}
