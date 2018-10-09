import java.util.ArrayList;
import java.util.Scanner;

/**
 * @创建人 徐介晖
 * @创建时间 2018/10/9
 * @描述   小明是北京大学信息科学技术学院三年级本科生。他喜欢参加各式各样的校园社团。这个学期就要结束了，每个课程大作业的截止时间也快到了，可是小明还没有开始做。每一门课程都有一个课程大作业，每个课程大作业都有截止时间。如果提交时间超过截止时间X天，那么他将会被扣掉X分。对于每个大作业，小明要花费一天或者若干天来完成。他不能同时做多个大作业，只有他完成了当前的项目，才可以开始一个新的项目。小明希望你可以帮助他规划出一个最好的办法(完成大作业的顺序)来减少扣分
 */
public class Main20 {
    static int minLose=1000;
    public static void main(String[]args){
        Scanner in=new Scanner(System.in);
        int t=in.nextInt();
        for(int i=0;i<t;i++){
            minLose=1000;
            int n=in.nextInt();
            String s[]=new String[n];
            int deadline[]=new int[n];
            int needTime[]=new int[n];
            for(int u=0;u<n;u++){
                s[u]=in.next();
                deadline[u]=in.nextInt();
                needTime[u]=in.nextInt();
            }
            int []has=new int[n];
            ArrayList<Integer> list=new ArrayList<>();
            for(int u=0;u<n;u++){
                has[u]=0;

            }
            test(deadline,needTime,has,0,0,list);
            System.out.println(minLose);
        }
    }
    public  static void test(int deadline[],int time[],int has[],int tem_lose,int now,ArrayList<Integer> list){

        if(tem_lose>minLose){
            return;
        }else{
            boolean b=true;
            for(int i=0;i<has.length;i++){
                if(has[i]==0){
                   // System.out.println(tem_lose);
                     b=false;
                    int tem[]=new int[has.length];
                    ArrayList<Integer> tem_list=new ArrayList<>();
                    for(int  u=0;u<has.length;u++){
                        tem[u]=has[u];

                    }
                    for(int u=0;u<list.size();u++){
                        tem_list.add(list.get(u));
                    }
                    tem_list.add(i);
                    tem[i]=1;

                    int tem_dead=deadline[i];
                    int tem_time=time[i];
                    if(now>=tem_dead){
                        tem_lose+=tem_time;
                    }else if((now+tem_time)>tem_dead){
                        tem_lose+=now+tem_time-tem_dead;
                    }
                    int plus=tem_lose;
                    for(int u=0;u<has.length;u++){
                        if(has[u]==0){
                            if(now>=deadline[u]){
                                if(tem_time>=time[u]){
                                   // System.out.println(tem_lose+time[u]);
                                    plus+=+time[u];
                                  //  test(deadline, time, tem, tem_lose+time[u], now+time[u]);


                                }else{
                                 //   System.out.println(tem_lose+tem_time);
                                    plus+=tem_time;
                                  //  test(deadline, time, tem, tem_lose+tem_time, now+time[u]);

                                }
                            }else{
                                if((now+tem_time)>deadline[u]){
                                    plus+=now+tem_time-deadline[u];
                                  //  System.out.println(tem_lose+now+tem_time-deadline[u]);
                                   // test(deadline, time, tem, tem_lose+now+tem_time-deadline[u], now+time[u]);

                                }else{

                                  //  System.out.println(tem_lose);
                                   // test(deadline, time, tem, tem_lose, now+time[u]);

                                }
                            }


                        }
                    }

                    test(deadline, time, tem, plus, now+tem_time,tem_list);
                }
            }
            if(b){
                if(tem_lose<minLose){
                    minLose=tem_lose;
                    System.out.println(list);
                }
            }

        }
    }
}
