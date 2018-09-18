import java.util.Scanner;

//求正整数N(N>1)的质因数的个数。 相同的质因数需要重复计算。如120=2*2*2*3*5，共有5个质因数。
public class Main3 {
    public static void main(String []args){
        Scanner in=new Scanner(System.in);
        while(in.hasNext()){
            int m=in.nextInt();
            int result=0;
            for(int i=2;i*i<=m;i++){
                while((m%i)==0){
                    m=m/i;
                    result++;
                }
            }
            if(m!=1){
                result++;
            }
            System.out.println(result);
        }
    }
}
