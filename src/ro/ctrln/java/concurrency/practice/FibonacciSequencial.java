package ro.ctrln.java.concurrency.practice;

public class FibonacciSequencial {

    public static void main(String[] args) {

        int first = 0;
        int second = 1;
        int third;
        int count = 40;
        System.out.print(first + " " + second);

        for(int i = 2; i < count; ++i) {
            third = first + second;
            System.out.print(" " + third);
            first = second;
            second = third;
        }
    }
}
