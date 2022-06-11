package ZuoShen.Class04;


import java.util.Arrays;

import static ZuoShen.Class04.Linked_list.printLinkedList;

public class SmallerEqualBigger {
    public static void main(String[] args) {
        Node head1 = new Node(7);
        head1.next = new Node(9);
        head1.next.next = new Node(1);
        head1.next.next.next = new Node(8);
        head1.next.next.next.next = new Node(5);
        head1.next.next.next.next.next = new Node(2);
        head1.next.next.next.next.next.next = new Node(5);
        printLinkedList(head1);
        head1 = listPartition2(head1,5);
        printLinkedList(head1);
    }
    //笔试方法
    public static Node listPartition1(Node head, int pivot) {
        if (head == null) {
            return head;
        }
        int length = 0;
        Node temp = head;
        while (temp!=null){
            length++;
            temp=temp.next;
        }
        temp=head;
        Node[] nodes = new Node[length];
        int i = 0;
        for (; i < length; i++) {
            nodes[i] = temp;
            temp=temp.next;
        }

        //partition部分
        int left = 0;
        int right = length-1;
        for ( i = 0; i !=right; ) { //这里  i要和right比较而不是length！！
            if(nodes[i].value<pivot){
                swap(nodes,left,i);
                i++;
                left++;
            }else if(nodes[i].value>pivot){
                swap(nodes,right,i);
                right--;
            }else {
                i++;
            }
        }
        //将数组转成链表
        for ( i = 1; i != length; i++) {
            nodes[i-1].next=nodes[i];
        }
        nodes[i - 1].next = null;
        return nodes[0];
    }
    //面试方法
    public static Node listPartition2(Node head, int pivot) {
        Node sH = null;
        Node sT = null;
        Node eH = null;
        Node eT = null;
        Node bH = null;
        Node bT = null;
        Node next = null;
        Node temp = head;
        while (temp!=null){
            //此处需要断开节点之间原来的联系 很重要！！
            next = temp.next;
            temp.next=null;
            if(temp.value<pivot){
                if(sH==null){
                    sH=temp;
                    sT=temp;
                }else {
                    //该写给sH串值，然后sT指向temp
                    sT.next=temp;
                    sT = temp;
                }
            }else if(temp.value==pivot){
                if(eH==null){
                    eH=temp;
                    eT=temp;
                }else {
                    //该写给sH串值，然后sT指向temp
                    eT.next=temp;
                    eT = temp;
                }
            }else {
                if(bH==null){
                    bH=temp;
                    bT=temp;
                }else {
                    //该写给sH串值，然后sT指向temp
                    bT.next=temp;
                    bT = temp;
                }
            }
            temp=next;
        }
        //sT连eH，eT连bH
//        sT.next=eH;
//        eT.next=bH;
        //我的代码没有判断当st、eT为null时的情况,当null.next时会报错
        if(sT!=null){
            sT.next=eH;
            eT= eT==null?sT:eT; //eT==null的时候说明eH也是null，因此sT此时指向null
                                //eT!=null时，说明此时链表尾部是eT
        }
        if(eT!=null){
            eT.next=bH;    //然后如果bH是null的话，无所谓，bH不是的话连上第三个链
        }
        //以上情况中唯独没判断sT==null的情况，在return里面讲的
        //如果sH==null，则sT==null，此时进入第一个:后面，如果eH还是null，返回bH，否则返回eH，因为eT和bH一定是连着的
        return sH!=null?sH:eH!=null?eH:bH; //通过返回eH完成逆序
    }
    public static void swap(Node[] arr, int i, int j) {
        Node tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
