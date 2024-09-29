public class Player {
    private Room currentRoom;
    private Player player1;

    public Player(Room roomPlayerSpawn){
        this.currentRoom = roomPlayerSpawn;
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
}
