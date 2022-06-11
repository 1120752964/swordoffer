package ZuoShen2.ZhongClass01;

public class Eat {
    //n份青草放在一堆
    //先手后手都绝顶聪明
    // string "先手""后手"
    public static String winner1(int n){
        // 0  1 2  3  4
        // 后 先 后 先 先
        if(n<5){
            return (n==0||n==2)?"先手":"后手";
        }
        //n>=5时
        int base = 1; //先手决定吃的草
        //有问题
        while (base<=n){
            // 当前一共n份艹，先手吃掉的base份，n-base是留给后手的艹
            // 母过程 先手 在子过程里是后手
            if(winner1(n-base).equals("后手")){
                return "先手";
            }
            if(base>n/4){ //防止*4后溢出 如果base*4后大于n 那么一定不可能赢 因此直接break
                break;
            }
            base*=4;
        }
        return "后手";
    }
    //对数器思路
    public static void printWinner(int n) {
        if (n % 5 == 0 || n % 5 == 2) {
            System.out.println("yang");
        } else {
            System.out.println("niu");
        }
    }
}
