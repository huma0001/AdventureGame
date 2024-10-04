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
    public boolean movePlayer(String direction){
        Room nextRoom = null;
        switch (direction){
            case "go north", "n", "north", "go n" ->  nextRoom = currentRoom.getNorth();
            case "go south", "s", "south", "go s"  -> nextRoom = currentRoom.getSouth();
            case "go west", "w", "west", "go w" -> nextRoom = currentRoom.getWest();
            case "go east", "e", "east", "go e" -> nextRoom = currentRoom.getEast();
        }

        // Her tjekkes der om nextRoom har værdien null, altså har ingen døre/er tom. Vi har jo allerede defineret de værelser der giver null
        // Så der er indforstået her, vi skal bare sige hvis det næste værelse er null, så print ikk gå ind, ellers bliver vores currentRoom = det næste rum vi vil prøve at bevæge os i (nextRoom)
        if (nextRoom == null){
            System.out.println("You cannot go this way - Try another direction");
            return false;
        } else {
            currentRoom = nextRoom;
            System.out.println("You have moved to " + currentRoom.getName());
            return true;
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

    // Player take item method
    public void takeItem(String searchForItem){
        if(currentRoom.totalItemCounter() >= 1){
            Item itemFinder = currentRoom.findItem(searchForItem);
            if (itemFinder != null) {
                addToPlayerInventory(itemFinder);
                removeItemFromRoom(itemFinder);
                System.out.println("You have added a " + "'" + itemFinder.getName() + "´" + " to your inventory." + "\ntype 'inventory' to view your updated inventory");
            }
        } else {
            System.out.println("\nThere's nothing to pick up\n");
        }
    }

    // Player drop item method
    public void dropItem(String searchForItem){
        if(!getPlayerInventory().isEmpty()){
           viewInventory();
            Item itemFinderDrop = findItem2(searchForItem);
            if (itemFinderDrop != null) {
                addItemToRoom(itemFinderDrop);
                removeFromPlayerInventory(itemFinderDrop);
                System.out.println("\nYou have removed: " + itemFinderDrop.getName() + " from your inventory. \ntype 'inventory' to view your updated inventory");
            }
        } else {
            System.out.println("\nYou have nothing in your inventory to drop\n");
        }
    }

    public void lookRoom(){
        System.out.println("Looking around the room...\n");
        System.out.println(currentRoom.getDescription());
        if(!currentRoom.getItemList().isEmpty()){
            System.out.println("\nTotal item(s) in this room: " + currentRoom.totalItemCounter() + currentRoom.displayItems());
        } else {
            System.out.println(currentRoom.displayItems());
        }
    }

    public Item findItem2(String searchForItemName){
        for (Item item : playerInventory) {
            if (item.getName().equalsIgnoreCase(searchForItemName)) {
                return item;
            }
        }
        System.out.println("\nThe item you are searching for: " + searchForItemName + " , does not exist in here.\n");
        return null;
    }
}