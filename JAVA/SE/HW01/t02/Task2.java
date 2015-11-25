package JAVA.SE.HW01.t02;

public class Task2 {
    static final double EPS = 0.000001;

    private strictfp void findMin(){
        double a;
        double tmp = 0;
        for (int i = 1;; i++) {
            a = 1/(Math.pow((i + 1), 2));
            if(a > EPS){
                System.out.println(i + " : " + a);
            }else {
                System.out.println("minimum at index " + (i - 1) + " with value " + tmp);
                break;
            }
            tmp = a;
        }
    }

    public static void main(String[] args) {
        new Task2().findMin();
    }
}
