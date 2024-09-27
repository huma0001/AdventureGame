import java.util.Scanner;

public class Adventure {
    private Room currentRoom;
    private Map map;

    public void startSpillet(){
        System.out.println("\nWelcome to THE-ADVENTURE-GAME!");
        System.out.println("This game is an advnture game - it has 9 rooms that you can explore by using specific commands");

        Scanner input = new Scanner(System.in);

        Map map1 = new Map();

        System.out.println("\nSpawn location: Room 1");
        System.out.println("What would you like to do?");
        System.out.println("---Type help to view the possible commands---");



        String userCommand = null;

        currentRoom = map1.roomCreator();


        boolean keepRunning = true;

        while(keepRunning) {

            userCommand = input.nextLine();

            // If og else statements omkring directions -- Jeg foretrækker if else i starten over switch for direkte at kunne forstå koden
            if (userCommand.equalsIgnoreCase("go north") || userCommand.equalsIgnoreCase("n")) {
                System.out.println("Going north...");
                // Tjekker om den valgte direction er null (ingen dør)
                if(currentRoom.getNorth() == null){
                    System.out.println("You cannot go this way... Try again");
                } else {
                    // Hvis der er en direction (dør), så går vi derind og så tager vi fat i det rum som vores nye rum
                    currentRoom = currentRoom.getNorth();
                    System.out.println("You have moved to " + currentRoom.getName());
                }
            } else if (userCommand.equalsIgnoreCase("go south")|| userCommand.equalsIgnoreCase("s")) {
                System.out.println("Going south...");
                if(currentRoom.getSouth() == null){
                    System.out.println("You cannot go this way... Try again");
                } else {
                    currentRoom = currentRoom.getSouth();
                    System.out.println("You have moved to " + currentRoom.getName());
                }
            } else if (userCommand.equalsIgnoreCase("go east") || userCommand.equalsIgnoreCase("e")) {
                System.out.println("Going east...");
                if(currentRoom.getEast() == null){
                    System.out.println("You cannot go this way... Try again");
                } else {
                    currentRoom = currentRoom.getEast();
                    System.out.println("You have moved to " + currentRoom.getName());
                }
            } else if (userCommand.equalsIgnoreCase("go west") || userCommand.equalsIgnoreCase("w")) {
                System.out.println("Going west...");
                if(currentRoom.getWest() == null){
                    System.out.println("You cannot go this way... Try again");
                } else {
                    currentRoom = currentRoom.getWest();
                    System.out.println("You have moved to " + currentRoom.getName());
                }
            } else if(userCommand.equalsIgnoreCase("exit")){
                System.out.println("You have exited the program");
                keepRunning = false;
            }else if(userCommand.equalsIgnoreCase("look")){
                System.out.println("Looking around the room...");
                System.out.println(currentRoom);
            } else if(userCommand.equalsIgnoreCase("help")){
                System.out.println("Commands:\ngo north - To go north\ngo south - To go south\ngo east - To go east" +
                        "\ngo west - To go west\nlook - To look around current room\nhelp - To view commands\nexit - to exit the game");
            } else{
                System.out.println("Invalid option");
            }

        }

    }
}
