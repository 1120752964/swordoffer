package ZuoShen2.ZhongClass01;

public class AppleMinBags {

    //普通思路  时间复杂度O(1)
    public static int minBags(int apple) {
        if (apple < 0) {
            return -1;
        }
        int bag6 = -1;//-1代表无效 还没有使用
        int bag8 = apple / 8;
        int rest = apple - 8 * bag8;
        while (bag8 >= 0 && rest < 24) {
            int restUse6 = minBagBase6(rest);
            if (restUse6 != -1) {
                bag6 = restUse6;
                break;
            }
            rest = apple - 8 * (--bag8);
        }
        return bag6 == -1 ? -1 : bag6 + bag8;
    }
    //需要几个6类型的袋子 -1表示搞定不了
    public static int minBagBase6(int rest) {
        return rest % 6 == 0 ? (rest / 6) : -1;
    }

    public static int minBagAwesome(int apple) {
        if ((apple & 1) != 0) {
            return -1;
        }
        if (apple < 18) {
            return apple == 0 ? 0 : (apple == 6 || apple == 8) ? 1
                    : (apple == 12 || apple == 14 || apple == 16) ? 2 : -1;
        }
        return (apple - 18) / 8 + 3;
    }

    public static void main(String[] args) {
        int max = Integer.MAX_VALUE;
        int testTime = 100000000;
        for (int test = 0; test < testTime; test++) {
            int apple = (int) (Math.random() * max);
            if (minBags(apple) != minBagAwesome(apple)) {
                System.out.println("error");
            }
        }

    }
}
