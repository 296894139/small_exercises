/**
 * @创建人 徐介晖
 * @创建时间 2018/9/23
 * @描述   Given n, how many structurally unique BST's (binary search trees) that store values 1 ... n?
 */
public class leetcode96 {

    public int numTrees(int n) {
         int a[]=new int[n+1];
         a[1]=1;
         a[0]=1;
         for(int i=2;i<=n;i++){
             int all=0;
             for(int j=0;j<i;j++){
                 all+=a[j]*a[i-j-1];
             }
             a[i]=all;
         }
         return  a[n];
    }

    public static  void main(String[]args){
        leetcode96 s=new leetcode96();
        System.out.println(s.numTrees(3));

    }

}
