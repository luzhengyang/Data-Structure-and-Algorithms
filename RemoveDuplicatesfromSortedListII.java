// Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list.

// For example,
// Given 1->2->3->3->4->4->5, return 1->2->5.
// Given 1->1->1->2->3, return 2->3.



public class RemoveDuplicatesfromSortedListII{
	public ListNode deleteDuplicates(ListNode head){
		if(head == null || head.next == null){
			return head;
		}

		if(head.next != null && head.val == head.next.val){
			while(head.next != null && head.val == head.next.val){
				head = head.next;
			}
			return deleteDuplicates(head.next);
		}
		else{
			head.next = deleteDuplicates(head.next);
		}
		return head;
	}
}

class ListNode{
	int val;
	ListNode next;
	ListNode(int val){
		this.val = val;
	}
}
