import java.util.ArrayList;

public class Room {
    private String name;
    private String description;
    private Room south,east,west,north;
    private ArrayList<Item> itemList;

    // Denne klasse er til at lave de specifikke rum og give dem et navn og en description
    public Room(String name, String description){
        this.name = name;
        this.description = description;
        this.itemList = new ArrayList<Item>(); // Initialiserer som en tom liste
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

    // To string
    public String toString() {
        return name + " " + description;
    }
}