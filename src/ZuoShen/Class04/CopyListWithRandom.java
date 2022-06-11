package ZuoShen.Class04;

import java.util.HashMap;
import java.util.Map;

public class CopyListWithRandom {
    public static void main(String[] args) {
        Node head = null;
        Node res1 = null;
        Node res2 = null;
        head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        head.next.next.next.next.next = new Node(6);
        head.rand = head.next.next.next.next.next; // 1 -> 6
        head.next.rand = head.next.next.next.next.next; // 2 -> 6
        head.next.next.rand = head.next.next.next.next; // 3 -> 5
        head.next.next.next.rand = head.next.next; // 4 -> 3
        head.next.next.next.next.rand = null; // 5 -> null
        head.next.next.next.next.next.rand = head.next.next.next; // 6 -> 4
        printRandLinkedList(head);
        res1 = copyListWithRand1(head);
//        printRandLinkedList(res1);
        res2 = copyListWithRand2(head);
        printRandLinkedList(res2);
        printRandLinkedList(head);
        System.out.println("=========================");

    }
    //方法一
    public static Node copyListWithRand1(Node head) {
        HashMap<Node,Node> nodeNodeMap = new HashMap<>();
        Node cur = head;
        while (cur!=null){
            nodeNodeMap.put(cur,new Node(cur.value));
            cur=cur.next;
        }
        cur=head;
        while (cur!=null){
            nodeNodeMap.get(cur).next=nodeNodeMap.get(cur.next);
            nodeNodeMap.get(cur).rand=nodeNodeMap.get(cur.rand);
            cur=cur.next;
        }
        return nodeNodeMap.get(head);
    }
    //方法二
    public static Node copyListWithRand2(Node head) {
        Node cur = head;
        //复制这些节点
        while (cur!=null){
            Node temp = new Node(cur.value);
            temp.next= cur.next;
            cur.next=temp;
            cur=temp.next;
        }
        cur=head;
        //绑定rand
        //因为复制了一份所以一定是偶数
        while (cur!=null) {
            //直接赋值rand.next有可能rand是null而导致空指针
            cur.next.rand=cur.rand==null?null:cur.rand.next;
            cur=cur.next.next;
        }
        cur=head;
        Node head2 = cur.next;
        Node a = cur.next;
        //split这两个链表
        while (cur.next.next!=null) {
            cur.next=head2.next;
            cur=head2.next;
            head2.next=cur.next;
            head2=cur.next;
        }
        cur.next=null;
        return a;
    }
    public static void printRandLinkedList(Node head) {
        Node cur = head;
        System.out.print("order: ");
        while (cur != null) {
            System.out.print(cur.value + " ");
            cur = cur.next;
        }
        System.out.println();
        cur = head;
        System.out.print("rand:  ");
        while (cur != null) {
            System.out.print(cur.rand == null ? "- " : cur.rand.value + " ");
            cur = cur.next;
        }
        System.out.println();
    }

    public static class Node {
        public int value;
        public Node next;
        public Node rand;

        public Node(int data) {
            this.value = data;
        }
    }
}
