package ZuoShen2.ZhongClass02;

import java.util.HashMap;

public class TopKTimes {
    public static class Node {
        public String str;
        public int times;

        public Node(String s, int t) {
            str = s;
            times = t;
        }
    }

    public static class TopKRecord{
        //因为Node有自己的词频，因此这个表就是词频表
        private HashMap<String,Node> strNodeMap;
        //堆
        private Node[] heap;
        //如果能在这个表里查到 说明有过记录，如果是-1说明不在堆上，如果>0在堆上
        private HashMap<Node,Integer> nodeIndexMap;
        //堆的大小
        private int heapSize;

        public TopKRecord(int K){
            heap=new Node[K];
            heapSize =0;
            strNodeMap=new HashMap<String,Node>();
            nodeIndexMap=new HashMap<Node,Integer>();
        }

        public void add(String str){
            //当前str对应的节点对象
            Node curNode = null;
            //当前str对应的节点对象是否在堆上
            int preIndex = -1;
            if(!strNodeMap.containsKey(str)){//str第一次出现
                curNode = new Node(str,1);
                strNodeMap.put(str,curNode);
                nodeIndexMap.put(curNode,-1);
            }else {//并非第一次出现
                curNode = strNodeMap.get(str);
                curNode.times++;
                preIndex = nodeIndexMap.get(curNode);
            }
            if(preIndex == -1){//当前str对应的节点对象，词频增加之后，不在堆上
                if(heapSize == heap.length){//考虑能不能干掉最弱的候选人，小根堆的原因
                    if(heap[0].times<curNode.times){
                        nodeIndexMap.put(heap[0],-1);
                        nodeIndexMap.put(curNode,0);
                        heap[0]=curNode;
                        heapify(0, heapSize);
                    }
                }else {
                    nodeIndexMap.put(curNode, heapSize);
                    heap[heapSize]=curNode;
                    heapInsert(heapSize++);
                }
            }else {
                heapify(preIndex, heapSize);
            }
        }

        public void printTopK(){
            System.out.println("TOP:");;
            for (int i = 0; i != heap.length; i++) {
                if(heap[i]==null){
                    break;
                }
                System.out.print("Str:"+heap[i].str);
                System.out.println("Times:"+heap[i].times);
            }
        }

        private void heapInsert(int index){
            while (index!=0){
                int parent = (index)-1/2;
                if(heap[index].times<heap[parent].times){
                    swap(parent,index);
                    index=parent;
                }else {
                    break;
                }
            }
        }

        private void heapify(int index,int heapSize){
            int l = index*2+1;
            int r = index*2+2;
            int smallest = index;
            while (l<heapSize){
                //找到index和它的两个孩子中最小的那个赋给smallest
                if(heap[l].times<heap[index].times){
                    smallest=l;
                }
                if(r<heapSize&&heap[r].times<heap[smallest].times){
                    smallest=r;
                }
                if(smallest!=index){
                    swap(smallest,index);
                }else {
                    break;
                }
                index = smallest;
                l = index*2+1;
                r = index*2+2;
            }
        }

        private void swap(int index1,int index2){
            nodeIndexMap.put(heap[index1],index2);
            nodeIndexMap.put(heap[index2],index1);
            Node temp = heap[index1];
            heap[index1] = heap[index2];
            heap[index2] = temp;
        }


    }
}
