/**
 * @创建人 徐介晖
 * @创建时间 2018/9/23
 * @描述   Given an array nums of n integers where n > 1,  return an array output such that output[i] is equal to the product of all the elements of nums except nums[i].
 */
public class leetcode238 {
    public int[] productExceptSelf(int[] nums) {
        int n=nums.length;
        int product=1;
        int result[]=new int[n];
        for(int i=0;i<n;i++){
           result[i]=product;
           product*=nums[i];
        }
        product=1;
        for(int i=n-1;i>=0;i--){
            result[i]*=product;
            product*=nums[i];
        }
        return result;
    }
}
