import java.util.ArrayList;

/**
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字，
 * 例如，如果输入如下矩阵：
 * 1  2  3  4
 * 5  6  7  8
 * 9  10 11 12
 * 13 14 15 16
 * 则依次打印出数字1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.
 */
public class Offer20 {
    public static void main(String[] args) {
//        int[][] matrix = {{1, 2, 3, 4},
////                {5,6,7,8},
////                {9,10,11,12},
////                {13,14,15,16}
//    };
        int[][] matrix = {{1}, {2}, {3}, {4}, {5}};

        ArrayList<Integer> result = printMatrix(matrix);
        for (int i : result) {
            System.out.println(i);
        }
    }

    public static ArrayList<Integer> printMatrix(int [][] matrix) {
        int i=0;
        int j = 0;
        int cols = matrix[0].length;
        int rows = matrix.length;

        ArrayList<Integer> printArray = new ArrayList<>();
        while ((i << 1) < rows && (j << 1) < cols) {
            printArray=printCircle(matrix,i,j,printArray);
            i++;
            j++;
        }

        return printArray;
    }

    private static ArrayList<Integer> printCircle(int[][] matrix, int i, int j, ArrayList<Integer> printArray) {
        int cols = matrix[0].length-1;
        int rows = matrix.length-1;

        int col = j;
        while (col <= cols - j) {
            printArray.add(matrix[i][col]);
            col++;
        }
        int row = i+1;
        if (rows-i >= row) {
            col--;
            while (row <= rows - i) {
                printArray.add(matrix[row][col]);
                row++;
            }
        }
        row--;
        if (col >= j+1 && row>=i+1) {
            col--;
            while (col >= j) {
                printArray.add(matrix[row][col]);
                col--;
            }
        }

        row--;
        while (row > i && j < cols - j) {
            printArray.add(matrix[row][j]);
            row--;
        }


        return printArray;
    }

}
