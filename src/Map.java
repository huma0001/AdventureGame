import java.util.ArrayList;
import java.util.Random;
public class Map {

    /* Kan ikke få den her kode til at virke endnu
    public ArrayList<Item> itemCreator(){
        ArrayList<Item> itemList = new ArrayList<Item>();
        Item item1 = new Item("Sword", "Long and rusty");
        Item item2 = new Item("Lamp", "Old and worn");
        Item item3 = new Item("Hat", "Black and dusty");

        itemList.add(item1);
        itemList.add(item1);
        itemList.add(item1);


        return itemList;
    }
     */

    public Room roomCreator(){
        Map map = new Map();

        Item item1 = new Item("A Sword", ", It's long and rusty");
        Item item2 = new Item("A Lamp", ", It's old and worn");
        Item item3 = new Item("A Hat", ", It's black and dusty");

        Item item4 = new Item("A Gun", ", It's half broken");
        Item item5 = new Item("A Shoe", ", It's missing the bottom half ");
        Item item6 = new Item("A Stick", ", It's a perfectly intact stick");

        Item item7 = new Item("A Letter",", It has the words 'Hello' written on it");
        Item item8 = new Item("A rock", ", It's shaped like a razor ");
        Item item9 = new Item("A Stick", ", It's broken in half");

        Item item10 = new Item("A Gold coin",", It's shiny");
        Item item11 = new Item("A shield", ", The wood looks moldy");
        Item item12 = new Item("A scroll", ", The words are unreadable");


        // Rooms bliver lavet
        Room room1 = new Room("\n---Room 1---", "\nThis room has no distinct features - It has two doors");
        room1.addItem(item1);
        room1.addItem(item2);
        Room room2 = new Room("\n---Room 2---", "\nThis room has a very weird looking painting on the wall - it has two doors.");
        room2.addItem(item3);
        Room room3 = new Room("\n---Room 3---", "\nThis room has no distinct features - it has two doors");
        room3.addItem(item4);
        Room room4 = new Room("\n---Room 4---", "\nThis room has a very weird smell - it has two doors");
        room4.addItem(item5);
        room4.addItem(item6);
        Room room5 = new Room("\n---Room 5---", "\nThis room has a big golden chest - it has one door");
        room5.addItem(item7);
        Room room6 = new Room("\n---Room 6---", "\nThis room has no distinct features - It has two doors");
        room6.addItem(item8);
        room6.addItem(item9);
        Room room7 = new Room("\n---Room 7---", "\nThis room has a cat in the corner, it looks scared - it has two doors");
        Room room8 = new Room("\n---Room 8---", "\nThis room has no distinct features but it has an extra door to choose from - It has three doors in total");
        Room room9 = new Room("\n---Room 9---", "\nThis room has no distinct features but a few items - It has two doors");
        room9.addItem(item10);
        room9.addItem(item11);
        room9.addItem(item12);


        // Set directions for room 1 - Her definerer vi hvor brugeren kan gå
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

        // Vi returnerer room 1 når vi kalder roomCreator(), da vi gerne vil returnere hvor brugeren starter spillet
        return room1;

    }

}