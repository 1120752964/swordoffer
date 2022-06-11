package ZuoShen.Class05;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BinaryTreeTraversal {
    public static void main(String[] args) {
        Node head = new Node(5);
        head.left = new Node(3);
        head.right = new Node(8);
        head.left.left = new Node(2);
        head.left.right = new Node(4);
        head.left.left.left = new Node(1);
        head.right.left = new Node(7);
        head.right.left.left = new Node(6);
        head.right.right = new Node(10);
        head.right.right.left = new Node(9);
        head.right.right.right = new Node(11);
        // recursive
        System.out.println("==============recursive==============");
        System.out.print("pre-order: ");
        preOrderRecur(head);
        System.out.println();
        System.out.print("in-order: ");
        inOrderRecur(head);
        System.out.println();
        System.out.print("pos-order: ");
        posOrderRecur(head);
        System.out.println();

        // unrecursive
        System.out.println("============unrecursive=============");
        preOrderUnRecur(head);
        inOrderUnRecur(head);
        posOrderUnRecur1(head);
        posOrderUnRecur2(head);
        SequenceTraversal(head);
    }
    //preorder traversal先序遍历  recursive 递归的
    public static void preOrderRecur(Node head) {
        if(head==null){
            return;
        }
        System.out.print(head.value+" ");
        preOrderRecur(head.left);
        preOrderRecur(head.right);
    }
    //inorder traversal中序遍历
    public static void inOrderRecur(Node head) {
        if (head == null) {
            return;
        }
        inOrderRecur(head.left);
        System.out.print(head.value + " ");
        inOrderRecur(head.right);
    }
    //postorder traversal后序遍历
    public static void posOrderRecur(Node head) {
        if (head == null) {
            return;
        }
        posOrderRecur(head.left);
        posOrderRecur(head.right);
        System.out.print(head.value + " ");
    }
    public static void preOrderUnRecur(Node head) {
        //先右后左存入栈，弹出时打印
        System.out.print("pre-order: ");
        if (head!=null){
            Stack<Node> nodes = new Stack<>();
            nodes.push(head);
            while (!nodes.empty()){
                head=nodes.pop();
                System.out.print(head.value + " ");
                if(head.right!=null){
                    nodes.push(head.right);
                }
                if(head.left!=null){
                    nodes.push(head.left);
                }
            }
        }
        System.out.println();
    }
    public static void inOrderUnRecur(Node head) {
        //用null判断
        //先把左边界压入至null，然后如果是null，弹出栈顶，打印，将该元素的右孩子赋给变量继续循环
        System.out.print("in-order: ");
        if(head!=null){
            Stack<Node> nodes = new Stack<>();
            while (!nodes.empty()||head!=null){
                if(head!=null){
                    nodes.push(head);
                    head=head.left;
                }else {
                    head=nodes.pop();
                    System.out.print(head.value + " ");
                    head=head.right;
                }
            }
        }
        System.out.println();
    }
    public static void posOrderUnRecur1(Node head) {
        //用先左后右进栈，弹出存入收集栈 再弹出收集栈
        System.out.print("pos-order: ");
        if (head!=null){
            Stack<Node> nodes = new Stack<>();
            Stack<Node> collect = new Stack<>();
            nodes.push(head);
            while (!nodes.empty()){
                head=nodes.pop();
                collect.push(head);
                if(head.left!=null){
                    nodes.push(head.left);
                }
                if(head.right!=null){
                    nodes.push(head.right);
                }
            }
            var a = collect.iterator();
            while (a.hasNext()){
                System.out.print(collect.pop().value+" ");
            }
        }
        System.out.println();
    }
    public static void posOrderUnRecur2(Node head) {
        //用是否为左右子树判断
        //不用收集栈的后序遍历，先存入左边界，再peek 比较复杂
        System.out.print("pos-order: ");
        if (head != null) {
            Stack<Node> nodes = new Stack<>();
            nodes.push(head);
            Node c = null;
            while (!nodes.empty()){
                c = nodes.peek();
                if(c.left!=null&&head!=c.left&&head!=c.right){
                    //用于控制只将左边界传入 并且head!=c.left控制不去重复压栈 head!=c.right控制别理右子树
                    nodes.push(c.left);
                }else if(c.right!=null&&head!=c.right){
                    //当树从最左下方往上走时，如果有右子树则压栈，并且head!=c.right控制不去重复压栈
                    nodes.push(c.right);
                }else {
                    System.out.print(nodes.pop().value+" ");
                    head=c; //控制别再重复压栈
                }
            }
        }
        System.out.println();
    }
    public static void SequenceTraversal(Node head){
        //层序遍历
        Queue<Node> nodes = new LinkedList<>();
        if(head!=null){
            nodes.add(head);
            while (!nodes.isEmpty()){
                head = nodes.poll();
                System.out.print(head.value+" ");
                if(head.left!=null){
                    nodes.add(head.left);
                }
                if(head.right!=null){
                    nodes.add(head.right);
                }
            }
        }
        System.out.println();
    }
}
class Node{
    public int value;
    public Node left;
    public Node right;
    Node(int value){
        this.value = value;
    }
}
