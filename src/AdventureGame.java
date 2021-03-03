import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class AdventureGame {

    public static void main(String[] args) {
        Map<Integer, Location> locations = new HashMap<Integer, Location>();

        Map<String, Integer> exits = new HashMap<>();
        exits.put("E", 3);
        exits.put("W", 2);
        exits.put("S", 4);
        exits.put("N", 5);
        locations.put(1, new Location(1, "You are standing at the end of a road before a small brick building", exits));

        exits = new HashMap<>();
        exits.put("N", 5);
        locations.put(2, new Location(2, "You are at the top of a hill", exits));

        exits = new HashMap<>();
        exits.put("W", 1);
        locations.put(3, new Location(3, "You are inside a building, a well house for a small spring", exits));

        exits = new HashMap<>();
        exits.put("N", 1);
        exits.put("W", 2);
        locations.put(4, new Location(4, "You are in a valley beside a stream", exits));

        exits = new HashMap<>();
        exits.put("S", 1);
        exits.put("W", 2);
        locations.put(5, new Location(5, "You are in the forest", null));

        locations.put(0, new Location(0, "You are sitting in front of a computer learning Java", exits));

        Map<String, String> vocabulary = new HashMap<>();
        vocabulary.put("QUIT", "Q");
        vocabulary.put("NORTH", "N");
        vocabulary.put("SOUTH", "S");
        vocabulary.put("EAST", "E");
        vocabulary.put("WEST", "W");

        Scanner s = new Scanner(System.in);
        Location currentLocation = locations.get(1);
        while (true) {
            System.out.println(currentLocation.getDescription());
            System.out.print("Available exits are ");
            for (String dir : currentLocation.getExits().keySet()) {
                System.out.print(dir + ", ");
            }
            System.out.print(": ");
            String direction = s.nextLine().toUpperCase();
            if (direction.length() > 1) {
                String[] words = direction.split(" ");
                for (String word : words) {
                    if (vocabulary.containsKey(word)) {
                        direction = vocabulary.get(word);
                    }
                }
            }
            if(!currentLocation.getExits().containsKey(direction)) {
                System.out.println("You cannot go in that direction");
                continue;
            }
            else if (direction.equalsIgnoreCase("Q")) {
                break;
            }
            currentLocation = locations.get(currentLocation.getExits().get(direction));
        }
    }

    public void command() {
        // write code here
    }
}
