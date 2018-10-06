import java.util.ArrayList;
import java.util.Scanner;

/**
 * @创建人 徐介晖
 * @创建时间 2018/10/6
 * @描述   北大信息学院的同学小明毕业之后打算创业开餐馆.现在共有n 个地点可供选择。小明打算从中选择合适的位置开设一些餐馆。这 n 个地点排列在同一条直线上。我们用一个整数序列m1, m2, ... mn 来表示他们的相对位置。由于地段关系,开餐馆的利润会有所不同。我们用pi 表示在mi 处开餐馆的利润。为了避免自己的餐馆的内部竞争,餐馆之间的距离必须大于k。请你帮助小明选择一个总利润最大的方案。
 */
public class Main15 {
    public static void main(String[]args){
        Scanner in=new Scanner(System.in);
        int t=in.nextInt();
        for(int i=0;i<t;i++){
            int n=in.nextInt();
            int k=in.nextInt();
            int m[]=new int[n];
            int p[]=new int[n];
            for(int u=0;u<n;u++){
                m[u]=in.nextInt();
              //  System.out.println(m[u]+" "+u+" m");
            }
            for(int u=0;u<n;u++){
                p[u]=in.nextInt();
               // System.out.println(p[u]+" "+u+" p");
            }

             int max[]=new int[n];
            max[0]=p[0];
            for(int u=1;u<n;u++){
                max[u]=p[u];
                for(int y=0;y<u;y++){
                    if((Math.abs(m[y]-m[u]))>k){
                       // System.out.println(max[u]+"  "+max[y]+p[u]);
                        max[u]=Math.max(max[u],max[y]+p[u]);
                    }
                }
            }
            int l=0;
            for(int u=0;u<n;u++){
                if(max[u]>l){
                    l=max[u];
                }
            }
            System.out.println(l);

        }


    }
}
