package ZuoShen.Class04;

import java.util.Stack;

import static ZuoShen.Class04.Linked_list.printLinkedList;

public class IsPalindromeList {
    public static void main(String[] args) {
        Node head = null;
        head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(1);
        head.next.next.next = new Node(2);
        head.next.next.next.next = new Node(1);
        printLinkedList(head);
        System.out.print(isPalindrome1(head) + " | ");
        System.out.print(isPalindrome2(head) + " | ");
        System.out.println(isPalindrome3(head) + " | ");
    }
    //方法一   需要O(n)的额外存储空间
    public static boolean isPalindrome1(Node head) {
        Stack<Node> nodes = new Stack<>();
        Node temp = head;
        while (temp!=null){
            nodes.push(temp);
            temp = temp.next;
        }
        temp = head;
        while (temp!=null){
            if(temp.value!=nodes.pop().value){
                return false;
            }
            temp = temp.next;
        }
        return true;
    }
    //方法二   需要O(n/2)的额外存储空间
    public static boolean isPalindrome2(Node head) {
        if (head == null || head.next == null) {
            return true;
        }
        Node fast = head;
        Node slow = head;
        while (fast!=null){
            if(fast.next!=null&&fast.next.next==null){
                fast=fast.next;//说明链表为偶数长度，且slow在对称轴的前一个
            }
            if(fast.next==null){
                break;  //说明链表为奇数长度，且slow在对称轴
            }
            fast=fast.next.next;
            slow=slow.next;
        }
        Node mid = slow.next;
        Stack<Node> nodes = new Stack<>();
        while (mid!=null){
            nodes.push(mid);
            mid=mid.next;
        }
        while (!nodes.isEmpty()){
            if(head.value!=nodes.pop().value){
                return false;
            }
            head=head.next;
        }
        return true;
    }
    //方法三   需要O(1)的额外存储空间
    public static boolean isPalindrome3(Node head) {
        if (head == null || head.next == null) {
            return true;
        }
        Node fast = head;
        Node slow = head;
        while (fast!=null){
            if(fast.next!=null&&fast.next.next==null){
                fast=fast.next;//说明链表为偶数长度，且slow在对称轴的前一个
            }
            if(fast.next==null){
                break;  //说明链表为奇数长度，且slow在对称轴
            }
            fast=fast.next.next;
            slow=slow.next;
        }
        //从mid开始  对后面的进行逆序操作
        Node mid = slow.next;
        Node temp = mid;
        Node next = null;
        Node pre = null;
        while (mid!=null){
            next=mid.next;
            mid.next=pre;
            pre=mid;
            mid=next;
        }
        //此时pre为右侧的头,将其和head开始比较
        while (pre!=null){
            if(pre.value!= head.value){
                return false;
            }
            pre=pre.next;
            head=head.next;
        }
        return true;
    }
}
