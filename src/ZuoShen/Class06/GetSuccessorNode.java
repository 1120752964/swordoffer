package ZuoShen.Class06;

public class GetSuccessorNode {
    public static class Node{
        public int value;
        public Node left;
        public Node right;
        public Node parent;
        public Node(int val) {
            value = val;
        }
    }
    public static Node getSuccessorNode(Node node){
        if(node==null){
            return null;
        }
        if(node.right!=null){
            return getLeftMost(node);
        }else {
            Node parent = node.parent;
            while (parent!=null&&node!=parent.left){
                node = parent;
                parent=parent.parent;
            }
            return parent;
        }

    }
    public static Node getLeftMost(Node node){
        if(node==null){
            return null;
        }
        while (node.left!=null){
            node=node.left;
        }
        return node;
    }
}
