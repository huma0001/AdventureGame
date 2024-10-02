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

            // HviRs det er en bevægelseskommando, så kalder vi movePlayer() - Måske avet på en dum/forkert måde men...
            // Det er for at undgå beskeden "You cannot go this way - try another direction når vi f.eks. skriver herlp
            // Da den samtidig tjekker for nextRooms værdi
            if (userCommand.equals("go north") || userCommand.equals("n") ||
                    userCommand.equals("go south") || userCommand.equals("s") ||
                    userCommand.equals("go east") || userCommand.equals("e") ||
                    userCommand.equals("go west") || userCommand.equals("w")) {
                player1.movePlayer(userCommand);
            } else {
                switch (userCommand) {
                    case "help", "h" -> System.out.println("Commands:\ngo north - To go north\ngo south - To go south\ngo east - To go east\n" +
                            "go west - To go west\nlook - To look around current room\ntake - to take item in current room \ndrop - to drop item from inventory \ninventory - to view items in your inventory" +
                            "\nhelp - To view commands\nexit - to exit the game");
                    case "look", "l" ->{
                        System.out.println("Looking around the room...");
                        System.out.println(player1.getCurrentRoom().getDescription());
                        if(!player1.getCurrentRoom().getItemList().isEmpty()) {
                            System.out.println("\nTotal item(s) in this room: " + player1.getCurrentRoom().totalItemCounter() + player1.getCurrentRoom().displayItems());
                        } else {
                            System.out.println(player1.getCurrentRoom().displayItems());
                        }break;
                    }

                    //MANGLER---
                    case "take", "t" -> {
                        System.out.println("What would you like to take? *Enter item name*" + player1.getCurrentRoom().displayItems());
                        String userSearchItem = input.nextLine();
                        Item itemFinder = player1.getCurrentRoom().findItem(userSearchItem);
                        if (itemFinder != null){
                            player1.addToPlayerInventory(itemFinder);
                            player1.removeItemFromRoom(itemFinder);
                            System.out.println("You have added " + itemFinder.getName() + " to your inventory!" + "\ntype 'inventory' to view your updated inventory!");
                        }
                    }
                    //MANGLER---
                    case "drop", "d" ->{
                        System.out.println("What item would you like to drop?");
                        player1.viewInventory();
                        String itemToDrop = input.nextLine();
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

}