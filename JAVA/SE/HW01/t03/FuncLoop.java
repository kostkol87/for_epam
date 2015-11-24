package JAVA.SE.HW01.t03;

public class FuncLoop {
    //    F(x) = tg(2x - 3)
    public strictfp void foo(double a, double b, double h){
        String table = "";
        for (double x = a; x <= b ; x += h) {
            table += x + "  : " + (Math.tan(2 * x) - 3) + "\r\n";
        }
        System.out.println(table);
    }

    public static void main(String[] args) {
        new FuncLoop().foo(0, 50, 1);
    }
}
