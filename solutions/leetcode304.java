/**
 * @创建人 徐介晖
 * @创建时间 2018/10/8
 * @描述   Given a 2D matrix matrix, find the sum of the elements inside the rectangle defined by its upper left corner (row1, col1) and lower right corner (row2, col2).
 */
public class leetcode304 {
    private int[][] T;

    public leetcode304(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) return;
        T = new int[matrix.length + 1][matrix[0].length + 1];
        for (int r = 1; r < T.length; r++)
            for (int c = 1; c < T[0].length; c++)
                T[r][c] = T[r-1][c] + T[r][c-1] + matrix[r-1][c-1] - T[r-1][c-1];
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        row1++; col1++; row2++; col2++;
        // full - top - left + common
        return T[row2][col2] - T[row1-1][col2] - T[row2][col1-1] + T[row1-1][col1-1];
    }
    public static void main(String[]args){
        String a="AdsadfaF";
        System.out.println(a.toLowerCase());
    }
}
