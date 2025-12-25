import java.lang.*;
class BusBooking extends Thread{
    int available = 5;
    int seat;
    BusBooking(int seat){
        this.seat = seat;
    }
    public void run(){
        if(available >= seat){
            System.out.println("Seats are Booked");
            available = available - seat;
        }
        else{
            System.out.println("Sorry");
        }
    }
}
public class BusApplicationWith_MultiThreading{
    public static void main(String[] args) {
        BusBooking op = new BusBooking(2);
        Thread t1 = new Thread();
        Thread t2 = new Thread();
        Thread t3 = new Thread();

        t1.start();
        t2.start();
        t3.start();
    }
}
/*
Personal Code:
    class Book{
    static int availableSeats = 5;
    static void bookSeat(String name,int seats){

        System.out.println(name + " is trying to book " + seats + " seat(s)");

        if (seats <= availableSeats && availableSeats > 0) {
            System.out.println("Booking confirmed for " + name);
            System.out.println(name + " booked " + seats + " seat(s)");

            availableSeats = availableSeats - seats;
            System.out.println("Remaining seats: " + availableSeats);
        } else {
            System.out.println("Booking failed for " + name);
            System.out.println("Only " + availableSeats + " seat(s) available");
        }

        System.out.println("-------------------------------------");
    }
}

class User extends Thread {

    String userName;
    int seats;

    User(String userName, int seats) {
        this.userName = userName;
        this.seats = seats;
    }

    public void run() {
        Book.bookSeat(userName, seats);
    }
}
public class BusApplicationWith_MultiThreading {
    public static void main(String[] args) {

        System.out.println("WELCOME TO BUS TICKET MANAGEMENT APPLICATION");
        System.out.println("===========================================");

        // Static input (no Scanner)
        User u1 = new User("Soham", 2);
        User u2 = new User("Amit", 2);
        User u3 = new User("Rahul", 2);

        // Multithreading
        u1.start();
        u2.start();
        u3.start();
    }
}

*/



/*
GPT Code:
    class Booking {

    static int availableSeats = 5;

    // synchronized method to avoid data inconsistency
    synchronized static void bookSeats(String name, int seats) {

        System.out.println(name + " is trying to book " + seats + " seat(s)");

        if (seats <= availableSeats) {
            System.out.println("Booking confirmed for " + name);
            System.out.println(name + " booked " + seats + " seat(s)");

            availableSeats = availableSeats - seats;
            System.out.println("Remaining seats: " + availableSeats);
        } else {
            System.out.println("Booking failed for " + name);
            System.out.println("Only " + availableSeats + " seat(s) available");
        }

        System.out.println("-------------------------------------");
    }
}

class User extends Thread {

    String userName;
    int seats;

    User(String userName, int seats) {
        this.userName = userName;
        this.seats = seats;
    }

    public void run() {
        Booking.bookSeats(userName, seats);
    }
}

public class BusApplication {

    public static void main(String[] args) {

        System.out.println("WELCOME TO BUS TICKET MANAGEMENT APPLICATION");
        System.out.println("===========================================");

        // Static input (no Scanner)
        User u1 = new User("Soham", 2);
        User u2 = new User("Amit", 2);
        User u3 = new User("Rahul", 2);

        // Multithreading
        u1.start();
        u2.start();
        u3.start();
    }
}

*/