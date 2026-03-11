import java.util.*;

class Room {
    private String type;
    private double price;
    private String amenities;

    public Room(String type, double price, String amenities) {
        this.type = type;
        this.price = price;
        this.amenities = amenities;
    }

    public void displayRoomDetails() {
        System.out.println("Room Type: " + type);
        System.out.println("Price: ₹" + price);
        System.out.println("Amenities: " + amenities);
        System.out.println("---------------------------");
    }
}

class RoomInventory {
    private Map<String, Integer> availability = new HashMap<>();

    public RoomInventory() {
        availability.put("Single", 5);
        availability.put("Double", 3);
        availability.put("Suite", 2);
    }

    public Map<String, Integer> getRoomAvailability() {
        return availability;
    }
}

class RoomSearchService {
    public void searchAvailableRooms(RoomInventory inventory, Room singleRoom, Room doubleRoom, Room suiteRoom) {

        Map<String, Integer> availability = inventory.getRoomAvailability();

        System.out.println("Available Rooms");
        System.out.println("===================");

        if (availability.get("Single") > 0) {
            singleRoom.displayRoomDetails();
        }

        if (availability.get("Double") > 0) {
            doubleRoom.displayRoomDetails();
        }

        if (availability.get("Suite") > 0) {
            suiteRoom.displayRoomDetails();
        }
    }
}

public class UseCase4RoomSearch {
    public static void main(String[] args) {

        Room singleRoom = new Room("Single", 2000, "WiFi, TV, AC");
        Room doubleRoom = new Room("Double", 3500, "WiFi, TV, AC, Mini Bar");
        Room suiteRoom = new Room("Suite", 6000, "WiFi, TV, AC, Mini Bar, Jacuzzi");

        RoomInventory inventory = new RoomInventory();

        RoomSearchService searchService = new RoomSearchService();

        searchService.searchAvailableRooms(inventory, singleRoom, doubleRoom, suiteRoom);
    }
}
