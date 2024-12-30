package 每日一题.Y2024.M12;

/**
 * @author JZAB
 */
public class Q2024_12_11_2717 {
    public int semiOrderedPermutation(int[] nums) {
        int n = nums.length;
        int l=0,r=0;
        for(int i=0;i<n;i++){
            if(nums[i]==1) l = i;
            if(nums[i]==n) r = i;
        }
        return l+(n-r-1)-(l>r?1:0);
    }
}
