/*import java.util.Scanner;

public class n_yueshu {
    public static void main(String []args){
        Scanner in=new Scanner(System.in);
        while(in.hasNext()){
            int n=in.nextInt();
            int result[]=new int[n];
            if(n==0){
                return ;
            }


            for(int i=0;i<n;i++){
                int tem=in.nextInt();
                int num=0;
                for(int u=1;u<=tem;u++){
                    if((tem%u)==0){
                        num++;
                    }
                }
               result[i]=num;
            }
            for(int i=0;i<n;i++){
                System.out.println(result[i]);
            }


        }
    }
}*/


import java.util.Scanner;

public class n_yueshu {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext())
        {
            int shuge = sc.nextInt();
            int[] wo = new int[shuge];
            for(int i=0;i<shuge;i++){
                int count = 0;
                int shu = sc.nextInt();

                for(int j=1;j<=Math.sqrt(shu);j++){
                    if(shu%j==0){
                        count++;
                    }
                }
                wo[i] = count;
            }
            for(int i=0;i<wo.length;i++){
                System.out.println(wo[i]*2);
            }
        }
        sc.close();
    }
}

