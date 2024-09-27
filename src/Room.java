public class Room {
    private String name;
    private String description;
    private Room south,east,west,north;


    public Room(String name, String description){
        this.name = name;
        this.description = description;
    }


    // Getter metode til alle instans variabler
    public String getName(){
        return name;
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

    // To string
    public String toString() {
        return name + " " + description;
    }
}
