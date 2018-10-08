/**
 * @创建人 徐介晖
 * @创建时间 2018/10/8
 * @描述  Given a binary matrix A, we want to flip the image horizontally, then invert it, and return the resulting image.

To flip an image horizontally means that each row of the image is reversed.  For example, flipping [1, 1, 0] horizontally results in [0, 1, 1].

To invert an image means that each 0 is replaced by 1, and each 1 is replaced by 0. For example, inverting [0, 1, 1] results in [1, 0, 0].
 */
public class leetcode832 {
    public int[][] flipAndInvertImage(int[][] A) {
           int n=A.length;
           if(n==0){
               return A;
           }
           int m=A[0].length;
           int result[][]=new int[n][m];
           for(int i=0;i<n;i++){
               for(int u=0;u<m;u++){
                   int tem=A[i][u];
                   if(tem==1){
                       result[i][m-1-u]=0;
                   }else{
                       result[i][m-1-u]=1;
                   }

               }
           }
           return result;
    }
}
