/**
 * @创建人 徐介晖
 * @创建时间 2018/10/15
 * @描述  The n-queens puzzle is the problem of placing n queens on an n×n chessboard such that no two queens attack each other
 */
public class leetcode52 {
    public static void main(String[]args){
        leetcode52 s=new leetcode52();
        System.out.println(s.totalNQueens(4));
    }

    public int totalNQueens(int n) {
        int []location=new int[n];
        return   place(location,0);
    }
    public static boolean isok(int []location,int index,int x){
        for(int i=0;i<index;i++){
            if(location[i]==x){
                return false;
            }
            if((Math.abs(index-i))==(Math.abs(location[i]-x))){
                return false;
            }
        }
        return true;


    }
    public static int place(int[] location,int index){
        if(index==location.length){
            //完成一种排序
            return 1;
        }else{
            int sum=0;
            int n=location.length;
            for(int i=0;i<n;i++){
                //从第1行到第n行
                if(isok(location,index,i)){
                    int tem[]=new int[n];
                    for(int u=0;u<index;u++){
                        tem[u]=location[u];
                    }
                    tem[index]=i;
                    sum+=place(tem,index+1);

                }
            }
            return sum;

        }
    }
}
