package 每日一题.Y2024.M12;

import java.util.HashMap;

public class Q2024_12_29_1366 {
    public String rankTeams(String[] votes) {
        // 总共有几个人
        int len = votes[0].length();
        HashMap<Character, int[]> map = new HashMap<>();
        for(String v:votes){
            for(int i=0;i<len;i++){
                int[] sort = map.getOrDefault(v.charAt(i), new int[len]);
                sort[i]++;
                map.put(v.charAt(i), sort);
            }
        }
        StringBuilder sb = new StringBuilder();
        map.keySet().stream().sorted(
                (x,y)->{
                    int[] sx = map.get(x);
                    int[] sy = map.get(y);
                    for(int i=0;i<len;i++){
                        if(sx[i]>sy[i]){
                            return -1;
                        }else if(sx[i]<sy[i]){
                            return 1;
                        }
                    }
                    return x-y;
                }
        ).forEach(sb::append);

        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Q2024_12_29_1366().rankTeams(new String[]{
//                "ABC","ACB","ABC","ACB","ACB"
                "WXYZ","XYZW"
        }));
    }
}
