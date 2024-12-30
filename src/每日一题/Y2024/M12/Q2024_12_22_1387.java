package 每日一题.Y2024.M12;

import java.util.*;

public class Q2024_12_22_1387 {
    public static void main(String[] args) {
        System.out.println(new Q2024_12_22_1387().getKth(12, 15, 2));
        System.out.println(new Q2024_12_22_1387().getKth(7, 11, 4));
    }

    static Map<Integer,Integer> map = new HashMap<>();

    public int dfs(int i){
        if(i==1) return 0;
//        System.out.println(i);
        if(map.containsKey(i)) return map.get(i);
        int v = dfs(i%2==0?i/2:i*3+1)+1;
        map.put(i,v);
        return v;
    }

    public int getKth(int lo, int hi, int k) {
        List<Integer> list = new ArrayList<>();
        while(lo<=hi) list.add(lo++);
        list.sort((x,y)->{
            int wx = dfs(x);
            int wy = dfs(y);
            System.out.printf("x:%d %d y:%d %d\n",x,wx,y,wy);
            if(wx==wy){
                return Integer.compare(x,y);
            }
            return Integer.compare(wx,wy);
        });
        System.out.println(list);
        return list.get(k-1);
    }
}
