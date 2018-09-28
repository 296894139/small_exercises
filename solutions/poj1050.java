import java.util.ArrayList;
import java.util.Scanner;

/**
 * @创建人 徐介晖
 * @创建时间 2018/9/28
 * @描述  Given a two-dimensional array of positive and negative integers, a sub-rectangle is any contiguous sub-array of size 1*1 or greater located within the whole array. The sum of a rectangle is the sum of all the elements in that rectangle. In this problem the sub-rectangle with the largest sum is referred to as the maximal sub-rectangle.
 */
public class poj1050 {
    public static void main(String[]args){
        Scanner in=new Scanner(System.in);

            int n=in.nextInt();
            ArrayList<ArrayList<Integer>> list=new ArrayList<ArrayList<Integer>>();
            for(int i=0;i<n;i++){
                ArrayList<Integer> tem=new ArrayList<Integer>();
                for(int u=0;u<n;u++){
                    tem.add(in.nextInt());
                }
                list.add(tem);
            }
            int result=0;
            for(int i=0;i<n;i++){
                for(int u=i+1;u<n;u++){
                    int sum=0;
                    for(int t=0;t<n;t++){
                        int lie=getsum(i,u,list,t);
                        if(sum>0){
                            sum=sum+lie;
                        }else{
                            sum=lie;
                        }
                        if(sum>result){
                            result=sum;
                        }
                    }

                }
            }

             System.out.println(result);


    }
    public static int getsum(int i,int j,ArrayList<ArrayList<Integer>> list,int t){
        int sum=0;
        for(int y=i;y<=j;y++){
            sum=sum+list.get(y).get(t);
        }
        return sum;
    }
}
