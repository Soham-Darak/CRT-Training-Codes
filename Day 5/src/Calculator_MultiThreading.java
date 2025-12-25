class Multiply extends Thread {

    int number;

    Multiply(int number) {
        this.number = number;
    }

    public static synchronized void Multiplication(int number) {
        for (int i = 0; i <= 10; i++) {
            System.out.println(number + " * " + i + " = " + (number * i));
        }
    }

    public void run() {
        System.out.println(
                "Table of " + number + " started by " + Thread.currentThread().getName()
        );

        Multiplication(number);

        System.out.println(
                "Table of " + number + " completed\n"
        );
    }
}

public class Calculator_MultiThreading {

    public static void main(String[] args) {

        Multiply t1 = new Multiply(5);
        Multiply t2 = new Multiply(7);

        t1.start();
        t2.start();
    }
}
