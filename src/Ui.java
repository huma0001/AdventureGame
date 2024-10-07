import java.util.Scanner;

public class Ui {
    private Room currentRoom;
    private Map map;


    public void introduktion(){
        // Introduktion
        System.out.println("\nWelcome to THE-ADVENTURE-GAME!");
        System.out.println("This game is an advnture game - it has 9 rooms that you can explore by using specific commands");

        Map map1 = new Map();

        // Her bliver rumene dannet og spawn room'et bliver sat til room1 via. Map klassen, da roomCreator returnerer room1
        Room roomSpawn = map1.roomCreator();

        currentRoom = roomSpawn;

        // Introduktion
        System.out.println("\nSpawn location: " + currentRoom.getName() + currentRoom.getDescription() + "\n");
        System.out.println("What would you like to do?");
        System.out.println("---Type help to view the possible commands---");


    }

}