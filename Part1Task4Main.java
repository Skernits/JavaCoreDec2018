package org.test.epamtasks;

public class Part1Task4Main {
    public static void main(String[] args) {
        int n = 5;
        double[] test1 = new double[2 * n];
        for (int i = 0; i < 2 * n; i++) {
            test1[i] = 1;
        }
        test1[9] = 20;
        System.out.println("test1: " + maxA2N(test1));

        n = 0;
        double[] test2 = new double[2 * n];
        for (int i = 0; i < 2 * n; i++) {
            test1[i] = 1;
        }
        System.out.println("test2: " + maxA2N(test2));

    }

    public static double maxA2N(double[] nums) {
        if (nums.length == 0) return 0;
        double max = nums[0] + nums[nums.length - 1];
        for (int i = 0; i < nums.length / 2; i++) {
            max = Math.max(max, nums[i] + nums[nums.length - i - 1]);
        }
        return max;
    }
}
