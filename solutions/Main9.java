import java.util.ArrayList;
import java.util.Scanner;
//动态规划  有若干张邮票，要求从中选取最少的邮票张数凑成一个给定的总值。     如，有1分，3分，3分，3分，4分五张邮票，要求凑成10分，则使用3张邮票：3分、3分、4分即可。
public class Main9 {
    static int goal;
    static ArrayList<Integer> list;
    public static void main(String []args){
        Scanner in=new Scanner(System.in);
        while(in.hasNext()){
            list=new ArrayList<>();
            goal=in.nextInt();
            int n=in.nextInt();

            for(int i=1;i<=n;i++){
                list.add(in.nextInt());
            }
            int a[]=new int[101];
            for(int i=1;i<=100;i++){
                a[i]=100000;
            }
            for(int i=0;i<n;i++){
                for(int j=100;j>=list.get(i);j--){
                    a[j]=Math.min(a[j],a[j-list.get(i)]+1);
                }
            }

            if(a[goal]<100000){
                System.out.println(a[goal]);
            }else{
                System.out.println(0);
            }

        }
    }
}
