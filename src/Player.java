import java.util.ArrayList;

public class Player {
    private int playerHealth;
    private Room currentRoom;
    private ArrayList<Item> playerInventory;
    Weapon playerCurrentWeapon;

    public Player(Room roomPlayerSpawn) {
        playerHealth = 100;
        playerCurrentWeapon = null;
        this.currentRoom = roomPlayerSpawn;
        this.playerInventory = new ArrayList<Item>(); //Jeg initlaiserer den så jeg kan bruge den til f.eks. tilføje items til listen
    }

    public Room getCurrentRoom() {
        return currentRoom;
    }

    // Denne metode tillader et String fra brugeren og vi har lavet et switch case ved brug af advanced switch
    // Vi har lavet nextRoom af typen Room, når vi laver det op på denne måde vil det sige at "nextRoom" kommer til at have værdien af vores resultat fra switch
    public boolean movePlayer(String direction) {
        Room nextRoom = null;
        switch (direction) {
            case "go north", "n", "north", "go n" -> nextRoom = currentRoom.getNorth();
            case "go south", "s", "south", "go s" -> nextRoom = currentRoom.getSouth();
            case "go west", "w", "west", "go w" -> nextRoom = currentRoom.getWest();
            case "go east", "e", "east", "go e" -> nextRoom = currentRoom.getEast();
        }

        // Her tjekkes der om nextRoom har værdien null, altså har ingen døre/er tom. Vi har jo allerede defineret de værelser der giver null
        // Så der er indforstået her, vi skal bare sige hvis det næste værelse er null, så print ikk gå ind, ellers bliver vores currentRoom = det næste rum vi vil prøve at bevæge os i (nextRoom)
        if (nextRoom == null) {
            System.out.println("You cannot go this way - Try another direction");
            return false;
        } else {
            currentRoom = nextRoom;
            System.out.println("You have moved to " + currentRoom.getName());
            return true;
        }
    }

    public Weapon getPlayerCurrentWeapon(){
        return playerCurrentWeapon;
    }

    public void setPlayerCurrentWeapon(Weapon newWeapon){
        this.playerCurrentWeapon = newWeapon;
    }

    public int getPlayerHealth() {
        return playerHealth;
    }

    public void setPlayerHealth(int newPlayerHealth) {
        this.playerHealth = newPlayerHealth;
    }

    public ArrayList<Item> getPlayerInventory() {
        return playerInventory;
    }

    // Har lavet alle de her 4 metoder til at overholde SRP, jeg overvejede at lave 2 metoder, 1 metode til at fjerne fra inventory samtidig med den tilføj til rummet og den anden modsat, men tænkte 4 var bedre for at følge SRP
    public void addToPlayerInventory(Item item) {
        playerInventory.add(item);
    }


    public void removeFromPlayerInventory(Item item) {
        playerInventory.remove(item);
    }

    public void removeItemFromRoom(Item item) {
        currentRoom.getItemList().remove(item);
    }


    public void addItemToRoom(Item item) {
        currentRoom.getItemList().add(item);
    }

    public void viewInventory() {
        int itemCounter = 0;
        int itemNumber = 1;
        System.out.println("\n---Your inventory---");
        for (Item item : playerInventory) {
            System.out.println(itemNumber + ": " + item);
            itemCounter++;
            itemNumber++;
        }
        System.out.println("You have a total of " + itemCounter + " item(s) in your inventory\n");
    }

