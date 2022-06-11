package ZuoShen.Class07;

import java.util.ArrayList;

public class Node {
    public int value;//结点的值
    public int in;   //该节点的入度
    public int out;  //该节点的出度
    public ArrayList<Node> nexts;  //该节点指向的那些节点
    public ArrayList<Edge> edges;  //以该节点为初始 发出去的那些边
    public Node(int value){
        this.value=value;
        in=0;
        out=0;
        nexts=new ArrayList<>();
        edges=new ArrayList<>();
    }

}
