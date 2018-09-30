import java.util.ArrayList;
import java.util.Scanner;

/**
 * @创建人 徐介晖
 * @创建时间 2018/9/28
 * @描述  给出一个整数序列S，其中有N个数，定义其中一个非空连续子序列T中所有数的和为T的“序列和”。 对于S的所有非空连续子序列T，求最大的序列和。 变量条件：N为正整数，N≤1000000，结果序列和在范围（-2^63,2^63-1）以内。
*/
public class Solution12 {
    public static void main(String []args){
        Scanner in=new Scanner(System.in);
        while(in.hasNext()){
            int n=in.nextInt();
           /* ArrayList<Integer> list=new ArrayList<>();
            for(int i=0;i<n;i++){
                list.add(in.nextInt());
            }*/
            int result=0;
            int max=0;
            for(int i=0;i<n;i++){
                if(result<0){
                   // result=list.get()
                    result=in.nextInt();
                }else{
                    result=result+in.nextInt();
                }
                if(result>max){
                    max=result;
                }
            }
            System.out.println(max);



        }
    }

}
