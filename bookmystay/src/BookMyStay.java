import java.util.ArrayList;

// Class representing a single Bogie
class PassengerBogie {
    private String type;
    private int capacity;

    public PassengerBogie(String type, int capacity) {
        this.type = type;
        this.capacity = capacity;
    }

    public String getType() {
        return type;
    }

    @Override
    public String toString() {
        return "(" + type + " - " + capacity + " seats)";
    }
}

// Class to manage the Train Consist using ArrayList
class TrainConsistManager {
    private ArrayList<PassengerBogie> consist;

    public TrainConsistManager() {
        // UC2: Initializing the dynamic list
        this.consist = new ArrayList<>();
    }

    // Method to add a bogie
    public void addBogie(String type, int capacity) {
        PassengerBogie newBogie = new PassengerBogie(type, capacity);
        consist.add(newBogie);
        System.out.println("Added: " + type);
    }

    // Method to remove a bogie by index
    public void removeBogie(int index) {
        if (index >= 0 && index < consist.size()) {
            PassengerBogie removed = consist.remove(index);
            System.out.println("Removed: " + removed.getType());
        } else {
            System.out.println("Error: No bogie found at index " + index);
        }
    }

    // Method to check if a specific type exists
    public void searchBogie(String type) {
        boolean found = false;
        for (PassengerBogie bogie : consist) {
            if (bogie.getType().equalsIgnoreCase(type)) {
                found = true;
                break;
            }
        }
        System.out.println("Search result for '" + type + "': " + (found ? "Exists" : "Not Found"));
    }

    // Display all bogies currently attached
    public void displayConsist() {
        System.out.println("\n--- Current Train Composition ---");
        if (consist.isEmpty()) {
            System.out.println("The train has no bogies attached.");
        } else {
            for (int i = 0; i < consist.size(); i++) {
                System.out.println(i + ": " + consist.get(i));
            }
        }
        System.out.println("----------------------------------\n");
    }
}

// Main Execution Class
 class TrainApp {
    public static void main(String[] args) {
        TrainConsistManager myTrain = new TrainConsistManager();

        // 1. Adding Passenger Bogies
        myTrain.addBogie("Sleeper", 72);
        myTrain.addBogie("AC Chair", 40);
        myTrain.addBogie("First Class", 24);

        // 2. Checking current composition
        myTrain.displayConsist();

        // 3. Checking whether a bogie exists
        myTrain.searchBogie("AC Chair");
        myTrain.searchBogie("Goods");

        // 4. Removing a bogie (Removing AC Chair at index 1)
        myTrain.removeBogie(1);

        // 5. Final display
        myTrain.displayConsist();
    }
}