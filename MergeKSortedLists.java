// Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.

// Divide and conquer

// Convert to subproblems - merge 2 sorted lists

import java.util.*;

public class MergeKSortedLists{
	public static ListNode mergeKSortedLists(ListNode[] lists){
		if(lists == null || lists.length == 0){
			return null;
		}
		int n = lists.length;
		if(n == 1){
			return lists[0];
		}
		else if(n == 2){
			return mergeTwoSortedLists(lists[0], lists[1]);
		}
		else{
			int mid = n/2;
			return mergeTwoSortedLists(mergeKSortedLists(Arrays.copyOfRange(lists, 0, mid)), mergeKSortedLists(Arrays.copyOfRange(lists, mid, n)));
		}
	}

	private static ListNode mergeTwoSortedLists(ListNode l1, ListNode l2){
		if(l1 == null && l2 == null){
			return null;
		}
		if(l1 == null){
			return l2;
		}
		if(l2 == null){
			return l1;
		}

		ListNode p;		// it's a pointer
		if(l1.val < l2.val){
			p = l1;
			l1 = l1.next;
		}
		else{
			p = l2;
			l2 = l2.next;
		}

		ListNode dummyHead = new ListNode(-1);
		dummyHead.next = p;

		while(l1 != null && l2 != null){
			if(l1.val < l2.val){
				p.next = l1;
				l1 = l1.next;
				p = p.next;
			}
			else{
				p.next = l2;
				l2 = l2.next;
				p = p.next;
			}
		}

		if(l1 == null){
			p.next = l2;
		}
		if(l2 == null){
			p.next = l1;
		}

		return dummyHead.next;
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
