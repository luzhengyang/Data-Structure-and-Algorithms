// Definition for singly-linked list.
class ListNode{
	int val;
	ListNode next;
	ListNode(int x){
		x = val;
	}
}


public class MergeTwoSortedList{
	public static void main(String[] args) {

	}

	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
        	return l2;
        }
        if (l2 == null) {
        	return l1;
        }

        ListNode l3;

        // select the smallest head from the two lists and make it the first node of the merged list
        if (l1.val < l2.val) {
        	l3 = l1;
        	l1 = l1.next;
        }
        else {
        	l3 = l2;
        	l2 = l2.next;
        }

        ListNode dummyhead = new ListNode(-1);
        dummyhead.next = l3;

        while (l1 != null && l2 != null) {
        	if (l1.val < l2.val) {
        		l3.next = l1;
        		l3 = l3.next;
        		l1 = l1.next;
        	}
        	else {
        		l3.next = l2;
        		l3 = l3.next;
        		l2 = l2.next;
        	}
        }

        // add all remaining nodes in either of the lists to the end of merged list
        if (l1 != null) {
        	l3.next = l1;
        }
        if (l2 != null) {
        	l3.next = l2;
        }

        return dummyhead.next;
    }
}
