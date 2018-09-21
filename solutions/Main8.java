import java.util.Scanner;

public class Main8{
    public static void main(String []args){
        Scanner in=new Scanner(System.in);
        while(in.hasNext()){
            int n=in.nextInt();
            if(n==0){

            }else{
                int min=in.nextInt();
                int max=min;
                for(int i=1;i<n;i++){
                    int tem=in.nextInt();
                    if(tem>max){
                        max=tem;
                    }else if(tem<min){
                        min=tem;
                    }
                }
                System.out.println(max+" "+min);

            }
        }
    }
}