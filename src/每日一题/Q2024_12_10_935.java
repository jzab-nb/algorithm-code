package 每日一题;

/**
 * @author JZAB
 */
public class Q2024_12_10_935 {
    static int[][][]  mem = new int[4][3][5001];

    public static void main(String[] args) {
        System.out.println(new Q2024_12_10_935( ).knightDialer(1));
        System.out.println(new Q2024_12_10_935( ).knightDialer(2));
        System.out.println(new Q2024_12_10_935( ).knightDialer(3131));
    }

    // 八种情况
    public int[][] DIRS = new int[][]{
            {1, 2}, {-1, -2},
            {2, 1}, {-2, -1},
            {1, -2}, {-1, 2},
            {2, -1}, {-2, 1}
    };

    public int knightDialer(int n) {
        int sum=0;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 3; j++) {
                sum=(sum+dfs(n,i,j))%1000000007;
            }
        }
        return sum%1000000007;
    }

    public boolean isValid(int i, int j) {
        return i >= 0 && j >= 0 && i < 4 && j < 3 && !(i == 3 && j == 0) && !(i == 3 && j == 2);
    }

    public int dfs(int k, int i, int j) {
        if (!isValid(i, j)) return 0;
        if (k == 1) return 1;
        if(mem[i][j][k]!=0) return mem[i][j][k];
        int sum=0;
        for (int[] d : DIRS) {
            sum=(sum+dfs(k-1, i + d[0], j + d[1]))%1000000007;
        }
        mem[i][j][k]=sum%1000000007;
        return mem[i][j][k];
    }
}