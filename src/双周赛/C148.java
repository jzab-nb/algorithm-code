package 双周赛;

public class C148 {
    static class Solution1 {
        public int maxAdjacentDistance(int[] nums) {
            int n = nums.length;
            int max=abs(nums[0]-nums[n-1]);
            for(int i=0;i<n-1;i++){
                max = Math.max(max,abs(nums[i]-nums[i+1]));
            }
            return max;
        }

        public int abs(int n){
            return n>0?n:-n;
        }
    }
}
