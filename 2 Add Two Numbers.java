/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int c = 0;
        ListNode head = null;
        ListNode current = null;
        if((l1 == null)&&(l2 == null)){
        	return null;
        }
        if((l1==null)&&(l2!=null)){
        	return l2;
        }
        if((l2==null)&&(l1!=null)){
        	return l1;
        }
        
        while((l1!=null)&&(l2!=null)){
            int tempVal = l1.val + l2.val + c;
            if(tempVal>=10){
                tempVal = tempVal % 10;
                c = 1;
            }else{
                c = 0;
            }
            if(head==null){
                head = new ListNode(tempVal);
                current = head;
            }else{
                current.next = new ListNode(tempVal);
                current = current.next;
            }
            l1 = l1.next;
            l2 = l2.next;
        }//while
        while(l1!=null){
        	int temp = l1.val + c;
        	if(temp>=10){
        		c = 1;
        		temp = temp % 10;
        	}else{
        		c= 0;
        	}
        	l1.val = temp;
        	current.next = l1;
        	current = current.next;
        	l1 = l1.next;
        }
        while(l2!=null){
        	int temp = l2.val + c;
        	if(temp>=10){
        		c = 1;
        		temp = temp % 10;
        	}else{
        		c= 0;
        	}
        	l2.val = temp;
        	current.next = l2;
        	current = current.next;
        	l2 = l2.next;
        }
        //处理最后一位
        if(c==1){
            current.next = new ListNode(1);
        }
        return head;
    }

}