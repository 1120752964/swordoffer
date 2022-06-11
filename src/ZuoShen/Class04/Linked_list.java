package ZuoShen.Class04;

public class Linked_list {
    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        Node temp = node1;
        while (temp.next!=null){
            System.out.println("value:"+temp.value + "next:" + temp.next.value);
            temp = temp.next;
        }
        temp = reverseSinglyList1(node1);
        System.out.println("----------");
        while (temp.next!=null){
            System.out.println("value:"+temp.value + "next:" + temp.next.value);
            temp = temp.next;
        }
    }
    //
    public static Node reverseDoubleList2(Node head) {

        return null;
    }

    //递归反转法
    public static Node reverseSinglyList2(Node head){
        if(head==null||head.next==null){
            return head;
        }
        Node temp = head.next;  //temp作为head的下一个，用于回调时将指针指向head
        Node newHead = reverseSinglyList2(head.next); //保存新的头结点
        temp.next=head;    //更新指向
        head.next = null;  //更新指向
        return newHead;
    }
    //遍历反转法
    public static Node reverseSinglyList1(Node head){
        if(head==null){
            return null;
        }
        if(head.next==null){
            return head;
        }
        Node preNode = null;
        Node nextNode = null;
        while (head!=null){
            nextNode = head.next; //先保存下一个节点
            head.next = preNode;  //将现在的指向前一个
            preNode = head;   //将前一个挪到现在的  （指针已经完事，开始下一个）
            head = nextNode;  //然后将现在的往下走
        }
        return preNode;
    }
    public static void printLinkedList(Node node) {
        System.out.print("Linked List: ");
        while (node != null) {
            System.out.print(node.value + " ");
            node = node.next;
        }
        System.out.println();
    }
}
class Node{
    int value;
    Node next;
    Node(int value){
        this.value=value;
    }
}
