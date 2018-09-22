import java.util.HashMap;
import java.util.Map;

public class leetcode560 {

    public int subarraySum(int[] nums, int k) {
        int sum = 0, result = 0;
        Map<Integer, Integer> preSum = new HashMap<>();
        preSum.put(0, 1);

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (preSum.containsKey(sum - k)) {
                result += preSum.get(sum - k);
            }
            preSum.put(sum, preSum.getOrDefault(sum, 0) + 1);
        }

        return result;
    }
    public static void main(String []args){
        leetcode560 s=new leetcode560();
        int a[]={1,2,3};
        System.out.println(s.subarraySum(a,3));
    }
}
