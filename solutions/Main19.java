import java.util.Scanner;

/**
 * @创建人 徐介晖
 * @创建时间 2018/10/9
 * @描述  又到周末了，同学们陆陆续续开开心心的来到机房上机。jbr也不例外，但是他到的有点晚，发现有些机位上已经有同学正在做题，有些机位还空着。细心的jbr发现，一位同学来到机房，坐在机位i上，如果他的左右两边都空着，他将获得能力值a[i]；如果当他坐下时，左边或者右边已经有一个人在上机了，他将获得能力值b[i]；如果当他坐下时，他的左边右边都有人在上机，他将获得能力值c[i]。

同时他发现，已经在上机的同学不会受到刚要坐下的同学的影响，即他们的能力值只会在坐下时产生，以后不会发生变化;第一个机位左边没有机位，最后一个机位右边没有机位，无论何时坐在这两个机位上将无法获得c值。

这时jbr发现有一排机器还空着，一共有N个机位，编号1到N。这时有N位同学们陆陆续续来到机房，一个一个按照顺序坐在这排机位上。聪明的jbr想知道怎么安排座位的顺序，可以使这N位同学获得能力值的和最大呢？
 */
public class Main19 {
    static int max=0;

    public static void main(String []args){

        Scanner in=new Scanner(System.in);
        int n=in.nextInt();
        int a[]=new int[n];
        int b[]=new int[n];
        int c[]=new int[n];
        for(int i=0;i<n;i++){
            a[i]=in.nextInt();
        }
        for(int i=0;i<n;i++){
            b[i]=in.nextInt();
        }
        for(int i=0;i<n;i++){
            c[i]=in.nextInt();
        }
         int has[]=new int[n];
        for(int i=0;i<n;i++){
            has[i]=0;
        }
        int dp[][]=new int[n][4];
        dp[0][0]=a[0];
        dp[0][2]=b[0];
        for(int i=1;i<n;i++){
            dp[i][0] =Math.max(dp[i-1][2], dp[i-1][3]) + a[i];
            dp[i][1] = Math.max(dp[i-1][0], dp[i-1][1]) + b[i];
            dp[i][2] = Math.max(dp[i-1][2], dp[i-1][3]) + b[i];
            dp[i][3] =Math.max(dp[i-1][0], dp[i-1][1]) + c[i];
        }
        System.out.println(Math.max(dp[n-1][0],dp[n-1][1]));
    }
}
