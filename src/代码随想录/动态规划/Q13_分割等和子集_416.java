package 代码随想录.动态规划;

import java.util.Arrays;

public class Q13_分割等和子集_416 {
    public static void main(String[] args) {
        new Q13_分割等和子集_416().canPartition(new int[]{1,5,11,5});
    }

    public boolean canPartition(int[] nums) {
        int sum=0;
        // 统计元素和
        for (int n : nums) sum+=n;
        // 元素和不是偶数，注定无法平分
        if(sum%2!=0) return false;
        // 要求的目标和时
        int target = sum/2;
        int[][] dp = new int[nums.length][target+1];
        for(int i=1;i<nums.length;i++){
            for(int j=0;j<target;j++){
                dp[i][j] = dp[i-1][j];
                if(j>=nums[i]){
                    dp[i][j] = Math.max(dp[i][j],dp[i-1][j-nums[i]]+nums[i]);
                }
            }
        }
        System.out.println(Arrays.deepToString(dp));
        return false;
    }
}
