import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @创建人 徐介晖
 * @创建时间 2018/10/2
 * @描述   “臭味相投”——这是我们描述朋友时喜欢用的词汇。两个人是朋友通常意味着他们存在着许多共同的兴趣。然而作为一个宅男，你发现自己与他人相互了解的机会并不太多。幸运的是，你意外得到了一份北大图书馆的图书借阅记录，于是你挑灯熬夜地编程，想从中发现潜在的朋友。     首先你对借阅记录进行了一番整理，把N个读者依次编号为1,2,…,N，把M本书依次编号为1,2,…,M。同时，按照“臭味相投”的原则，和你喜欢读同一本书的人，就是你的潜在朋友。你现在的任务是从这份借阅记录中计算出每个人有几个潜在朋友。
 */
public class Main10 {
    public static void main(String[]args){
        Scanner in=new Scanner(System.in);
        int n=in.nextInt();
        int m=in.nextInt();
        Map<Integer,Integer> map=new HashMap<>();
        int a[]=new int[n];
        for(int i=0;i<n;i++){
            a[i]=in.nextInt();
            map.put(a[i],map.getOrDefault(a[i],0)+1);
        }
        for(int i=0;i<n;i++){
            int num=map.get(a[i]);
            if(num==1){
                System.out.println("BeiJu");
            }else{
                System.out.println(num-1);
            }
        }


    }
}
