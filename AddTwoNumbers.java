class ListNode{
	int val;
	ListNode next;
	ListNode(int x){
		val = x;
	}
}

public class AddTwoNumbers{
	public static void main(String[] args) {

	}

	public ListNode addTwoNumbers(ListNode l1, ListNode l2){
		if (l1 == null) {
			return l2;
		}
		if (l2 == null) {
			return l1;
		}

		// set a flag to mark if the previous sum >= 10
		int carry = 0;

		// define a new list as the output list
		ListNode newhead = new ListNode(0);

		// add a pointer l3 to the output list
		ListNode l3 = newhead;

		while (l1 != null || l2 != null){
			if (l1 != null) {
				carry = carry + l1.val;
				l1 = l1.next;
			}

			if (l2 != null) {
				carry = carry + l2.val;
				l2 = l2.next;
			}

			l3.next = new ListNode(carry%10);
			carry = carry/10;
			l3 = l3.next;
		}

		if (carry==1) {
			l3.next = new ListNode(1);
		}

		// l3 is at the end of the output list,
		// so we need to return the head of the list.
		return newhead.next;
	}
}
