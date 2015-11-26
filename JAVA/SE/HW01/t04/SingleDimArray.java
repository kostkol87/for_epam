package JAVA.SE.HW01.t04;

import java.util.Scanner;

public class SingleDimArray {
    private double[] array;
    private double count;

    public double[] buildArray() {

        Scanner scan = new Scanner(System.in);
        System.out.print("Enter n: ");
        int n = scan.nextInt();
        array = new double[n * 2];

        //some fill logic here
        for (int i = 0; i < array.length; i++) {
            array[i] = count++;
        }
        return array;
    }

    public double max(double[] filled_array) {
        double maxValue = 0;
        double current_value;
        for (int i = 0; i < filled_array.length; i++) {
            current_value = filled_array[i] + filled_array[filled_array.length - 1 - i];
            if (i == 0) {
                maxValue = current_value;
            }
            if (current_value > maxValue) {
                maxValue = current_value;
            }
        }
        return maxValue;
    }

    public static void main(String[] args) {
        SingleDimArray sda = new SingleDimArray();
        double[] doubles = sda.buildArray();
        System.out.println(sda.max(doubles));

    }
}
