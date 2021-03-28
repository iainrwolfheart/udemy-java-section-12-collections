import java.util.*;

public class Main {
    private static Map<HeavenlyBody.Key, HeavenlyBody> solarSystem = new HashMap<>();
    private static Set<HeavenlyBody> planets = new HashSet<>();

    public static void main(String[] args) {

//        HeavenlyBody temp = new Planet("Mercury", 88);
//        solarSystem.put(temp.getKey(), temp);
//        planets.add(temp);
//
//        temp = new Planet("Earth", 365);
//        solarSystem.put(temp.getKey(), temp);
//        planets.add(temp);
//
//        HeavenlyBody tempMoon = new Moon("Moon", 27);
//        solarSystem.put(tempMoon.getKey(), tempMoon);
//        temp.addSatellite(tempMoon);
//
//        temp = new Planet("Jupiter", 4332);
//        solarSystem.put(temp.getKey(), temp);
//        planets.add(temp);
//
//        tempMoon = new Moon("Io", 1.8);
//        solarSystem.put(tempMoon.getKey(), tempMoon);
//        temp.addSatellite(tempMoon);
//
//        tempMoon = new Moon("Ganymede", 3.5);
//        solarSystem.put(tempMoon.getKey(), tempMoon);
//        temp.addSatellite(tempMoon);
//
//        System.out.println("Planets:");
//        for(HeavenlyBody planet: planets) {
//            System.out.println("\t" + planet);
//        }

//        Theatre theatre = new Theatre("Olympian", 8, 12);
//        List<Theatre.Seat> seatCopy = new ArrayList<>(theatre.seats);
//
//        seatCopy.get(1).reserve();
//        if(theatre.reserveSeat("A 2")) {
//            System.out.println("Please pay for A 2");
//        } else {
//            System.out.println("Seat A02 already reserved.");
//        }
//
//        Collections.reverse(seatCopy);
//        System.out.println("Printing seatCopy in reverse.");
//        printList(seatCopy);
//
//        Theatre.Seat minSeat = Collections.min(seatCopy);
//        Theatre.Seat maxSeat = Collections.max(seatCopy);
//        System.out.println(minSeat.getSeatNumber() + " / " + maxSeat.getSeatNumber());
//
//        sortList(seatCopy);
//        System.out.println("Printing sorted seatCopy");
//        printList(seatCopy);

//        theatre.getSeats();
//        if (theatre.reserveSeat("H11")) {
//            System.out.println("Please pay");
//        } else {
//            System.out.println("Sorry, seat already taken.");
//        }
//        if (theatre.reserveSeat("H11")) {
//            System.out.println("Please pay");
//        } else {
//            System.out.println("Sorry, seat already taken.");
//        }
    }

    public static void printList(List<Theatre.Seat> list) {
        for(Theatre.Seat seat: list) {
            System.out.println(seat.getSeatNumber());
        }
        System.out.println();
        System.out.println("============================");
    }

    public static void sortList(List<? extends Theatre.Seat> list) {
        for(int i = 0; i < list.size() - 1; i++) {
            for (int j = 1; j < list.size(); j++) {
                if (list.get(i).compareTo(list.get(j)) > 0) {
                    Collections.swap(list, i, j);
                }
            }
        }
    }
}
