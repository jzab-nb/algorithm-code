package 每日一题;

import java.util.*;

public class Q2024_12_15_1338 {

    public static void main(String[] args) {
        System.out.println(new Q2024_12_15_1338().minSetSize(new int[]{3, 3, 3, 3, 5, 5, 5, 2, 2, 7}));
    }

    public int minSetSize(int[] arr) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int i:arr){
            map.put(i,map.getOrDefault(i,0)+1);
        }
        List<int[]> list = new ArrayList<>();
        for(int i:map.keySet()) list.add(new int[]{i,map.get(i)});
        list.sort(Comparator.comparingInt(x -> -x[1]));
        int len = arr.length;
//        list.forEach(x->{
//            System.out.println(Arrays.toString(x));
//        });
        int sum=0;
        for(int i=0;i<list.size();i++){
            sum+=list.get(i)[1];
            if(sum>=len/2) return i+1;
        }
        return 0;
    }
}
