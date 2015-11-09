// Reverse a linked list from position m to n. Do it in-place and in one-pass.

// For example:
// Given 1->2->3->4->5->NULL, m = 2 and n = 4,

// return 1->4->3->2->5->NULL.

// Note:
// Given m, n satisfy the following condition:
// 1 ≤ m ≤ n ≤ length of list.


public class ReverseLinkedList2{
	public static ListNode reverse(ListNode head, int m, int n){
		ListNode dummyHead = new ListNode(0);
		dummyHead.next = head;
		ListNode pre = dummyHead;
		ListNode first = head;

		for(int i=1; i<m; i++){
			pre = pre.next;
			first = first.next;
		}

		for(int i=0; i<n-m; i++){
			ListNode cur = first.next;
			first.next = cur.next;
			cur.next = pre.next;
			pre.next = cur;
		}

		return dummyHead.next;
	}

	public static void main(String[] args) {
		ListNode l1 = new ListNode(1);
		ListNode l2 = new ListNode(2);
		ListNode l3 = new ListNode(3);
		ListNode l4 = new ListNode(4);
		ListNode l5 = new ListNode(5);
		l1.next = l2;
		l2.next = l3;
		l3.next = l4;
		l4.next = l5;
		ListNode head = reverse(l1, 2, 4);
		while(head != null){
			System.out.println(head.val);
			head = head.next;
		}
	}
}

class ListNode{
	int val;
	ListNode next;
	ListNode(int x){
		val = x;
		next = null;
	}
}
