package 周赛;

public class C433 {
    public int subarraySum(int[] nums) {
        // 子数组的起点为i-nums[i] ,小于0则是0
        // 1. 先求前缀和,然后求子数组内的和
        int sum=nums[0];
        int[] pre = new int[nums.length];
        pre[0] = nums[0];
        for(int i=1;i<nums.length;i++){
            pre[i] = pre[i-1]+nums[i];
            if(i-nums[i]<=0){
                sum+=pre[i];
            }else{
                sum+=pre[i]-pre[i-nums[i]-1];
            }
            // System.out.println(Arrays.toString(pre));
            // System.out.println(sum);
        }
        return sum;
    }
}
