import java.util.Scanner;

// Controller klasse
public class AdventureGameController {

    public void startGame() {
        Scanner input = new Scanner(System.in);

        // Vi laver et nyt map da vi skal bruge map1.roomCreator til at lave rummene, det er en metode i Map klassen.
        Map map1 = new Map();
        String userCommand = null;

        // Her bliver rumene dannet og spawn room'et bliver sat til room1 via. Map klassen, da roomCreator returnerer room1
        Room roomSpawn = map1.roomCreator();

        //Creating enemy weapons
        Weapon enemyWeapon1 = new MeleeWeapon("Hammer", "a Big hammer" , 35);
        //Creating enemies
        Enemy enemy1 = new Enemy("Bob", " Big and scary", 100, enemyWeapon1);

        Player player1 = new Player(roomSpawn);

        // While loop for at holde programmet kørende indtil man skriver "exit"
        boolean keepRunning = true;

        String[] splitWord;

        while (keepRunning && !player1.playerDead()) {
            splitWord = input.nextLine().toLowerCase().split(" ");
            userCommand = splitWord[0];
                switch (userCommand) {
                    case "go" ->{
                        if (splitWord.length > 1) {
                            player1.movePlayer(splitWord[1]);
                        } else {
                            System.out.println("Where would you like to go?");
                        }
                    }
                    case "help", "h" -> printHelp();
                    case "eat", "e" ->{
                        if (splitWord.length>1){
                            player1.eatsFood(splitWord[1]);
                        } else{
                            System.out.println("What would you like to eat?");
                        }
                    }
                    case "look", "l" -> {
                        player1.lookRoom();
                        player1.getCurrentRoom().displayEnemies();
                    }
                    case "take", "t", "take " -> {
                        if (splitWord.length > 1) {
                            player1.takeItem(splitWord[1]);
                        } else {
                            System.out.println("Please type 'take' followed by the item you wish to take\n");
                        }
                    }
                    case "drop", "d", "drop " -> {
                        if (splitWord.length > 1) {
                            player1.dropItem(splitWord[1]);
                        } else {
                            System.out.println("Please type 'drop' followed by the item you wish to drop\n");
                        }
                    }
                    case "equip" ->{
                        if (splitWord.length > 1){
                            player1.equipWeapon(splitWord[1]);
                        } else {
                            System.out.println("Please type 'equip' followed by the weapon you wish to equip \n");
                        }
                    }
                    case "attack" ->{
                        if (splitWord.length > 1) {
                            player1.fireWeapon(splitWord[1]);
                        } else {
                            player1.fireWeapon(splitWord[0]);
                        }
                        if (player1.getPlayerCurrentWeapon() != null) {
                            enemy1.enemyHitPlayer(player1);
                        }
                    }
                    case "inventory", "i" -> player1.viewInventory();
                    case "health", "hp" -> player1.printHealth();
                    case "exit", "x" -> {
                        System.out.println("Exiting the program...");
                        keepRunning = false;
                    }
                    default -> System.out.println("Invalid command - Type 'help' to view commands");
                }
        }
        System.out.println("Game is over.");
    }


    public void printHelp() {
        System.out.println("Type 'help' - to view commands");
        System.out.println("Type 'go (direction)' - to go a specific direction \nDirections: South, East, West and North");
        System.out.println("Type 'look' - to look in the current room you are in");
        System.out.println("Type 'take' - to take items");
        System.out.println("Type 'drop' - to drop items");
        System.out.println("Type 'equip' - to equip items");
        System.out.println("Type 'attack' - to attack with your currently EQUIPPED weapon");
        System.out.println("Type 'health' - to view your current health");
        System.out.println("Type 'inventory' - to view your inventory and current equipped weapon");
        System.out.println("Type 'exit' - to exit the game");
    }
}