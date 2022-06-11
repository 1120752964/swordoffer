package ZuoShen.Class06;

import ZuoShen.Class06.GetSuccessorNode.Node;
import java.util.LinkedList;
import java.util.Queue;
public class SerializeAndReconstructTree {
    public static String serialByPre(Node head){
        if(head==null){
            return "#_";
        }
        String res = head.value+"_";
        res+=serialByPre(head.left);
        res+=serialByPre(head.right);
        return res;
    }
    public static Node reconByPreString(String preStr){
        String[] values = preStr.split("_");
        Queue<String> queue = new LinkedList<>();
        for (int i = 0; i < values.length; i++) {
            queue.add(values[i]);
        }
        return reconPreOrder(queue);
    }

    public static Node reconPreOrder(Queue<String> queue){
        String value = queue.poll();
        if(value.equals("#")){
            return null;
        }
        Node cur = new Node(Integer.parseInt(value));
        cur.left = reconPreOrder(queue);
        cur.right = reconPreOrder(queue);
        return cur;
    }
}
