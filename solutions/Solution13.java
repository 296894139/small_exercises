import java.util.ArrayList;
import java.util.Scanner;

/**
 * @创建人 徐介晖
 * @创建时间 2018/9/30
 * @描述  在某条线路上有N个火车站，有三种距离的路程，L1，L2，L3,对应的价格为C1,C2,C3.其对应关系如下: 距离s           票价 0<S<=L1         C1 L1<S<=L2        C2 L2<S<=L3        C3 输入保证0<L1<L2<L3<10^9,0<C1<C2<C3<10^9。 每两个站之间的距离不超过L3。 当乘客要移动的两个站的距离大于L3的时候，可以选择从中间一个站下车，然后买票再上车，所以乘客整个过程中至少会买两张票。 现在给你一个 L1，L2，L3，C1，C2,C3。然后是A B的值，其分别为乘客旅程的起始站和终点站。 然后输入N，N为该线路上的总的火车站数目，然后输入N-1个整数，分别代表从该线路上的第一个站，到第2个站，第3个站，……，第N个站的距离。 根据输入，输出乘客从A到B站的最小花费。
 */


public class Solution13{

    static int[] L = new int[3];
    static int[] C = new int[3];
    static int A, B, N;
    static int[] distance;      //distance[i] 表示 第1站 到 第i + 1站 的距离
    static int[] dp;            //dp[i] 表示 第一站 到 第i + 1站 的最小花费

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            for (int i = 0; i < L.length; ++i) {
                L[i] = sc.nextInt();
            }
            for (int i = 0; i < C.length; ++i) {
                C[i] = sc.nextInt();
            }
            A = sc.nextInt();
            B = sc.nextInt();
            N = sc.nextInt();
            distance = new int[N];
            for (int i = 1; i < distance.length; ++i) {
                distance[i] = sc.nextInt();
            }
            int res = getMinCost();
            System.out.println(res);
        }
        sc.close();
    }

    //用动态规划的方法求出dp的值
    private static int getMinCost() {
        dp = new int[distance.length];
        dp[1] = getPrice(distance[1]);  //第2站的最小花费就是 第1站 到 第2站 的花费.
        for (int i = 2; i < distance.length; ++i) {
            int interval = distance[i] - distance[i - 1];   //第i站 与 前一站 的间隔
            //第i站 的初始赋值,就是前一站的花费 + 前一站 到第 i 站的花费
            dp[i] = dp[i - 1] + getPrice(interval);
            for (int j = i - 2; j >= 0; --j) {       //试探是否可以通过前几站 直接坐到 第i站(中途不下车)
                interval = distance[i] - distance[j];//第j站 到 第i站的间隔
                if (interval > L[2]) {       //如果间隔大于L3的话,j前面的站就不能直达第i站了,跳出
                    break;
                }
                dp[i] = Math.min(dp[i], dp[j] + getPrice(interval));
            }
        }
        return dp[B - 1] - dp[A - 1];
    }

    //根据一段距离计算出花费
    private static int getPrice(int dis) {
        for (int i = 0; i < L.length; ++i) {
            if (dis <= L[i]) {
                return C[i];
            }
        }
        return 0;
    }

}
