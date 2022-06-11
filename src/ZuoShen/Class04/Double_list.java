package ZuoShen.Class04;

public class Double_list {
    public static void main(String[] args) {
        DoubleNode doubleNode1 = new DoubleNode(1);
        DoubleNode doubleNode2 = new DoubleNode(2);
        DoubleNode doubleNode3 = new DoubleNode(3);
        doubleNode1.next=doubleNode2;doubleNode2.pre=doubleNode1;doubleNode2.next=doubleNode3;doubleNode3.pre=doubleNode2;
        printDoubleLinkedList(doubleNode1);
        DoubleNode temp = reverseList(doubleNode1);
        printDoubleLinkedList(temp);
    }
    public static void printDoubleLinkedList(DoubleNode head){
        System.out.print("Double Linked List: ");
        DoubleNode end = null;
        while (head != null) {
            System.out.print(head.value + " ");
            end = head;
            head = head.next;
        }
        System.out.print("| ");
        while (end != null) {
            System.out.print(end.value + " ");
            end = end.pre;
        }
        System.out.println();
    }
    public static DoubleNode reverseList(DoubleNode head){
        DoubleNode pre = null;
        DoubleNode next = null;
        while (head!=null){
            next = head.next;
            head.next = pre;
            head.pre = next;
            pre = head;
            head = next;
        }
        return pre;
    }
}
class DoubleNode{
    int value;
    DoubleNode next;
    DoubleNode pre;
    DoubleNode(int value){
        this.value=value;
    }
}