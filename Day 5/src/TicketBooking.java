// Sir Code:
// In Java Programming Language Every object have only 1 Key and this key is given to only one thread at all the time
class BookingPrinting{
    int available = 10;
    void mix(int seat){
        System.out.println("Hello: "+Thread.currentThread().getName());
        System.out.println("Hello: "+Thread.currentThread().getName());
        System.out.println("Hello: "+Thread.currentThread().getName());

        // Creating a Block
        synchronized (this){
            if(available >= seat){
                System.out.println("-------------------------------------------");
                System.out.println("Tickets are Booked: "+ Thread.currentThread().getName());
                available = available -seat;
                System.out.println("Available Seats : "+available);
            }
            else{
                System.out.println("Sorry: "+Thread.currentThread().getName());
                System.out.println("Available Seats: "+available);
            }
        }
        System.out.println("Bye: "+Thread.currentThread().getName());
        System.out.println("Bye: "+Thread.currentThread().getName());
        System.out.println("Bye: "+Thread.currentThread().getName());
    }
}
public class TicketBooking extends Thread{
    static BookingPrinting op; // Globally Declaring the Object
    public void run(){
        op.mix(seat);
    }
    int seat;
    public static void main(String[] args) {
        op = new BookingPrinting();
        TicketBooking t1 = new TicketBooking();
        TicketBooking t2 = new TicketBooking();

        t1.setName("Soham");
        t2.setName("Parth");

        t1.seat = 6;
        t2.seat = 7;

        t1.start();
        t2.start();
    }
}

/*
// My Code:
    class TicketBook extends Thread {

    static int available = 10;
    int seats;

    TicketBook(int seats) {
        this.seats = seats;
    }

    public void run() {
        bookTicket(seats);
    }

    static void bookTicket(int seats) {
        System.out.println("Hello "+Thread.currentThread().getName());
        System.out.println("Hello "+Thread.currentThread().getName());
        System.out.println("Hello "+Thread.currentThread().getName());

       // System.out.println(Thread.currentThread().getName() +" trying to book " + seats + " seats");

        synchronized (TicketBook.class) {
            if (available >= seats) {
                System.out.println("Booking successful for " + seats + " seats");
                available -= seats;
                System.out.println("Seats left: " + available + "\n");
            } else {
                System.out.println("Booking failed. Only " + available + " seats left\n");
            }
        }

        System.out.println("Bye "+Thread.currentThread().getName());
        System.out.println("Bye "+Thread.currentThread().getName());
        System.out.println("Bye "+Thread.currentThread().getName());
    }
}

public class TicketBooking {

    public static void main(String[] args) {

        TicketBook t1 = new TicketBook(6);
        TicketBook t2 = new TicketBook(7);

        t1.setName("Soham");
        t2.setName("Parth");

        t1.start();
        t2.start();
    }
}

*/

