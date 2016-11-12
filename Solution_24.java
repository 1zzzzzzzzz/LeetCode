package main2;

public class Solution_24 {
	public static ListNode swapPairs(ListNode head){
		if(head==null||head.next==null){
			return head;
		}
		ListNode elem1 = head, elem2 = elem1.next;
		ListNode first = null, pre = null;
		int flag = 1;
		while(elem2!=null){
			ListNode s = new ListNode(elem2.val);
//			if(flag!=1)
//				System.out.println("pre.val: "+pre.val+" elem1.val "+elem1.val+" elem2.val: "+elem2.val);
			//É¾³ýelem2
			elem1.next = elem2.next;
			//s²åÈëµ½elem1Ç°
			if(flag!=1)
				pre.next = s;
			
			s.next = elem1;
			
			if(flag==1)
				first = s;
			pre = elem1;
			
			elem1 = elem2.next;
//			System.out.println("flag: "+flag+" elem1.val: "+elem1.val);
			if(elem1!=null){
				elem2 = elem1.next;
			}else{
				elem2 = null;
			}
			flag++;
		}
		return first;
	}

	public static void main(String[] args) {
		ListNode node1 = new ListNode(1);
		ListNode node2 = new ListNode(3);
		ListNode node3 = new ListNode(5);
		ListNode node4 = new ListNode(7);
		ListNode node5 = new ListNode(9);
		ListNode node6 = new ListNode(11);
//		node1.next = node2;
//		node2.next = null;
		
//		node1.next = node2;
//		node2.next = node3;
//		node3.next = node4;
//		node4.next = null;
		
//		node1.next = node2;
//		node2.next = node3;
//		node3.next = null;
		
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
		node5.next = node6;
		node6.next = null;
		
		ListNode res = swapPairs(node1);
		while(res!=null){
			System.out.print(res.val+"  ");
			res = res.next;
		}
	}

}
