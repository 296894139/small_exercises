/**
 * @创建人 徐介晖
 * @创建时间 2018/10/15
 * @描述 A sequence X_1, X_2, ..., X_n is fibonacci-like if:

n >= 3
X_i + X_{i+1} = X_{i+2} for all i + 2 <= n
Given a strictly increasing array A of positive integers forming a sequence, find the length of the longest fibonacci-like subsequence of A.  If one does not exist, return 0.

(Recall that a subsequence is derived from another sequence A by deleting any number of elements (including none) from A, without changing the order of the remaining elements.  For example, [3, 5, 8] is a subsequence of [3, 4, 5, 6, 7, 8].)
 */
public class leetcode873 {
    public int lenLongestFibSubseq(int[] A) {
          int n=A.length;
          int max=0;
          int dp[][]=new int[n][n];
          for(int i=0;i<n;i++){
              int left=0;
              int right=i-1;
              while(left<right){
                  int sum=A[left]+A[right];
                  if(sum<A[i]){
                      left++;
                  }else if(sum>A[i]){
                      right--;
                  }else{
                      //A[left]+A[right]=A[i]
                      dp[right][i]=dp[left][right]+1;
                      max=Math.max(max,dp[right][i]);
                      right--;
                      left++;
                  }
              }
          }
          return max==0? 0:max+2;
    }
    public static void main(String []args){
        leetcode873 s=new leetcode873();
        int a[]={1,2,3,4,5,6,7,8};
        int result=s.lenLongestFibSubseq(a);
        System.out.println(result);
    }
}
