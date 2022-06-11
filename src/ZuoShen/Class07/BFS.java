package ZuoShen.Class07;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class BFS {
    //从node出发，宽度优先遍历
    public static void bfs(Node node){
        if(node==null){
            return;
        }
        HashSet<Node> register = new HashSet<>();
        Queue<Node> queue = new LinkedList<>();
        register.add(node);
        queue.add(node);
        while (!queue.isEmpty()){
            node = queue.poll();
            System.out.println(node.value);
            for (Node a:node.nexts) {
                if(!register.contains(a)){
                    queue.add(a);
                    register.add(a);
                }
            }
        }
    }
}
