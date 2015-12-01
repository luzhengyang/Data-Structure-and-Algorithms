// Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.

// You should preserve the original relative order of the nodes in each of the two partitions.

// For example,
// Given 1->4->3->2->5->2 and x = 3,
// return 1->2->2->4->3->5.



public class PartitionList{
	public ListNode partition(ListNode head, int x){
		if(head == null || head.next == null){
			return head;
		}

		ListNode small = new ListNode(0);
		ListNode large = new ListNode(0);
		ListNode s = small;
		ListNode l = large;
		while(head != null){
			ListNode post = head.next;
			head.next = null;
			if(head.val < x){
				s.next = head;
				s = s.next;
			}
			else{
				l.next = head;
				l = l.next;
			}
			head = post;
		}
		s.next = large.next;
		return small.next;
	}
}

class ListNode{
	int val;
	ListNode next;
	ListNode(int val){
		this.val = val;
	}
}
