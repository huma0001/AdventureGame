import java.util.Scanner;

// Controller klasse
public class AdventureGameController {

    public void startSpillet() {
        Scanner input = new Scanner(System.in);

        // Vi laver et nyt map da vi skal bruge map1.roomCreator til at lave rummene, det er en metode i Map klassen.
        Map map1 = new Map();
        String userCommand = null;

        // Her bliver rumene dannet og spawn room'et bliver sat til room1 via. Map klassen, da roomCreator returnerer room1
        Room roomSpawn = map1.roomCreator();

        Player player1 = new Player(roomSpawn);

        // While loop for at holde programmet kørende indtil man skriver "exit"
        boolean keepRunning = true;

        while (keepRunning) {
            userCommand = input.nextLine().toLowerCase();

            // Hvis det er en bevægelseskommando, så kalder vi movePlayer() - Måske lavet på en dum/forkert måde men...
            // Det er for at undgå beskeden "You cannot go this way - try another direction når vi f.eks. skriver help
            // Da den samtidig tjekker for nextRooms værdi
            if (userCommand.equals("go north") || userCommand.equals("n") ||
                    userCommand.equals("go south") || userCommand.equals("s") ||
                    userCommand.equals("go east") || userCommand.equals("e") ||
                    userCommand.equals("go west") || userCommand.equals("w")) {
                player1.movePlayer(userCommand);
            } else {
                switch (userCommand) {
                    case "help", "h" -> printHelp();
                    case "look", "l" -> {
                        System.out.println("Looking around the room...");
                        System.out.println(player1.getCurrentRoom().getDescription());
                        if (!player1.getCurrentRoom().getItemList().isEmpty()) {
                            System.out.println("\nTotal item(s) in this room: " + player1.getCurrentRoom().totalItemCounter() + player1.getCurrentRoom().displayItems());
                        } else {
                            System.out.println(player1.getCurrentRoom().displayItems());
                        }
                        break;
                    }
                    case "take", "t", "take " -> {
                        System.out.println("What would you like to take? *Enter item name*" + player1.getCurrentRoom().displayItems());
                        String userSearchItem = input.nextLine();
                        Item itemFinder = player1.getCurrentRoom().findItem(userSearchItem);
                        if (itemFinder != null) {
                            player1.addToPlayerInventory(itemFinder);
                            player1.removeItemFromRoom(itemFinder);
                            System.out.println("You have added a " + "'" + itemFinder.getName() + "´" + " to your inventory." + "\ntype 'inventory' to view your updated inventory");
                        }
                    }
                    case "drop", "d", "drop " -> {
                        System.out.println("What item would you like to drop?");
                        player1.viewInventory();
                        String itemToDrop = input.nextLine();
                        Item itemFinderDrop = player1.findItem2(itemToDrop);
                        if (itemFinderDrop != null) {
                            player1.addItemToRoom(itemFinderDrop);
                            player1.removeFromPlayerInventory(itemFinderDrop);
                            System.out.println("You have removed: " + itemFinderDrop.getName() + " from your inventory. \ntype 'inventory' to view your updated inventory");
                        }
                    }
                    case "inventory", "i" -> player1.viewInventory();
                    case "exit", "x" -> {
                        System.out.println("Exiting the program...");
                        keepRunning = false;
                    }
                    default -> System.out.println("Invalid command - Type 'help' to view commands");
                }
            }
        }
    }

    public void printHelp() {
        System.out.println("Type 'help' - to view commands");
        System.out.println("Type 'go (direction)' - to go a specific direction \nDirections:South,East,West and North");
        System.out.println("Type 'look' - to look in the current room you are in");
        System.out.println("Type 'take' - to take items");
        System.out.println("Type 'drop' - to drop items");
        System.out.println("Type 'inventory' - to view your inventory");
        System.out.println("Type 'exit' - to exit the game");
    }
}