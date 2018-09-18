import java.util.ArrayList;
import java.util.Scanner;

//一个整数总可以拆分为2的幂的和，例如： 7=1+2+4 7=1+2+2+2 7=1+1+1+4 7=1+1+1+2+2 7=1+1+1+1+1+2 7=1+1+1+1+1+1+1 总共有六种不同的拆分方式。 再比如：4可以拆分成：4 = 4，4 = 1 + 1 + 1 + 1，4 = 2 + 2，4=1+1+2。 用f(n)表示n的不同拆分的种数，例如f(7)=6. 要求编写程序，读入n(不超过1000000)，输出f(n)%1000000000。
public class Main4 {
    public static int a[]=new int[1000001];
    public static void main(String[]args){
        Scanner in =new Scanner(System.in);
        while(in.hasNext()){
            int n=in.nextInt();
            System.out.println(getN(n));
        }
    }
    public static int getN(int n){
        a[1]=1;
        a[2]=2;
        for(int i=3;i<=n;i++){
            if((i%2)==1){
                a[i]=a[i-1]%1000000000;
            }else{
                a[i]=(a[i-1]+a[i/2])%1000000000;
            }
        }
        return a[n];

        /*int result=0;
        ArrayList<Integer> list=new ArrayList<>();
        if(n==1){
            result++;
        }else{
            list.add(n);
        }
        while(list.size()!=0){
            System.out.println(list.size());
            int tem=list.get(list.size()-1);
            list.remove(list.size()-1);
            if((tem%2)==1){
                tem=tem-1;
                if(tem==1){
                    result++;
                }else{
                    list.add(tem);
                }
            }else{
              int  tem1=tem/2;
              int  tem2=tem-1;
              if(tem1==1){
                  result++;
              }else{
                  list.add(tem1);
              }
              if(tem2==1){
                  result++;
              }else{
                  list.add(tem2);
              }

            }

        }

      return result;*/
    }


}
