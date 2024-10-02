import java.util.ArrayList;

public class Player {
    private Room currentRoom;
    private Player player1;
    private ArrayList<Item> playerInventory;

    public Player(Room roomPlayerSpawn){
        this.currentRoom = roomPlayerSpawn;
        this.playerInventory = new ArrayList<Item>(); //Jeg initlaiserer den så jeg kan bruge den til f.eks. tilføje items til listen
    }

    public Room getCurrentRoom(){
        return currentRoom;
    }

    // Denne metode tillader et String fra brugeren og vi har lavet et switch case ved brug af advanced switch
    // Vi har lavet nextRoom af typen Room, når vi laver det op på denne måde vil det sige at "nextRoom" kommer til at have værdien af vores resultat fra switch
    public void movePlayer(String userInput){
        Room nextRoom = switch (userInput.toLowerCase()){
            case "go north", "n" -> currentRoom.getNorth();
            case "go south", "s" -> currentRoom.getSouth();
            case "go west", "w" -> currentRoom.getWest();
            case "go east", "e" -> currentRoom.getEast();
            default -> null;
        };


        // Her tjekkes der om nextRoom har værdien null, altså har ingen døre/er tom. Vi har jo allerede defineret de værelser der giver null
        // Så der er indforstået her, vi skal bare sige hvis det næste værelse er null, så print ikk gå ind, ellers bliver vores currentRoom = det næste rum vi vil prøve at bevæge os i (nextRoom)
        if (nextRoom == null){
            System.out.println("You cannot go this way - Try another direction");
        } else {
            currentRoom = nextRoom;
            System.out.println("You have moved to " + currentRoom.getName());
        }
    }

    public ArrayList<Item> getPlayerInventory(){
        return playerInventory;
    }

    // Har lavet alle de her 4 metoder til at overholde SRP, jeg overvejede at lave 2 metoder, 1 metode til at fjerne fra inventory samtidig med den tilføj til rummet og den anden modsat, men tænkte 4 var bedre for at følge SRP
    public void addToPlayerInventory(Item item){
        playerInventory.add(item);
    }


    public void removeFromPlayerInventory(Item item){
    playerInventory.remove(item);
    }

    public void removeItemFromRoom(Item item){
        currentRoom.getItemList().remove(item);
    }


    public void addItemToRoom(Item item){
        currentRoom.getItemList().add(item);
    }

    public void viewInventory(){
        int itemCounter = 0;
        int itemNumber = 1;
        for (Item item : playerInventory){
            System.out.println(itemNumber + ": " +item);
            itemCounter++;
            itemNumber++;
        }
        System.out.println("You have a total of " + itemCounter + " item(s) in your inventory");
    }



}