import java.util.*;

class Reservation {
    private String guestName;
    private String roomType;

    public Reservation(String guestName, String roomType) {
        this.guestName = guestName;
        this.roomType = roomType;
    }

    public String getGuestName() {
        return guestName;
    }

    public String getRoomType() {
        return roomType;
    }
}

class RoomInventory {
    private Map<String, Integer> inventory;

    public RoomInventory() {
        inventory = new HashMap<>();
        inventory.put("Single", 2);
        inventory.put("Double", 2);
        inventory.put("Suite", 1);
    }

    public boolean hasRoom(String type) {
        return inventory.getOrDefault(type, 0) > 0;
    }

    public void decreaseRoom(String type) {
        inventory.put(type, inventory.get(type) - 1);
    }
}

class RoomAllocationService {
    private Set<String> allocatedRoomIds;
    private Map<String, Set<String>> assignedRoomsByType;

    public RoomAllocationService() {
        allocatedRoomIds = new HashSet<>();
        assignedRoomsByType = new HashMap<>();
    }

    public void allocateRoom(Reservation reservation, RoomInventory inventory) {
        String type = reservation.getRoomType();

        if (!inventory.hasRoom(type)) {
            System.out.println("No rooms available for " + reservation.getGuestName());
            return;
        }

        String roomId = generateRoomId(type);

        allocatedRoomIds.add(roomId);

        assignedRoomsByType.putIfAbsent(type, new HashSet<>());
        assignedRoomsByType.get(type).add(roomId);

        inventory.decreaseRoom(type);

        System.out.println("Booking confirmed for Guest: " + reservation.getGuestName() + ", Room ID: " + roomId);
    }

    private String generateRoomId(String roomType) {
        assignedRoomsByType.putIfAbsent(roomType, new HashSet<>());
        int number = assignedRoomsByType.get(roomType).size() + 1;
        return roomType + "-" + number;
    }
}

public class UseCase6RoomAllocationService {
    public static void main(String[] args) {

        System.out.println("Room Allocation Processing");

        Queue<Reservation> queue = new LinkedList<>();

        queue.offer(new Reservation("Abhi", "Single"));
        queue.offer(new Reservation("Subha", "Single"));
        queue.offer(new Reservation("Vanmathi", "Suite"));

        RoomInventory inventory = new RoomInventory();
        RoomAllocationService service = new RoomAllocationService();

        while (!queue.isEmpty()) {
            Reservation r = queue.poll();
            service.allocateRoom(r, inventory);
        }
    }
}