import java.util.ArrayList;

public class Room {
    private String name;
    private String description;
    private Room south,east,west,north;
    private ArrayList<Item> itemList;
    private ArrayList<Food> foodList;
    private ArrayList<Enemy> enemyList;

    // Denne klasse er til at lave de specifikke rum og give dem et navn og en description
    public Room(String name, String description){
        this.name = name;
        this.description = description;
        this.itemList = new ArrayList<Item>(); // Initialiserer som en tom liste
        this.enemyList = new ArrayList<Enemy>();
    }

    // Getter metode til alle instans variabler
    public String getName(){
        return name;
    }

    public String getDescription(){
        return description;
    }

    public Room getNorth(){
        return north;
    }

    public Room getSouth(){
        return south;
    }

    public Room getEast(){
        return east;
    }

    public Room getWest(){
        return west;
    }

    // Setter metode til alle instans variabler.
    public void setName(String name){
        this.name = name;
    }

    public void setSouth(Room south){
        this.south = south;
    }

    public void setEast(Room east){
        this.east = east;
    }

    public void setWest(Room west){
        this.west = west;
    }

    public void setNorth(Room north){
        this.north = north;
    }

    public void addItem(Item item){
        itemList.add(item);
    }

    public void addEnemy(Enemy enemy){
        enemyList.add(enemy);
    }

    public void removeEnemy(Enemy enemy){
        enemyList.remove(enemy);
    }


    public ArrayList<Item> getItemList(){
        return itemList;
    }

    public int totalItemCounter(){
        String printresult = "";
        int itemCounter = 0;
        for (Item item : itemList){
            itemCounter += 1;
        }
        return itemCounter;
    }


    public int enemyCounter(){
        Room room;
        int enemyCounter = 0;
        for (Enemy enemy : enemyList){
            enemyCounter++;
        }
        return enemyCounter;
    }

    public ArrayList<Enemy> getEnemyList() {
        return enemyList;
    }

    public void setEnemyList(ArrayList<Enemy> enemyList) {
        this.enemyList = enemyList;
    }


    public void displayEnemies(){
        String printresult = "";
        int enemyCounter = 1;
        int i = 0;
        if (enemyList.isEmpty()){
            printresult = "\nThere are no enemies in this room";
        } else {
            printresult += "\nEnemies in this room:\n";
            for (Enemy enemy : enemyList) {
                printresult += enemyCounter + ": " + "Name: " + enemyList.get(i).toString() + " --- Health: " + enemyList.get(i).getEnemyHealth();
                enemyCounter += 1;
                i++;
            }
        }
        System.out.println(printresult);

    }


    public String displayItems(){
        String printresult = "";
        int itemCounter = 1;
        int i = 0;
        if (itemList.isEmpty()){
            printresult = "There are no items in this room";
        }
        for (Item item : itemList){
            printresult += "\n" + itemCounter + ": " + itemList.get(i).toString();
            itemCounter += 1;
            i++;
        }
        return printresult;
    }

    //Metode til at tjekke om playeren er i samme rum som det item han prøver at tage - bruger findItem metoden
    public Item findItem(String searchForItemName){
        for (Item item : itemList) {
            if (item.getName().equalsIgnoreCase(searchForItemName)) {
                return item;
            }
        }
        System.out.println("The item you are searching for: " + searchForItemName + " , does not exist in here.");
        return null;
    }

    // To string
    public String toString() {
        return name + " " + description;
    }
}