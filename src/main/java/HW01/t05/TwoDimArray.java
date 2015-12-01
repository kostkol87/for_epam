package HW01.t05;

import java.io.IOException;
import java.util.Scanner;

public class TwoDimArray {
    private int size;
    public int[][] buid_array(){

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter matrix size: ");
        size = scanner.nextInt();
        if (size < 0){
            try {
                throw new IOException();
            } catch (IOException e) {
                System.out.println("Matrix can't have a negative size");
                buid_array();
            }
        }
        return  new int[size][size];
    }

    public int[][] crossIt(int[][] array) {
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
        ints = tda.crossIt(ints);
        tda.printIt(ints);

    }
}
