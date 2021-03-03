import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Theatre {

    private final String name;
    public  List<Seat> seats = new ArrayList<>();

    public Theatre(String name, int numRows, int seatsPerRow) {
        this.name = name;

        int lastRow = 'A' + numRows - 1;
        for (char row = 'A'; row <= lastRow; row++) {
            for (int seatNum = 1; seatNum <= seatsPerRow; seatNum++) {
                Seat seat = new Seat(row + String.format("%2d", seatNum));
                seats.add(seat);
            }
        }
    }

    public String getName() {
        return name;
    }

    public boolean reserveSeat(String seatNum) {
        Seat requestedSeat = new Seat(seatNum);
        int foundSeat = Collections.binarySearch(seats, requestedSeat, null);
        if (foundSeat >= 0) {
            return seats.get(foundSeat).isReserved;
        } else {
            System.out.println("There is no seat " + seatNum);
            return false;
        }
//        for (Seat seat:seats) {
//            System.out.print(".");
//            if(seat.getSeatNumber().equals(seatNum)) {
//                requestedSeat = seat;
//                break;
//            }
//        }
//        if (requestedSeat == null) {
//            System.out.println("There is no seat " + seatNum);
//            return false;
//        }
//        return requestedSeat.reserve();
    }

    public void getSeats() {
        for (Seat seat: seats) {
            System.out.println(seat.getSeatNumber());
        }
    }

    public class Seat implements Comparable<Seat> {
        private final String seatNumber;
        private boolean isReserved;

        public Seat(String seatNumber) {
            this.seatNumber = seatNumber;
        }

        public String getSeatNumber() {
            return seatNumber;
        }

        public boolean reserve() {
            if(!this.isReserved) {
                this.isReserved = true;
                System.out.println("Seat " + seatNumber + " reserved.");
                return true;
            } else {
                return false;
            }
        }

        public boolean cancel() {
            if(this.isReserved) {
                this.isReserved = false;
                System.out.println("Reservation of seat " + seatNumber + " has been cancelled.");
                return true;
            } else {
                return false;
            }
        }

        @Override
        public int compareTo(Seat seat) {
            return this.seatNumber.compareToIgnoreCase(seat.getSeatNumber());
        }
    }
}
