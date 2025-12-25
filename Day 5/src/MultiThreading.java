import java.lang.*;
/*
    Step 1: Import java.lang Package
    Step 2: A) By Extending the thread class
            B) By Implementing the Runnable Interface. -> it's a pre-defined interface in Java
            The Application in real world for security purpose is option (B)
    Step 3: Initialize the run() Method. -> Already present in lang package
    Step 4: Give the Public access to the run() method -> Which will Remove Errors from Step 3
    Step 5: Implement the run()  method.
    Step 6: Create the number of Threads (number of Users).
    Step 7: Call the start() method -> Start the Threads from Users.
*/

class loop extends Thread {
    public void run() { //As this method is already present in lang package we will public it
        for (int i = 0; i <= 3; i++) {
            System.out.println("Bye");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

public class MultiThreading {
    public static void main(String[] args) {
        loop op = new loop();
        op.start(); // -> Because of this JVM gets to know multiThreading is happening, if we had called it after the loop the output might be different
        for (int i = 0; i <= 3; i++) {
            System.out.println("Hello");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}


/*
// Single Threading
   class loop{
    loop(){
        for (int i = 0; i <=3 ; i++) {
            System.out.println("Bye");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
public class MultiThreading {
    public static void main(String[] args) {
            loop op = new loop();

            try {
                for (int i = 0; i <= 3 ; i++) {
                    System.out.println("Hello");
                    Thread.sleep(2000);
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
    }
}

*/