import java.util.Scanner;

class Booking {
    int availableSeats = 5;
    Scanner sc = new Scanner(System.in);

    void bookSeats() {
        while (true) {
            System.out.print("\nEnter the number of seats you want to book: ");
            int seats = sc.nextInt();

            if (seats > 0 && seats <= availableSeats) {
                System.out.println("Your booking has been confirmed.");
                System.out.println("You have booked " + seats + " seat(s).");

                availableSeats = availableSeats - seats;
                System.out.println("Remaining seats: " + availableSeats);

                if (availableSeats == 0) {
                    System.out.println("\nAll seats are booked. Thank you.");
                    break;
                }

                System.out.print("\nDo you want to book more seats? (yes/no): ");
                sc.nextLine(); // consume newline
                String choice = sc.nextLine();

                if (!choice.equalsIgnoreCase("yes")) {
                    System.out.println("\nThank you for using the Bus Ticket Management Application.");
                    break;
                }
            } else {
                System.out.println("Only " + availableSeats + " seats are available. Please try again.");
            }
        }
    }
}

public class BusApplication {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("\nWELCOME TO BUS TICKET MANAGEMENT APPLICATION");
        System.out.println("================================================");

        System.out.print("Enter your name: ");
        String name = sc.nextLine();

        System.out.println("\nHello " + name + ", welcome to the application.");

        Booking booking = new Booking();
        booking.bookSeats();
    }
}
