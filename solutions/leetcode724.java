/**
 * @创建人 徐介晖
 * @创建时间 2018/9/26
 * @描述   Given an array of integers nums, write a method that returns the "pivot" index of this array.

We define the pivot index as the index where the sum of the numbers to the left of the index is equal to the sum of the numbers to the right of the index.

If no such index exists, we should return -1. If there are multiple pivot indexes, you should return the left-most pivot index.
 */
public class leetcode724 {
    public int pivotIndex(int[] nums) {
             int sum=0;
             for(int i=0;i<nums.length;i++){
                 sum+=nums[i];
             }
             int tem_sum=0;
             for(int i=0;i<nums.length;i++){
                 if((sum-nums[i])%2==0){
                     if(tem_sum==((sum-nums[i])/2)){
                         return i;
                     }

                 }
                 tem_sum+=nums[i];
             }
             return -1;
    }
}
