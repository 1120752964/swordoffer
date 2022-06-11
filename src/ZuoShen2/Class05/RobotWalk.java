package ZuoShen2.Class05;

public class RobotWalk {
    public static int ways1(int N, int M, int K, int P) {
        // 参数无效直接返回0
        if (N < 2 || K < 1 || M < 1 || M > N || P < 1 || P > N) {
            return 0;
        }
        // 总共N个位置，从M点出发，还剩K步，返回最终能达到P的方法数
        return walk(N, M, K, P);
    }

    // N : 位置为1 ~ N，固定参数
    // cur : 当前在cur位置，可变参数
    // rest : 还剩res步没有走，可变参数
    // P : 最终目标位置是P，固定参数
    // 该函数的含义：只能在1~N这些位置上移动，当前在cur位置，走完rest步之后，停在P位置的方法数作为返回值返回
    public static int walk(int N, int cur, int rest, int P) {
        // 如果没有剩余步数了，当前的cur位置就是最后的位置
        // 如果最后的位置停在P上，那么之前做的移动是有效的
        // 如果最后的位置没在P上，那么之前做的移动是无效的
        if (rest == 0) {
            return cur == P ? 1 : 0;//有效就返回1 代表方法数+1 无效返回0
        }
        // 如果还有rest步要走，而当前的cur位置在1位置上，那么当前这步只能从1走向2
        // 后续的过程就是，来到2位置上，还剩rest-1步要走
        if (cur == 1) {
            return walk(N, 2, rest - 1, P);
        }
        // 如果还有rest步要走，而当前的cur位置在N位置上，那么当前这步只能从N走向N-1
        // 后续的过程就是，来到N-1位置上，还剩rest-1步要走
        if (cur == N) {
            return walk(N, N - 1, rest - 1, P);
        }
        // 如果还有rest步要走，而当前的cur位置在中间位置上，那么当前这步可以走向左，也可以走向右
        // 走向左之后，后续的过程就是，来到cur-1位置上，还剩rest-1步要走
        // 走向右之后，后续的过程就是，来到cur+1位置上，还剩rest-1步要走
        // 走向左、走向右是截然不同的方法，所以总方法数要都算上
        return walk(N, cur + 1, rest - 1, P) + walk(N, cur - 1, rest - 1, P);
    }

    public static int walks2(int N, int M, int K, int P){
        //即 可变参数的最大变化范围
        //剩余步数+1 最多这么个大小的一维  里面每一步的可能位置是N+1
        int[][] dp = new int[K + 1][N + 1];
        for (int i = 0; i <= K; i++) {
            for (int j = 0; j <= N; j++) {
                dp[i][j] = -1;//将默认值改为-1  因为初始值为0可能会混淆返回值的记录 0
            }
        }
        return ways2(N, M, K, P,dp);
    }


    //N 总节点  M当前位置  K剩余步数  P目标位置
    //记忆化搜索
    public static int ways2(int N, int cur, int rest, int P, int[][] dp) {
        if(dp[rest][cur]!=-1){
            return dp[rest][cur];//当前位置算过，直接返回结果
        }
        //缓存没命中
        if(rest ==0){
            dp[rest][cur] = cur ==P?1:0;
            return dp[rest][cur];
        }
        // rest>0 有路可走
        if (cur == 1) {
            dp[rest][cur] = ways2(N, 2, rest - 1, P,dp );
        }else if(cur == N) {
            dp[rest][cur] = ways2(N, N - 1, rest - 1, P,dp);
        }else {
            dp[rest][cur] = ways2(N, cur + 1, rest - 1, P,dp) + ways2(N, cur - 1, rest - 1, P,dp);;
        }
        return dp[rest][cur];
    }

    //严格表结构  有数据间的依赖关系
    public static int ways3(int N, int M, int K, int P) {
        // 参数无效直接返回0
        if (N < 2 || K < 1 || M < 1 || M > N || P < 1 || P > N) {
            return 0;
        }
        int[] dp = new int[N + 1];
        dp[P] = 1;
        for (int i = 1; i <= K; i++) {
            int leftUp = dp[1];// 左上角的值
            for (int j = 1; j <= N; j++) {
                int tmp = dp[j];
                if (j == 1) {
                    dp[j] = dp[j + 1];
                } else if (j == N) {
                    dp[j] = leftUp;
                } else {
                    dp[j] = leftUp + dp[j + 1];
                }
                leftUp = tmp;
            }
        }
        return dp[M];
    }

    public static void main(String[] args) {
        System.out.println(ways1(7, 4, 9, 5));
        System.out.println(walks2(7, 4, 9, 5));
        System.out.println(ways3(7, 4, 9, 5));
    }
}
