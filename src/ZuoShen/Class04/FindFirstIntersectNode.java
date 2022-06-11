package ZuoShen.Class04;

public class FindFirstIntersectNode {
    public static void main(String[] args) {
        // 1->2->3->4->5->6->7->null
        Node head1 = new Node(1);
        head1.next = new Node(2);
        head1.next.next = new Node(3);
        head1.next.next.next = new Node(4);
        head1.next.next.next.next = new Node(5);
        head1.next.next.next.next.next = new Node(6);
        head1.next.next.next.next.next.next = new Node(7);
//
//        // 0->9->8->6->7->null
        Node head2 = new Node(0);
        head2.next = new Node(9);
        head2.next.next = new Node(8);
        head2.next.next.next = head1.next.next.next.next.next; // 8->6
        System.out.println(getIntersectNode(head1, head2).value);

        // 1->2->3->4->5->6->7->4...
        head1 = new Node(1);
        head1.next = new Node(2);
        head1.next.next = new Node(3);
        head1.next.next.next = new Node(4);
        head1.next.next.next.next = new Node(5);
        head1.next.next.next.next.next = new Node(6);
        head1.next.next.next.next.next.next = new Node(7);
        head1.next.next.next.next.next.next = head1.next.next.next; // 7->4

        // 0->9->8->2...
        head2 = new Node(0);
        head2.next = new Node(9);
        head2.next.next = new Node(8);
        head2.next.next.next = head1.next; // 8->2
        System.out.println(getIntersectNode(head1, head2).value);

        // 0->9->8->6->7->4->5->6..
        head2 = new Node(0);
        head2.next = new Node(9);
        head2.next.next = new Node(8);
        head2.next.next.next = head1.next.next.next.next.next; // 8->6
        System.out.println(getIntersectNode(head1, head2).value);
    }
    public static Node getIntersectNode(Node head1, Node head2) {
        if (head1==null||head2==null){
            return null;
        }
        Node loop1 = getLoopNode(head1);
        Node loop2 = getLoopNode(head2);
        if(loop1==null&&loop2==null){
            return noloop(head1,head2);
        }
        if(loop1!=null&&loop2!=null){
            return bothLoop(head1,loop1,head2,loop2);
        }
        return null;  //一个有环一个无环则直接Null 因为不可能相交
    }

    //获取入环节点
    public static Node getLoopNode(Node head) {
        if(head==null||head.next==null||head.next.next==null){
            return null;   //至少得三个元素才能构成环
        }
        Node fast=head.next.next;
        Node slow=head.next;
        while (slow!=fast){
            if(fast.next==null||fast.next.next==null){
                return null;
            }
            slow=slow.next;
            fast=fast.next.next;
        }
        //此时fast和slow在同一个位置上
        fast=head;
        while (fast!=slow){   //将其中一个节点放到头上，然后一步一步走，再次相遇就是入环节点。
            slow=slow.next;
            fast=fast.next;
        }
        return fast;
    }
    //两个链表都是无环的情况
    public static Node noloop(Node head1,Node head2){
        Node cur1 = head1;
        Node cur2 = head2;
        int n = 0;  //代表链表1长度-链表2长度
        while (cur1.next!=null){
            n++;
            cur1=cur1.next;
        }
        while (cur2.next!=null){
            n--;
            cur2=cur2.next;
        }
        if(cur1!=cur2){ //当两个的结尾节点内存地址不相等时，说明该无环链表不可能相交
            return null;
        }
        cur1 = n>0?head1:head2;    //长的放在cur1
        cur2 = cur1==head1?head2:head1; //另一个放在cur2
        n=Math.abs(n);
        while (n!=0){
            n--;
            cur1=cur1.next;
        }
        while (cur1!=cur2){
            cur1=cur1.next; //走到最后还不相等就会都走到null,会跳出循环因为都是null
            cur2=cur2.next;

        }
        return cur1;
    }
    //两个链表都是有环的情况
    public static Node bothLoop(Node head1, Node loop1, Node head2, Node loop2) {
        //此时分3种，两个有环链表不相交；相交且入环节点相同；相交且入环节点不同
        //首先第二种
        if(loop1==loop2){
            Node cur1 = head1;
            Node cur2 = head2;
            int n = 0;
            while (cur1 != loop1) {
                cur1=cur1.next;
                n++;
            }
            while (cur2 != loop2) {
                cur2=cur2.next;
                n--;
            }
            cur1 = n>0?head1:head2;
            cur2 = cur1==head1?head2:head1;
            n = Math.abs(n);
            while (n!=0){
                cur1=cur1.next;
                n--;
            }
            while (cur1!=cur2){
                cur1=cur1.next;
                cur2=cur2.next;
            }
            return cur1;
        }else {
            //此时为情况1和情况3
            Node cur1 = loop1.next;
            while (cur1!=loop1){
                if(cur1==loop2){
                    return loop1; //情况3  随便返回一个都行
                }
                cur1=cur1.next;
            }
            return null;  //情况1  loop1走了一圈发现没有loop2 说明没相交
        }
    }
}
