package hot100;

import java.util.HashMap;

public class C1_两数之和 {
    public static void main(String[] args) {

    }

    public int[] twoSum(int[] nums, int target) {
        // 从数组nums中找出和胃target的数对，返回下标
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i=0;i<nums.length;i++){
            if(map.containsKey(nums[i])){
                return new int[]{map.get(nums[i]),i};
            }
            map.put(target-nums[i],i);
        }
        return null;
    }
}