package 每日一题.Y2025.M01;

import java.util.Arrays;

public class Q2025_01_14_3065 {
    public int minOperations(int[] nums, int k) {
        // 1.排序
        Arrays.sort(nums);
        // 2.反向查找k最后一次出现的位置
        int i=nums.length-1;
        while(i>=0 && nums[i]>=k) i--;
        return i+1;
    }

    public static void main(String[] args) {
        System.out.println(new Q2025_01_14_3065().minOperations(new int[]{2, 11, 10, 1, 3}, 10));
    }
}
