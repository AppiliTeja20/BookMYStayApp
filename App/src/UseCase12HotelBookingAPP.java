import java.io.*;
import java.util.*;

class RoomInventory {

    Map<String, Integer> inventory;

    public RoomInventory() {
        inventory = new HashMap<>();
        inventory.put("Single", 5);
        inventory.put("Double", 3);
        inventory.put("Suite", 2);
    }
}

class FilePersistenceService {

    public void saveInventory(RoomInventory inventory, String filePath) {

        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(filePath));

            for (Map.Entry<String, Integer> entry : inventory.inventory.entrySet()) {
                writer.write(entry.getKey() + "=" + entry.getValue());
                writer.newLine();
            }

            writer.close();

            System.out.println("Inventory saved successfully.");

        } catch (IOException e) {
            System.out.println("Error saving inventory.");
        }
    }

    public void loadInventory(RoomInventory inventory, String filePath) {

        File file = new File(filePath);

        if (!file.exists()) {
            System.out.println("No valid inventory data found. Starting fresh.");
            return;
        }

        try {

            BufferedReader reader = new BufferedReader(new FileReader(file));

            String line;

            while ((line = reader.readLine()) != null) {

                String[] parts = line.split("=");

                inventory.inventory.put(parts[0], Integer.parseInt(parts[1]));
            }

            reader.close();

        } catch (Exception e) {
            System.out.println("Failed to load inventory.");
        }
    }
}

public class UseCase12DataPersistenceRecovery {

    public static void main(String[] args) {

        System.out.println("System Recovery");

        RoomInventory inventory = new RoomInventory();

        FilePersistenceService persistence = new FilePersistenceService();

        String filePath = "inventory.txt";

        persistence.loadInventory(inventory, filePath);

        System.out.println();
        System.out.println("Current Inventory:");

        System.out.println("Single: " + inventory.inventory.get("Single"));
        System.out.println("Double: " + inventory.inventory.get("Double"));
        System.out.println("Suite: " + inventory.inventory.get("Suite"));

        persistence.saveInventory(inventory, filePath);
    }
}