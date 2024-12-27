package 每日一题;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q2024_12_27_3159 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Q2024_12_27_3159().occurrencesOfElement(new int[]{1, 3, 1, 7}, new int[]{1, 3, 2, 4}, 1)));
    }

    public int[] occurrencesOfElement(int[] nums, int[] queries, int x) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) if (nums[i] == x) list.add(i);
        int[] res = new int[queries.length];
        for(int i=0;i<queries.length;i++){
            int q = queries[i];
            if(q>list.size()){
                res[i] = -1;
            }else{
                res[i] = list.get(q-1);
            }
        }
        return res;
    }
}
