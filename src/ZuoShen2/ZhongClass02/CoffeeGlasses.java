package ZuoShen2.ZhongClass02;

import java.util.Comparator;
import java.util.PriorityQueue;

public class CoffeeGlasses {

    //方法二：稍微好一点的解法
    public static class Machine{
        public int timePoint;
        public int workTime;

        public Machine(int t,int w){
            timePoint=t;
            workTime=w;
        }
    }

    public static class MachineComparator implements Comparator<Machine> {
        @Override
        public int compare(Machine o1,Machine o2) {
            return (o1.timePoint+o1.workTime)-(o2.timePoint+o2.workTime);
        }
    }

    //方法二，每个人暴力尝试每一个咖啡机给自己做咖啡，优化成贪心
    public static int minTime(int[] arr,int n,int a,int b){
        PriorityQueue<Machine> heap = new PriorityQueue<>(new MachineComparator());
        for (int i = 0; i < arr.length; i++) {
            heap.add(new Machine(0,arr[i]));
        }
        int[] drinks = new int[n];
        for (int i = 0; i < n; i++) {
            Machine cur = heap.poll();
            cur.timePoint += cur.workTime;
            drinks[i] = cur.timePoint;
            heap.add(cur);
        }
        return process(drinks,a,b,0,0);
    }


    //洗杯子的过程  调用：return process(drinks,a,b,0,0);
    //假设洗咖啡杯的机器，在washLine的时间才有空
    //a 洗杯子的机器洗一杯的时间
    //b 咖啡杯子自然挥发的时间
    //如果要洗完drinks[index...N-1]，返回最早完成所有事情的时间点
    //方法二，洗咖啡杯的方式和原来一样，知识这个暴力版本减少了一个可变参数
    public static int process(int[] drinks,int a,int b,int index,int washLine){
        if(index==drinks.length-1){  //只剩最后一个杯子了
            return Math.min(Math.max(washLine,drinks[index])+a,drinks[index]+b);
        }
        //wash是当前的咖啡杯，决定放到洗咖啡的机器里去洗，什么时候能洗完
        int wash = Math.max(washLine,drinks[index])+a;
        //洗完剩下所有的咖啡杯最早的结束时间
        int next1 = process(drinks,a,b,index+1,wash);
        //就是我用机器洗的时候，其它杯子想洗的话只能自然烘干，万一后面的自然烘干比我洗的还快那最后答案就是我洗完的时间
        int p1 = Math.max(wash,next1);

        //dry是当前的咖啡杯，决定自然晾干，什么时候能洗完
        int dry = drinks[index]+b;
        int next2 = process(drinks,a,b,index+1,washLine);
        int p2 = Math.max(dry,next2);
        return Math.min(p1,p2);
    }


}
