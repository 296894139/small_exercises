import java.util.Scanner;

//N<k时，root(N,k) = N，否则，root(N,k) = root(N',k)。N'为N的k进制表示的各位数字之和。输入x,y,k，输出root(x^y,k)的值 (这里^为乘方，不是异或)，2=<k<=16，0<x,y<2000000000，有一半的测试点里 x^y 会溢出int的范围(>=2000000000)
public class Main {
    public static void main(String []args){
        Scanner in=new Scanner(System.in);
        while(in.hasNext()){
            long  x=in.nextInt();
            long y=in.nextInt();
            int k=in.nextInt();

        }

    }
    public int resultMode(long a,long b,int k){
              if(b==1){
                  mod(a,k);
              }else{
                  long tem=resultMode(a,b/2,k)*resultMode(a,b-b/2,k);
                  return mod(tem,k);
              }
    }
    public int mod(long a,int k){
        int result=0;
        return result;
    }
}
