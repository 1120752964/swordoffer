package Sword_Offer;

import java.util.*;

public class flatten028 {
    public static void main(String[] args) {
        String a ="asdas";
        int [] b = new int[123];
        int [] c = new int[123];
        HashMap<int[],Integer> hashMap;
        Arrays.equals(b,c);
        Node a1 = new Node(1);
        Node a2 = new Node(2);
        Node a3 = new Node(3);
        Node a4 = new Node(4);
        Node a5 = new Node(5);
        Node a6 = new Node(6);
        Node a7 = new Node(7);
        Node a8 = new Node(8);
        Node a9 = new Node(9);
        Node a10 = new Node(10);
        Node a11 = new Node(11);
        Node a12 = new Node(12);
        a1.next=a2;a2.prev=a1;
        a2.next=a3;a3.prev=a2;
        a3.next=a4;a4.prev=a3;
        a4.next=a5;a5.prev=a4;
        a5.next=a6;a6.prev=a5;
        a3.child=a7;
        a7.next=a8;a8.prev=a7;
        a8.next=a9;a9.prev=a8;
        a9.next=a10;a10.prev=a9;
        a8.child=a11;
        a11.next=a12;a12.prev=a11;
        flatten(a1);
    }

    public static Node flatten(Node head) {
        Deque<Node> stack =new LinkedList<>();
        Node a=head;
        while(head!=null&&head.child==null){
            head=head.next;
        }
        //head==null
        if(head==null){
            return a;
        }
        //碰到有子节点的了
        stack.push(head.next);
        Node x1=head;
        head.next=head.child;
        head.child.prev=head;
        head=head.child;
        x1.child=null;
        Node pre=head;
        while(!stack.isEmpty()||head!=null){
            //
            while(head!=null&&head.child==null){
                pre=head;
                head=head.next;
            }
            if(head==null){
                if(stack.isEmpty()){break;}
                Node temp = stack.pop();
                temp.prev=pre;
                pre.next=temp;
                head=temp;
                continue;
            }
            if(head.child!=null){
                stack.push(head.next);
                Node x=head;
                head.next=head.child;
                head.child.prev=head;
                head=head.child;
                x.child=null;
            }
        }
        return a;
    }
}
class Node {

    public int val;
    public Node prev;
    public Node next;
    public Node child;
    Node(int val){
        this.val=val;
    }
};
