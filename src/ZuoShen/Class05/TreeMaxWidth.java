package ZuoShen.Class05;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class TreeMaxWidth {
    public static void main(String[] args) {
        Node head = new Node(5);
        head.left = new Node(3);
        head.right = new Node(8);
        head.left.left = new Node(2);
        head.left.right = new Node(4);
        head.left.left.left = new Node(1);
        head.left.left.right = new Node(3);
        head.right.left = new Node(7);
        head.right.left.left = new Node(6);
        head.right.right = new Node(10);
        head.right.right.left = new Node(9);
        head.right.right.right = new Node(11);
        System.out.println(getMaxWidth1(head));
        System.out.println(getMaxWidth2(head));
        System.out.println(getMaxWidth3(head));
    }

    public static int getMaxWidth1(Node head){
        //方法一  用哈希表完成
        Queue<Node> nodes = new LinkedList<>();
        HashMap<Node,Integer> map = new HashMap<>();
        nodes.add(head);
        map.put(head,1);
        int curlevel = 1;
        int curNodeNum = 0;
        int max=Integer.MIN_VALUE;
        if(head!=null){
            while (!nodes.isEmpty()){
                head=nodes.poll();
                if(map.get(head)==curlevel){
                    curNodeNum++;
                }else {
                    max=Math.max(max,curNodeNum);
                    curNodeNum=1;
                    curlevel++;
                }
                if(head.left!=null){
                    nodes.add(head.left);
                    map.put(head.left,curlevel+1);
                }
                if(head.right!=null){
                    nodes.add(head.right);
                    map.put(head.right,curlevel+1);
                }
            }
        }
        return Math.max(max,curNodeNum);
    }
    public static int getMaxWidth2(Node head){
        //方法二：不用Hashmap只用队列，再加上max、curNode、head、curnum、curendNode四个变量
        Queue<Node> nodes = new LinkedList<>();
        nodes.add(head);
        Node curendNode = head;//当前层的最后一个
        Node curNode = null;   //当前节点
        int curnum = 0;//当前层数量
        int max = Integer.MIN_VALUE;
        while (!nodes.isEmpty()){
            head=nodes.poll();  //head用于遍历
            if(head.left!=null){
                nodes.add(head.left);
                curNode=head.left;  //curNode用于记录新进队列的节点
            }
            if(head.right!=null){
                nodes.add(head.right);
                curNode=head.right;
            }
            curnum++;
            if(head==curendNode){
                max=Math.max(max,curnum);
                curnum=0;
                curendNode=curNode; //将最新进入队列的节点作为当前层的尾部
                curNode=null;
            }
        }
        return max;
    }
    public static int getMaxWidth3(Node head){
        //方法三：层序遍历
        Queue<Node> nodes = new LinkedList<>();
        nodes.add(head);
        int max = Integer.MIN_VALUE;
        int curSize; //当前层的大小
        while (!nodes.isEmpty()){
            curSize=nodes.size();
            max=Math.max(max,curSize);
            for (int i = 0; i < curSize; i++) {//重点在于这个for循环次数为size大小，因此上一层的一定会被全部弹出
                head=nodes.poll();              //下一层的全部进入  然后重新计算size
                if(head.left!=null){
                    nodes.add(head.left);
                }
                if(head.right!=null){
                    nodes.add(head.right);
                }
            }
        }
        return max;
    }
}
