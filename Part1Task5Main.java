package org.test.epamtasks;

public class Part1Task5Main {
    public static void main(String[] args) {
        int n = 10;
        int[][] test1 = matrixNN(n);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(test1[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static int[][] matrixNN(int n) { // get matrix - n x n
        int[][] matrix = new int[n][n];
        for (int i = 0; i < n; i++) {
            matrix[i][i] = 1;
            matrix[i][n - 1 - i] = 1;
        }
        return matrix;
    }
}
