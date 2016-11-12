package main2;

public class Solution_25_Reverse_Nodes_in_K_group {
	public static ListNode reverseKGroup(ListNode head, int k){
		if(head==null||k==1)
			return head;
		if(head.next==null)
			return head;
		ListNode first = head, rear = head, res = head, preFirst = null;
		int num = 1;
		while(first!=null){
			//rear指到最后，即要删除的点
			while(num < k&&rear!=null){
				rear = rear.next;
				num++;
			}
			if(num<k||rear==null)
				return res;
			
			ListNode nextFirst = rear.next;
			while(first.next!=nextFirst){
				//删除first
				ListNode s = new ListNode(first.next.val);
				first.next = first.next.next;
				//将s插入到head前面，并将head指向s
				s.next = head;
				head = s;
				if(preFirst != null)
					preFirst.next = head;
				else
					res = head;
			}
			head = first.next;
			rear = first.next;
			preFirst = first;
			first = first.next;
			num = 1;
		}
		return res;
	}

	public static void main(String[] args) {
		ListNode node1 = new ListNode(1);
		ListNode node2 = new ListNode(3);
		ListNode node3 = new ListNode(5);
		ListNode node4 = new ListNode(7);
		ListNode node5 = new ListNode(9);
		ListNode node6 = new ListNode(11);
		
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
		node5.next = node6;
		node6.next = null;
		
//		node1.next = node2;
//		node2.next = node3;
//		node3.next = null;
		
		
		int k = 9;
		ListNode res = reverseKGroup(node1, k);
		while(res!=null){
			System.out.print(res.val+"  ");
			res = res.next;
		}
	}

}
