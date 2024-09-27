import java.util.Scanner;

public class Ui {
    private Room currentRoom;
    private Map map;


    public void startSpillet() {
        // Introduktion
        System.out.println("\nWelcome to THE-ADVENTURE-GAME!");
        System.out.println("This game is an advnture game - it has 9 rooms that you can explore by using specific commands");

        Scanner input = new Scanner(System.in);

        // Vi laver et nyt map da vi skal bruge map1.roomCreator til at lave rummene, det er en metode i Map klassen.
        Map map1 = new Map();
        String userCommand = null;

        // Her bliver rumene dannet og spawn room'et bliver sat til room1 via. Map klassen, da roomCreator returnerer room1
        Room roomSpawn = map1.roomCreator();

        Player player1 = new Player(roomSpawn);

        currentRoom = roomSpawn;

        // Introduktion
        System.out.println("\nSpawn location: " + currentRoom.getName() + "\n");
        System.out.println("What would you like to do?");
        System.out.println("---Type help to view the possible commands---");


        // While loop for at holde programmet kørende indtil man skriver "exit"
        boolean keepRunning = true;


        while (keepRunning){
            userCommand = input.nextLine().toLowerCase();

            // Hvis det er en bevægelseskommando, så kalder vi movePlayer() - Måske avet på en dum/forkert måde men...
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
                            "go west - To go west\nlook - To look around current room\nhelp - To view commands\nexit - to exit the game");
                    case "look", "l" -> System.out.println("Looking around the room..." + player1.getCurrentRoom().getName() +player1.getCurrentRoom().getDescription());
                    case "exit", "x" -> {
                        System.out.println("Exiting the program...");
                        keepRunning = false;
                    }
                    default -> System.out.println("Invalid");
                }
            }
        }
        }
    }
