import java.lang.Thread;

// Sir Code
// Applications
class Print {

    // Shared resource
    synchronized void printTable(int n) {
        for (int i = 1; i <= 10; i++) {
            System.out.println(n + " * " + i + " = " + (n * i));
        }
        System.out.println();
    }
}

// Thread 1
class Five extends Thread {
    Print f;

    Five(Print f) {
        this.f = f;
    }

    public void run() {
        f.printTable(5);
    }
}

// Thread 2
class Seven extends Thread {
    Print s;

    Seven(Print s) {
        this.s = s;
    }

    public void run() {
        s.printTable(7);
    }
}

public class Calculator_MultiThreading {

    public static void main(String[] args) {

        Print op = new Print();   // One shared object

        // Creating the Object of Threads
        // We cant open the constructor of free defined class,as these are user defined
        Five t1 = new Five(op);
        Seven t2 = new Seven(op);

        t1.start();   // Start thread 1
        t2.start();   // Start thread 2
    }
}

/*
    // MyCode:
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

    public void run() { //->Main method used for multiThreading
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

*/