package ZuoShen.Class07;

import java.util.HashSet;
import java.util.Stack;

public class DFS {
    public static void dfs(Node node){
        HashSet<Node> set = new HashSet<>();
        Stack<Node> stack = new Stack<>();
        set.add(node);
        stack.push(node);
        while (!stack.isEmpty()){
            node=stack.pop();
            System.out.println(node.value);
            for(Node next:node.nexts){
                if(!set.contains(next)){
                    set.add(next);
                    stack.push(node);  //发现一个没访问过的  直接一条路走到黑
                    stack.push(next);
                    System.out.println(next.value);
                    break;
                }
            }
        }

    }
}
