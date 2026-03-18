import java.util.*;

class CancellationService {

    private Map<String, String> reservationRoomTypeMap;
    private Stack<String> rollbackStack;
    private Map<String, Integer> inventory;

    public CancellationService() {
        reservationRoomTypeMap = new HashMap<>();
        rollbackStack = new Stack<>();
        inventory = new HashMap<>();

        inventory.put("Single", 5);
        inventory.put("Double", 3);
        inventory.put("Suite", 2);

        reservationRoomTypeMap.put("Single-1", "Single");
    }

    public void cancelBooking(String reservationId) {

        if (!reservationRoomTypeMap.containsKey(reservationId)) {
            System.out.println("Invalid reservation ID");
            return;
        }

        String roomType = reservationRoomTypeMap.get(reservationId);

        rollbackStack.push(reservationId);

        inventory.put(roomType, inventory.get(roomType) + 1);

        reservationRoomTypeMap.remove(reservationId);

        System.out.println("Booking cancelled successfully. Inventory restored for room type: " + roomType);
    }

    public void displayRollbackHistory() {

        System.out.println();
        System.out.println("Rollback History (Most Recent First):");

        while (!rollbackStack.isEmpty()) {
            System.out.println("Released Reservation ID: " + rollbackStack.pop());
        }
    }

    public void displayInventory() {
        System.out.println();
        System.out.println("Updated Single Room Availability: " + inventory.get("Single"));
    }
}

public class UseCase10BookingCancellation {

    public static void main(String[] args) {

        System.out.println("Booking Cancellation");

        CancellationService service = new CancellationService();

        service.cancelBooking("Single-1");

        service.displayRollbackHistory();

        service.displayInventory();
    }
}