package LeetCode.medium;

import java.util.*;

public class levelOrder429 {
    //N叉树的层序遍历  
    public static void main(String[] args) {

    }
//    public static List<List<Integer>> levelOrder(Node root) {
//        List<List<Integer>> result = new ArrayList<>();
//        Queue<Node> queue = new LinkedList<>();
//        queue.add(root);
//        while(queue.size()!=0){
//        }
//        Map<Integer,Integer> map = new HashMap<>();
//
//    }


}
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
}
