package 每日一题.Y2025.M09;

import java.util.Arrays;

public class Q2025_09_19_3484 {

}

class Spreadsheet {

    int[][] ds;

    public static void main(String[] args) {
        Spreadsheet spreadsheet = new Spreadsheet(3);

        System.out.println(Arrays.toString(spreadsheet.parseCell("A100")));
    }

    private int[] parseCell(String cell){
        char x = cell.charAt(0);
        String y = cell.substring(1);
        return new int[]{x-'A',Integer.parseInt(y)};
    }

    public Spreadsheet(int rows) {
        // 定义一个rows行的表格
        ds = new int[26][rows];
    }

    public void setCell(String cell, int value) {
        // 设置某个单元格的值
        int[] idx = parseCell(cell);
        ds[idx[0]][idx[1]] = value;
    }

    public void resetCell(String cell) {
        // 将某个单元格的值设置成0
        setCell(cell, 0);
    }

    public int getValue(String formula) {
        // 计算某个公式=X+Y
        String[] adds = formula.substring(1).split("\\+");
        return getCellValue(adds[0])+getCellValue(adds[1]);
    }

    public int getCellValue(String formula) {
        if(formula.charAt(0)>='A' && formula.charAt(0)<='Z'){
            int[] idx = parseCell(formula);
            return ds[idx[0]][idx[1]];
        }else{
            return Integer.parseInt(formula);
        }
    }
}