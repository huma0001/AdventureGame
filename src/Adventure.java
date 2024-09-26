import java.util.Scanner;

public class Adventure {
    private Room currentRoom;

    public void startSpillet(){
        System.out.println("\nWelcome to THE-ADVENTURE-GAME!");
        System.out.println("This game is an advnture game - it has 9 rooms that you can explore by using specific commands");

        Scanner input = new Scanner(System.in);

        // Rooms
        Room room1 = new Room("Room 1", "has no distinct features, except two doors");
        Room room2 = new Room("Room 2", "a very weird looking painting on the wall, it has two doors.");
        Room room3 = new Room("Room 3", "has no distinct features, except two doors");
        Room room4 = new Room("Room 4", "Has a very weird smell, and two doors");
        Room room5 = new Room("Room 5", "has a big golden chest and one door");
        Room room6 = new Room("Room 6", "has no distinct features, except two doors");
        Room room7 = new Room("Room 7", "has a cat in the corner, it looks scared - it also has two doors");
        Room room8 = new Room("Room 8", "has no distinct features but it has an extra door to choose from - three doors in total");
        Room room9 = new Room("Room 9", "has no distinct features, except two doors");


        // Set directions for room 1
        room1.setNorth(null);
        room1.setEast(room2);
        room1.setSouth(room4);
        room1.setWest(null);

        // Set directions for room 2
        room2.setNorth(null);
        room2.setEast(room3);
        room2.setSouth(null);
        room2.setWest(room1);


        // Set directions for room 3
        room3.setNorth(null);
        room3.setEast(null);
        room3.setSouth(room6);
        room3.setWest(room2);

        // Set directions for room 4
        room4.setNorth(room1);
        room4.setEast(null);
        room4.setSouth(room7);
        room4.setWest(null);

        // Set directions for room 5
        room5.setNorth(null);
        room5.setEast(null);
        room5.setSouth(room8);
        room5.setWest(null);

        // Set directions for room 6
        room6.setNorth(room3);
        room6.setEast(null);
        room6.setSouth(room9);
        room6.setWest(null);

        // Set directions for room 7
        room7.setNorth(room4);
        room7.setEast(room8);
        room7.setSouth(null);
        room7.setWest(null);

        // Set directions for room 8
        room8.setNorth(room5);
        room8.setEast(room9);
        room8.setSouth(null);
        room8.setWest(room7);

        // Set directions for room 9
        room9.setNorth(room6);
        room9.setEast(null);
        room9.setSouth(null);
        room9.setWest(room8);



        System.out.println("\nSpawn location: Room 1");
        System.out.println("What would you like to do?");
        System.out.println("---Type help to view the possible commands---");



        String userCommand = null;

        currentRoom = room1;


        boolean keepRunning = true;

        while(keepRunning) {

            userCommand = input.nextLine();

            // If og else statements omkring directions
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
