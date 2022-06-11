package LeetCode.note;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

public class Binary_Add_Sub_ {
    /**
     * 加法
     * @param a
     * @param b
     * @return
     */
    public static int add(int a,int b) {
        int res=a;
        int xor=a^b;//得到原位和
        int forward=(a&b)<<1;//得到进位和
        if(forward!=0){//若进位和不为0，则递归求原位和+进位和
            res=add(xor, forward);
        }else{
            res=xor;//若进位和为0，则此时原位和为所求和
        }
        return res;
    }

    /**
     * 减法
     * @param a
     * @param b
     * @return
     */
    public static int minus(int a,int b) {
//        int B=~(b-1);
        int B=~b+1;
        return add(a, B);
    }

    /**
     * 乘法
     * @param a
     * @param b
     * @return
     */
    public static int multi(int a,int b){
        int i=0;
        int res=0;
        while(b!=0){//乘数为0则结束
            //处理乘数当前位
            if((b&1)==1){
                res+=(a<<i);
                b=b>>1;
                ++i;//i记录当前位是第几位
            }else{
                b=b>>1;
                ++i;
            }
        }
        return res;
    }

    /**
     * 除法
     * @param a
     * @param b
     * @return
     */
    public static int sub(int a,int b) {
        int res=-1;
        if(a<b){
            return 0;
        }else{
            res=sub(minus(a, b), b)+1;
        }
        return res;
    }
    public static void main(String[] args) {
        ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();
        // 不需要获取同步的 monitor 和 synchronizer 信息，仅获取线程和线程堆栈信息
        ThreadInfo[] threadInfos = threadMXBean.dumpAllThreads(false, false);
        // 遍历线程信息，仅打印线程 ID 和线程名称信息
        for (ThreadInfo threadInfo : threadInfos) {
            System.out.println("[" + threadInfo.getThreadId() + "] " +
                    threadInfo.getThreadName());}
//        //加法运算
//        int result1 = add(90,323);
//        System.out.println(result1);
//
//        //减法运算
//        int result2 = minus(413,323);
//        System.out.println(result2);
//
//        int result3 = multi(90,2);
//        System.out.println(result3);
//
//        int result4 = sub(90,2);
//        System.out.println(result4);
    }
}