    // Player take item method
    public void takeItem(String searchForItem) {
        if (currentRoom.totalItemCounter() >= 1) {
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
    public void dropItem(String searchForItem) {
        if (!getPlayerInventory().isEmpty()) {
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


    public void lookRoom() {
        System.out.println("Looking around the room...\n");
        System.out.println(currentRoom.getDescription());
        if (!currentRoom.getItemList().isEmpty()) {
            System.out.println("\nTotal item(s) in this room: " + currentRoom.totalItemCounter() + currentRoom.displayItems());
        } else {
            System.out.println(currentRoom.displayItems());
        }
    }


    public Item findItem2(String searchForItemName) {
        for (Item item : playerInventory) {
            if (item.getName().equalsIgnoreCase(searchForItemName)) {
                return item;
            }
        }
        System.out.println("\nThe item you are searching for: " + searchForItemName + " , does not exist in here.\n");
        return null;
    }

    //Har ikke brugt enums, har ikke forstand på hvordan jeg overhovedet gøre det eller starter med det.
    public void eatsFood(String searchFoodName){
        // Tjekekr om inventory er tom
        if(!getPlayerInventory().isEmpty()){
            //Hvis den ikke er tom så skal vi lede efter et match ved brug af min metode der kigger i spillerens inventory
            Item foodFinder = findItem2(searchFoodName);

            // Hvis item ikke findes, stop her
            //Denne løsning blev jeg nødt til at lave da hvis jeg skrev "eat food" og jeg ikke havde maden i inventory ville den både sige maden ikke var spiselig og den ikke fandtes, men vil kun have den sagde maden ikke fandtes.
            if (foodFinder == null){
                return;
            }

            if (foodFinder instanceof Food){
                int playerHealth = getPlayerHealth();

                // Fik lidt hjælp her men essentielt det vi gør er vi caster vores foodFinder til typen  af "Food" så vi kan bruge metoder til at hjælpe os
                // Hvis vi ikke caster som sådan så ser det meget mærkeligt ud som min første kode, hvor jeg blev nødt til at skrive "((Food) foodFinder).getFoodHealthChange()" hver gang jeg ville få fat i "Food's" egenskaber
                Food foodItem = (Food) foodFinder;

                if (playerHealth < 100 || foodItem.getFoodHealthChange() < 0){
                    int healthBeforeEat = playerHealth;
                    removeFromPlayerInventory(foodFinder);

                    playerHealth += foodItem.getFoodHealthChange();

                    if (healthBeforeEat < playerHealth){
                        System.out.println("You ate something good!");
                    } else if (healthBeforeEat > playerHealth){
                        System.out.println("You ate something bad!");
                    }

                    System.out.println("You have eaten " + searchFoodName + " which was worth " + foodItem.getFoodHealthChange() +" health points.");


                    if (playerHealth > 100) {
                        playerHealth = 100;
                    }

                    if (playerHealth < 0) {
                        playerHealth = 0;
                    }

                    //Her opdaterer vi spillerens helbred ved at passe ind playerhealth som vi har oprettede i denne metode hvor spilleren spiser
                    setPlayerHealth(playerHealth);

                    System.out.println("Player's current HP: " + playerHealth);
                } else {
                    System.out.println("You character is at full health! --- You have not eaten the '" + searchFoodName + "'");

                }
            } else {
                System.out.println("This item: " + searchFoodName + ", is not edible");
            }
        } else {
            System.out.println("There is no food in your inventory to eat.");
        }

    }



    public void equipWeapon(String searchWeaponName){

        if (!playerInventory.isEmpty()){
            Item weaponFinder = findItem2(searchWeaponName);

            if (weaponFinder == null){
                return;
            }


            if (weaponFinder instanceof RangedWeapon){
                // Lavet for at kunne bruge weaponItem metoder
                Weapon weaponItem = (Weapon) weaponFinder;
                System.out.println("You have now equipped a long ranged weapon: '" + searchWeaponName + "'");
                // f.eks. det her er useless playerCurrentWeapon = weaponFinder; så istedet skriver jeg således:
                playerCurrentWeapon = weaponItem;
            } else if (weaponFinder instanceof  MeleeWeapon){
                System.out.println("You have now equipped a melee ranged weapon: '" + searchWeaponName + "'");
            } else {
                System.out.println("The item '" + searchWeaponName + "' is not a equipable weapon" );
            }




        } else {
            System.out.println("Your inventory is empty - there are no weapons to equip");
        }






    }

    public void fireWeapon() {
        if (getPlayerCurrentWeapon() instanceof RangedWeapon) {
            System.out.println("'" + playerCurrentWeapon.getName() + "' has been used");
            playerCurrentWeapon.useWeapon();
        } else if (getPlayerCurrentWeapon() instanceof MeleeWeapon) {
            System.out.println("'" + playerCurrentWeapon.getName() + "' has been used");
            playerCurrentWeapon.useWeapon();
        }
    }

}
