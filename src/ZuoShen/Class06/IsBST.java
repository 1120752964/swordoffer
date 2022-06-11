package ZuoShen.Class06;

import java.util.Stack;

public class IsBST {
    public static void main(String[] args) {

    }
    public static int preValue=Integer.MIN_VALUE;
    public static boolean isBST1(Node head){
        //方法一：递归形式中序遍历的判断
        if(head==null){
            return true;
        }
        boolean isLeftBst = isBST1(head.left);
        if(!isLeftBst){
            return false;
        }
        if(head.value<preValue){
            return false;
        }else {
            preValue= head.value;
        }
        return isBST1(head.right);
    }
    public static boolean isBST2(Node head) {
        //方法二：非递归形式中序遍历的判断
        System.out.print("in-order: ");
        if(head!=null){
            Stack<Node> nodes = new Stack<>();
            while (!nodes.empty()||head!=null){
                int preValue = Integer.MIN_VALUE;
                if(head!=null){
                    nodes.push(head);
                    head=head.left;
                }else {
                    head=nodes.pop();
                    if(head.value<=preValue){
                        return false;
                    }else {
                        preValue=head.value;
                    }
                    head=head.right;
                }
            }
        }
        return true;
    }
    public static class ReturnData{
        public boolean isBST;
        public int min;
        public int max;
        public ReturnData(boolean isBST,int min,int max){
            this.isBST=isBST;
            this.max=max;
            this.min=min;
        }
    }
    public static ReturnData process(Node x){
        //方法三：利用套路然后实现
        if(x==null){
//            return new ReturnData(true,)//因为这里最大值和最小值无法设置初始值所以设为null
            return null;
        }
        ReturnData leftData = process(x.left);
        ReturnData rightData = process(x.right);
        int min = x.value;
        int max = x.value;
        if(leftData!=null){
            min = Math.min(min,leftData.min);
            max = Math.max(min,leftData.max);
        }
        if(rightData!=null){
            min = Math.min(min,rightData.min);
            max = Math.max(min,rightData.max);
        }
        boolean isBST = true;
        if(leftData!=null&&(!leftData.isBST||leftData.max>=x.value)){
            isBST=false;
        }
        if(rightData!=null&&(!rightData.isBST||x.value>=rightData.min)){
            isBST=false;
        }
        return new ReturnData(isBST,min,max);
    }
}
class Node{
    int value;
    Node left;
    Node right;
    Node(int value){
        this.value = value;
    }
}