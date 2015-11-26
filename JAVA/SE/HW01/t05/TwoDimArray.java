package JAVA.SE.HW01.t05;

import java.util.Scanner;

public class TwoDimArray {
    private int[][] array;

    public int[][] buid_array() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Укажите размер матрицы:");
        int size = scanner.nextInt();
        array = new int[size][size];
        return array;
    }

    public int[][] cross_it(int[][] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                array[i][i] = 1;
                array[array[i].length - 1 - i][i] = 1;
            }
        }
        return array;
    }

    public void printIt(int[][] array) {
        for (int[] x : array) {
            for (int y : x) {
                System.out.print(y + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        TwoDimArray tda = new TwoDimArray();
        int[][] ints = tda.buid_array();
        ints = tda.cross_it(ints);
        tda.printIt(ints);

    }
}
