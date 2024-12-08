package 周赛;

/**
 * @author JZAB
 */
public class C427 {

}

class Solution1 {
    public int[] constructTransformedArray(int[] nums) {
        int n = nums.length;
        int[] r = new int[n];
        for(int i=0;i<n;i++){
            if(nums[i]<0){
                r[i] = nums[(i+n+nums[i]%n)%n];
            }else{
                r[i] = nums[(i+nums[i]%n)%n];
            }
        }
        return r;
    }
}
//
// 0,1,2 向左移动1格,等于向右移动2格
// 0,1,2,3 向左移动1格,等于向右移动3格

class Solution2 {
    public int maxRectangleArea(int[][] points) {
        return 0;
    }
}

class Solution3 {
    public long maxSubarraySum(int[] nums, int k) {
        int n = nums.length;
        long[] qzh = new long[n+1];
        // 先计算前缀和
        for(int i=1;i<=n;i++) qzh[i]+=qzh[i-1]+nums[i-1];
//        System.out.println("   "+Arrays.toString(nums) );
//        System.out.println(Arrays.toString(qzh) );
        long max=Long.MIN_VALUE;
        // 遍历数组长度从1k,2k,3k
        for(int len=k;len<=n;len+=k){
            for(int i=0;i+len<n+1;i++){
//                System.out.printf("%d %d\n",i,i+len );
                max = Math.max(max,-qzh[i]+qzh[i+len]);
            }
        }
        return max;
    }
}