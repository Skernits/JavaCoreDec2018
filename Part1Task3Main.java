package org.test.epamtasks;

public class Part1Task3Main {
    public static void main (String[] args) {
        double start = 0.0;
        double end = 3;
        double step = 0.5;

        double[][] test1 = funcTg(start, end, step);
        for (int i = 0; i < test1.length; i++) {
            System.out.println("x = " + test1[i][0] + " f(x) = " + test1[i][1]);
        }

    }
    public static double[][] funcTg(double start, double end, double step) { // count f(x) = tg(2x) - 3 in [a, b], where a=start, b=end
        if (start > end) return new double[0][0];
        int length = (int)((end - start) / step) + 1;
        double[][] result = new double[length][2];
        int i = 0;
        for (double x = start; x <= end; x = x + step) {
            result[i][0] = x;
            result[i][1] = Math.tan(2 * x) - 3;
            i++;
        }
        return result;
    }
}
