package org.test.epamtasks;

public class Part1Task2Main {

    public static void main(String[] args) {
        double eps = 0.05;
        int result = idxAMin(eps);
    }

    public static int idxAMin(double eps) {
        double an = 1.0; // наибольший возможный элемент последвательности 1 / ((n+1)*(n+1))
        int i = 1;
        if (eps >= 1) {
            System.out.println("Наименьший номер элемента, при котором выполняется an < eps : " + an);
        } else {
            while (an >= eps) {
                an = 1 / ((i + 1.0) * (i + 1.0));
                System.out.println("i = " + i + " , a(i) = " + an);
                i++;
            }
            System.out.println("Наименьший номер элемента, при котором выполняется an < eps : " + (i - 1));
        }
        return (i - 1);
    }

}

