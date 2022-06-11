package Sword_Offer;

import java.util.Arrays;
import java.util.List;

public class detectCycle022 {
    static class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
         val = x;
          next = null;
      }
    }

    public static void main(String[] args) {
        List<Integer> a1 = Arrays.asList(1, 3);
        ListNode a = new ListNode(-1);
        a.next=new ListNode(-7);
        a.next.next=new ListNode(7);
        a.next.next.next=new ListNode(-4);
        a.next.next.next.next=new ListNode(19);
        a.next.next.next.next.next=new ListNode(6);
        a.next.next.next.next.next.next=new ListNode(-9);
        a.next.next.next.next.next.next.next=new ListNode(-5);
        a.next.next.next.next.next.next.next.next=new ListNode(-2);
        a.next.next.next.next.next.next.next.next.next=new ListNode(-5);
        a.next.next.next.next.next.next.next.next.next.next=a.next.next.next.next.next.next;
        System.out.println(detectCycle(a).val);
    }

    public static ListNode detectCycle(ListNode head) {
        if(head==null){
            return null;
        }
        ListNode fast=head;
        ListNode slow=head;
        int pos=-1;
        while((fast.next!=null&&fast.next.next!=null)){
            slow=slow.next;
            fast=fast.next.next;
            pos++;
            if(fast==slow){
                break;
            }
        }
        if(pos==-1){
            return null;
        }
        if(slow==fast){
            System.out.println(fast.val);
            if(fast==head){
                return head;
            }
            //有环
            fast=head;
            while(fast!=slow){
                fast=fast.next;
                slow=slow.next;
            }
            System.out.println(fast.val);
            return fast.next;
        }
        return null;
    }
}
