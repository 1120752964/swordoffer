package ZuoShen.Class06;
import java.util.LinkedList;
import java.util.Queue;
public class IsCST {
    public static void main(String[] args) {

    }
    public static boolean isCST(Node head){
        //层序遍历 来判断是否是满二叉树
        Queue<Node> nodes = new LinkedList<>();
        boolean leaf = false; //通过leaf判断是否经过左右孩子不全的节点  如果经过后，后续节点都应该为叶子节点
        Node l=null;
        Node r=null;
        if(head!=null){
            nodes.add(head);
            while (!nodes.isEmpty()){
                head = nodes.poll();
                l = head.left;
                r = head.right;
                if((leaf&&(l!=null||r!=null)) //遇到过左右孩子不全的节点后，leaf为true;右侧如果左右孩子有一个就为true，并返回false
                   || (l==null&&r!=null)    //无左孩子有右孩子直接false
                ){
                    return false;
                }
                if(l!=null){
                    nodes.add(head.left);
                }
                if(r!=null){
                    nodes.add(head.right);
                }
                if(l==null || r==null){
                    leaf=true;//遇到左右孩子不全时，则后面必须都为叶子节点
                }
            }
        }
        return true;
    }
}
