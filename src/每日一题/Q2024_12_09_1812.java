package 每日一题;

/**
 * @author JZAB
 */
public class Q2024_12_09_1812 {
    public boolean squareIsWhite(String coordinates) {
        int i = coordinates.charAt(0)-'a';
        int j = coordinates.charAt(1)-1;
        return i%2!=j%2;
    }
}
