import java.util.*;

/**
 * @创建人 徐介晖
 * @创建时间 2018/10/2
 * @描述  给出n个正整数，任取两个数分别作为分子和分母组成最简真分数，编程求共有几个这样的组合。
 */
public class Main11 {
    public static void main(String[]args){
        Scanner in=new Scanner(System.in);
        int n=in.nextInt();
        ArrayList<Integer> list=new ArrayList<>();
        for(int i=0;i<n;i++){
            list.add(in.nextInt());
        }
        Collections.sort(list);


        int sum=0;
        for(int i=0;i<n-1;i++){
            for(int u=i+1;u<n;u++){
                int fenzi=list.get(i);
                int fenmu=list.get(u);
                int tem=gcd(fenzi,fenmu);
               if(tem==1){
                   sum++;
               }

            }
        }
        System.out.println(sum);
    }
    public static int gcd(int p,int q){
        return q == 0 ? p : gcd(q, p % q);
    }
}
