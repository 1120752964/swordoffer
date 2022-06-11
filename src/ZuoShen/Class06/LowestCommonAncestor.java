package ZuoShen.Class06;

import java.util.HashMap;
import java.util.HashSet;

public class LowestCommonAncestor {
    public static Node lca (Node head,Node o1,Node o2){
        if(head==null||head==o1||head==o2){
            return head;
        }
        Node left = lca(head.left,o1,o2);
        Node right = lca(head.right,o1,o2);
        if(left!=null&&right!=null){
            return head;
        }
        return left==null?right:left;
    }
    public static Node lca2 (Node head,Node o1,Node o2){
        //方法一：利用一个map构件节点向上找父节点的效果，利用set查找两者第一个相同的向上找到的父节点
        HashMap<Node,Node> fatherMap = new HashMap<>();
        fatherMap.put(head,head);//放入head的映射
        process(head,fatherMap);
        HashSet<Node> set1 = new HashSet<>();
        Node cur = o1;
        while (cur!=fatherMap.get(cur)){ //自己等于自己的映射  只有head会触发这个条件
            set1.add(fatherMap.get(cur));
            cur=fatherMap.get(cur);
        }
        cur = o2;
        while (cur!=fatherMap.get(cur)){
            if(set1.contains(cur)){  //当找到第一个时，就直接return
                return cur;
            }
            cur=fatherMap.get(cur);
        }
        return null;//感觉这个return没意义 如果符合题设 o1,o2都在head树中
    }
    public static void process(Node head,HashMap<Node,Node> fatherMap){
        //该函数的作用就是将所有节点(出去根节点)将他们和他们的父节点的映射放入map中
        if(head==null){
            return;
        }
        fatherMap.put(head.left,head);
        fatherMap.put(head.right,head);
        process(head.left,fatherMap);
        process(head.right,fatherMap);
    }
}
