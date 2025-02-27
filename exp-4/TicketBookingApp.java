class TicketBookingSystem {
    private boolean[] seats;
    
    public TicketBookingSystem(int numberOfSeats) {
        seats = new boolean[numberOfSeats];
    }

    public synchronized boolean bookSeat(int seatNumber, String customerType) {
        if (seatNumber >= 0 && seatNumber < seats.length && !seats[seatNumber]) {
            seats[seatNumber] = true;
            System.out.println(customerType + " booked seat " + seatNumber);
            return true;
        }
        System.out.println(customerType + " failed to book seat " + seatNumber + " (Already booked or invalid seat number).");
        return false;
    }
}

class BookingThread extends Thread {
    private TicketBookingSystem bookingSystem;
    private int seatNumber;
    private String customerType;

    public BookingThread(TicketBookingSystem bookingSystem, int seatNumber, String customerType) {
        this.bookingSystem = bookingSystem;
        this.seatNumber = seatNumber;
        this.customerType = customerType;
    }

    @Override
    public void run() {
        boolean success = bookingSystem.bookSeat(seatNumber, customerType);
        if (success) {
            System.out.println(customerType + " successfully booked seat " + seatNumber);
        }
    }
}

public class TicketBookingApp{
    public static void main(String[] args) {
        TicketBookingSystem bookingSystem = new TicketBookingSystem(5);
        
        BookingThread thread1 = new BookingThread(bookingSystem, 1, "Regular");
        BookingThread thread2 = new BookingThread(bookingSystem, 2, "VIP");
        BookingThread thread3 = new BookingThread(bookingSystem, 1, "VIP");
        BookingThread thread4 = new BookingThread(bookingSystem, 3, "Regular");
        BookingThread thread5 = new BookingThread(bookingSystem, 2, "Regular");
        BookingThread thread6 = new BookingThread(bookingSystem, 0, "VIP");
        
        thread2.setPriority(Thread.MAX_PRIORITY);
        thread3.setPriority(Thread.MAX_PRIORITY);
        thread6.setPriority(Thread.MAX_PRIORITY);
        thread1.setPriority(Thread.NORM_PRIORITY);
        thread4.setPriority(Thread.NORM_PRIORITY);
        thread5.setPriority(Thread.NORM_PRIORITY);
        
        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        thread5.start();
        thread6.start();
    }
}
