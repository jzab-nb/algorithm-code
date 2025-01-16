package 每日一题.Y2025.M01;

public class Q2025_01_16_3095 {
    public int minimumSubarrayLength(int[] nums, int k) {
        int min = Integer.MAX_VALUE;
        // 子数组中所有的位进行按位或运算, 如果结果大于等于k,则记录长度,返回长度的最小值
        for(int start=0;start<nums.length;start++){
            for(int end=start;end<nums.length;end++){
                int sum=0;
                for(int i=start;i<=end;i++){
                    sum|=nums[i];
                }
                if(sum>=k) min = Math.min(min, end-start+1);
            }
        }
        if(min==Integer.MAX_VALUE) min = -1;
        return min;
    }
}