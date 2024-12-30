package 每日一题.Y2024.M12;

public class Q2024_12_28_3046 {
    public static void main(String[] args) {

    }

    public boolean isPossibleToSplit(int[] nums) {
        // 出现次数不能大于2
        int[] mem = new int[101];
        for(int i:nums){
            mem[i]++;
            if(mem[i]>=3) return false;
        }
        return true;
    }
}
