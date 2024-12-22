package 周赛;

import java.util.HashSet;

public class C429 {
    public static void main(String[] args) {
        System.out.println(new Solution1().minimumOperations(new int[]{1, 2, 3, 4, 2, 3, 3, 5, 7}));
        System.out.println(new Solution1().minimumOperations(new int[]{4,5,6,4,4}));
    }

    static class Solution1 {
        public int minimumOperations(int[] nums) {
            // 从后向前遍历
            HashSet<Integer> set = new HashSet<>();
            for(int i=nums.length-1;i>=0;i--){
                if(set.contains(nums[i])){
                    break;
                }
                set.add(nums[i]);
            }
//            System.out.println(set.size());
            int n = nums.length-set.size();
            return n%3==0?n/3:n/3+1;
        }
    }
}

