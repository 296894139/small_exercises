import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

/**
 * @创建人 徐介晖
 * @创建时间 2018/10/8
 * @描述  大学生电影节在北大举办! 这天，在北大各地放了多部电影，给定每部电影的放映时间区间，区间重叠的电影不可能同时看（端点可以重合），问李雷最多可以看多少部电影。

输入
多组数据。每组数据开头是n(n<=100)，表示共n场电影。
接下来n行，每行两个整数(0到1000之间)，表示一场电影的放映区间
n=0则数据结束
输出
对每组数据输出最多能看几部电影
 */
public class Main18 {
     static int max=0;
    static void test(ArrayList<film> list,int i,int tem_num,ArrayList<Integer> list2){
        if(i>=list.size()){
            if(tem_num>max){
                max=tem_num;
            }
        }else if(list2.size()!=0){
         //   System.out.println(list2.size()+"  size "+i);
            film tem=list.get(list2.get(list2.size()-1));
            film now=list.get(i);
            test(list,i+1,tem_num,list2);
            if(tem.end<=now.begin){
                ArrayList<Integer> list3=new ArrayList<>();
                for(int u=0;u<list2.size();u++){
                    list3.add(list2.get(u));
                }
                list3.add(i);
                test(list,i+1,tem_num+1,list3);
            }
        }else{
            test(list,i+1,tem_num,list2);
            ArrayList<Integer> list3=new ArrayList<>();
            list3.add(0);
            test(list,i+1,tem_num+1,list3);
        }
    }
    public static void main(String[]args){
        Scanner in=new Scanner(System.in);
        int n=in.nextInt();
        ArrayList<film> list=new ArrayList<>();
        for(int i=0;i<n;i++){
            film tem=new film();
            tem.begin=in.nextInt();
            tem.end=in.nextInt();
            list.add(tem);
        }
        Collections.sort(list, new Comparator<film>() {
            @Override
            public int compare(film o1, film o2) {
                return o1.begin-o2.begin;
            }
        });
           ArrayList<Integer> tem=new ArrayList<>();
          test(list,0,0,tem);
          System.out.println(max);



    }
}
