import java.util.ArrayList;
import java.util.Scanner;

/**
 * @创建人 徐介晖
 * @创建时间 2018/9/28
 * @描述
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
