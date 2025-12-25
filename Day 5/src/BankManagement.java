
class BankAccount implements Runnable {

    static int availableBalance = 5000;   // shared balance
    int withdrawAmount;                   // per-thread amount

    BankAccount(int withdrawAmount) {
        this.withdrawAmount = withdrawAmount;
    }

    @Override
    public void run() {

        synchronized (BankAccount.class) {   // class-level lock

            String name = Thread.currentThread().getName();

            if (availableBalance >= withdrawAmount) {
                availableBalance =availableBalance - withdrawAmount;
                System.out.println("Transaction completed: " + name);
            } else {
                System.err.println(
                        "Sorry " + name + ". Only " + availableBalance + " left."
                );
            }
        }
    }
}

public class BankManagement {

    public static void main(String[] args) {

        BankAccount acc1 = new BankAccount(2000);
        BankAccount acc2 = new BankAccount(2000);

        Thread t1 = new Thread(acc1, "Priyanshu");
        Thread t2 = new Thread(acc1, "Soham");

        Thread t3 = new Thread(acc2, "Rohit");
        Thread t4 = new Thread(acc2, "Parth");

        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }
}
