package ZuoShen.Class05;

import java.util.Stack;

public class IsSearchBinaryTree {
    public static void main(String[] args) {

    }
    public static void isBST(Node head){
        Stack<Node> nodes   = new Stack<>();
        nodes.push(head);
        Boolean flag=true;
        int temp = head.value;
        while (!nodes.isEmpty()){

            if(head!=null){
                nodes.push(head);
                head=head.left;
            }else {
                head=nodes.pop();

                head=head.right;
            }
        }
    }
}
