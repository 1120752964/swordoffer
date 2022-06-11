package ZuoShen2.Class05;

public class BobDie {
    public static String bob1(int N, int M, int i, int j, int K) {
        long all = (long) Math.pow(4, K);
        long live = process(N, M, i, j, K);
        long gcd = gcd(all, live);
        return String.valueOf((live / gcd) + "/" + (all / gcd));
    }

    // N*M的区域，Bob从(row,col)位置出发，走rest步后，获得生存的方法数
    public static long process(int N, int M, int row, int col, int rest) {
        if (row < 0 || row == N || col < 0 || col == M) { //越界
            return 0;
        }
        if (rest == 0) { //没越界 而且不用走了
            return 1;
        }
        //还没走完 也没越界  往上下左右走都是不同的方法 所以累加  类似于马的八种跳法
         long live = process(N, M, row - 1, col, rest - 1);
        live += process(N, M, row + 1, col, rest - 1);
        live += process(N, M, row, col - 1, rest - 1);
        live += process(N, M, row, col + 1, rest - 1);
        return live;
    }

    public static long gcd(long m, long n) {
        return n == 0 ? m : gcd(n, m % n);
    }

    public static String bob2(int N, int M, int i, int j, int K) {
        int[][][] dp = new int[N + 2][M + 2][K + 1];
        for (int row = 1; row <= N; row++) {
            for (int col = 1; col <= M; col++) {
                dp[row][col][0] = 1;
            }
        }
        for (int rest = 1; rest <= K; rest++) { //层数
            for (int row = 1; row <= N; row++) {
                for (int col = 1; col <= M; col++) {
                    dp[row][col][rest] = dp[row - 1][col][rest - 1];
                    dp[row][col][rest] += dp[row + 1][col][rest - 1];
                    dp[row][col][rest] += dp[row][col - 1][rest - 1];
                    dp[row][col][rest] += dp[row][col + 1][rest - 1];
                }
            }
        }
        long all = (long) Math.pow(4, K);
        long live = dp[i + 1][j + 1][K];
        long gcd = gcd(all, live);
        return String.valueOf((live / gcd) + "/" + (all / gcd));
    }

    public static void main(String[] args) {
        int N = 10;
        int M = 10;
        int i = 3;
        int j = 2;
        int K = 5;
        System.out.println(bob1(N, M, i, j, K));
        System.out.println(bob2(N, M, i, j, K));
    }
}
