import java.util.ArrayList;
import java.util.Scanner;

public class Main_0{
    static int m;
    static int n;
    public static void main(String []args){
       Scanner in=new Scanner(System.in);
        n=in.nextInt();
        m=in.nextInt();
        int total=(int)Math.pow(m,n);
        ArrayList<Integer> list=getPrimes(m,new ArrayList<>());
       /*for(int i:list){
            System.out.println(i);

        }*/



    }
    public int Kprime(int a,int b,int c,ArrayList<Integer> list){
          int result=0;
          if(b==c){
              int t=m;


          }

     return result;

    }
    public static  ArrayList<Integer> getPrimes(int k,ArrayList<Integer> list){
        if(isPrime(k)){
            if(!list.contains(k)){
                list.add(k);
            }


            return list;

        }
        ArrayList<Integer> result=new ArrayList<>();
        int yueshu=2;
        while(true){

            if(((k%yueshu)==0)&&(isPrime(yueshu))){
                if(!list.contains(k)){
                    list.add(yueshu );
                }

                result=getPrimes(k/yueshu,list);
                break;
            }
            yueshu++;
        }
        return result;
    }
    public static boolean isPrime(int k){
        if(k==2){
            return true;
        }
        boolean result=true;
        for(int i=2;i<=k/2;i++){
            if((k%2)==0){
                return false;
            }
        }
        return result;
    }





}
