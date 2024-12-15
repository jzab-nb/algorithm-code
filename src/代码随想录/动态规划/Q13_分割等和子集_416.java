package 代码随想录.动态规划;

public class Q13_分割等和子集_416 {
    public static void main(String[] args) {

    }

    public boolean canPartition(int[] nums) {
        int sum=0;
        // 统计元素和
        for (int n : nums) sum+=n;
        // 元素和不是偶数，注定无法平分
        if(sum%2!=0) return false;
        // 要求的目标和时
//        int target =
//        int[][] dp = new int[nums.length][target];
        return false;
    }
}
