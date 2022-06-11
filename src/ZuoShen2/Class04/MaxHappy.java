package ZuoShen2.Class04;

import java.util.List;

public class MaxHappy {
    public static class Employee{
        public int happy;
        public List<Employee> nexts;
    }

    public static class Info{
        public int laiMaxHappy;
        public int buMaxHappy;
        public Info(int lai,int bu){
            laiMaxHappy=lai;
            buMaxHappy=bu;
        }
    }
    public static int maxHappy(Employee boss){
        Info headInfo = process(boss);
        return Math.max(headInfo.laiMaxHappy,headInfo.buMaxHappy);
    }

    public static Info process(Employee x){
        //base case
        if(x.nexts.isEmpty()){ //x是最基层员工的时候
            return new Info(x.happy,0);
        }
        int lai = x.happy; //x来的情况下，整棵树的最大收益
        int bu = 0; //x不来的情况下，整棵树的最大收益
        for(Employee next:x.nexts){
            Info nextInfo = process(next);
            //x来了的话，直接下级就来不了  所以加上buMaxHappy
            lai += nextInfo.buMaxHappy;
            //x不来了的话  取下级来和不来的最大快乐值
            bu += Math.max(nextInfo.laiMaxHappy,nextInfo.buMaxHappy);
        }
        return new Info(lai,bu  );
    }

}
