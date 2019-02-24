import java.util.Arrays;

/**
 * @创建人 徐介晖
 * @创建时间 2018/12/5
 * @描述   Given an array of integers nums and a positive integer k, find whether it's possible to divide this array into k non-empty subsets whose sums are all equal.
 * Input: nums = [4, 3, 2, 3, 5, 2, 1], k = 4
Output: True
Explanation: It's possible to divide it into 4 subsets (5), (1, 4), (2,3), (2,3) with equal sums.
 */
public class leetcode698 {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = 0;
        for(int num : nums) {
            sum += num;
        }

        if(k <= 0 || sum % k != 0) {
            return false;
        }
        boolean[] visited = new boolean[nums.length];
        //it is important since we need to use up the larger number first.
        Arrays.sort(nums);
        int value = k;
        while(value > 0 && dfs(nums, visited, 0, nums.length - 1, sum / k)) {
            --value;
        }

        return value == 0;
    }

    private boolean dfs(int[] nums, boolean[] visited, int sum,
                        int st, int target) {
        if(sum == target) {
            return true;
        }
        if(sum > target) {
            return false;
        }

        for(int i = st; i >= 0; --i) {
            if(!visited[i]) {
                visited[i] = true;
                if(dfs(nums, visited, sum + nums[i], i - 1, target)) {
                    return true;
                }

                visited[i] = false;
            }
        }

        return false;
    }
}
