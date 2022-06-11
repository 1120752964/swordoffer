package LeetCode.easy;

public class reverseList206 {
    public static void main(String[] args) {
        ListNode head = new  ListNode(1);
        head.next=new  ListNode(2);
        head.next.next=new  ListNode(3);
        head.next.next.next=new  ListNode(4);
        head.next.next.next.next=new  ListNode(5);
        head.next.next.next.next.next=new  ListNode(6);
//        head.next.next.next.next.next.next=new  ListNode(7);
        head=reverseList2(head);
        while (head!=null){
            System.out.print(head.val+" ");
            head=head.next;
        }
    }
    public static ListNode reverseList2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }

    public static ListNode reverseList(ListNode head) {
        if(head==null){
            return null;
        }
        ListNode pre = head;
        ListNode cur = head.next;
        if(cur==null){
            return head;
        }
        ListNode next = head.next.next;
        if(next==null){
            pre.next=null;
            cur.next=pre;
            return cur;
        }
        pre.next=null;
        while (next!=null){
            cur.next=pre;
            pre=cur;
            cur=next;
            next=cur.next;
        }
        cur.next=pre;
        return cur;
    }
}
class ListNode {
      int val;
     ListNode next;
     ListNode() {}
     ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }
