package HW01.t03;

public class FuncLoop {
    int len;

    //    F(x) = tg(2x - 3)
    public strictfp double[][] foo(double a, double b, double h) {
        if (h != 0) {
            double[][] resultArray = new double[(int) ((b - a) / h + 1)][2];
            int count = 0;

            for (double x = a; x <= b; x += h) {
                resultArray[count][0] = x;
                resultArray[count][1] = Math.tan(2 * x) - 3;

                int currentLen = ("" + resultArray[count][0] + resultArray[count][1]).length();
                if (currentLen > len) {
                    len = currentLen;
                }
                ++count;
            }
            return resultArray;
        } else {
            return new double[0][0];
        }
    }

    private void drawLines() {
        for (int i = 0; i < len + 6; i++) {
            System.out.print("-");
        }
        System.out.println();
    }
    private void drawEOL(int currLen){
        for (int i = 0; i <len + 6 - currLen; i++) {
            System.out.print(" ");
        }
        System.out.println("|");
    }

    public void builTable(double[][] resultArray) {
        for (double[] row : resultArray) {
            drawLines();
            String tmpLine = "| " + row[0] + " | " + row[1];
            System.out.print(tmpLine);
            drawEOL(tmpLine.length());
        }
    }
}
