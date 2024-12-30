package 每日一题.Y2024.M12;

public class Q2024_12_26_3218 {
    public static void main(String[] args) {

    }

    public boolean isSubstringPresent(String s) {
        // 记录两个相邻字符出现的情况
        boolean[][] map = new boolean[26][26];
        for(int i=0;i<s.length()-1;i++){
            int a = s.charAt(i)-'a';
            int b = s.charAt(i+1)-'a';
            map[a][b] = true;
            // 如果反向的存在或者两个字符相等，则返回true
            if(map[b][a] || a==b) return true;
        }
        return false;
    }
}
