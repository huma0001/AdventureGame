import java.util.ArrayList;
import java.util.Random;
public class Map {

    public Room roomCreator(){
        Map map = new Map();

        //Creating all weapons
        Item weapon1 = new MeleeWeapon("Bat", ", It's a wooden bat - wonder if it can be used as a weapon?", 25);
        Item weapon2 = new RangedWeapon("Pistol", ", It's a pistol that looks beat up, might still work...", 2, 65);
        Item weapon3 = new MeleeWeapon("Shovel", ", It's a shovel, looks untouched and ready to be used as a defensive weapon...", 15);
        Item weapon4 = new MeleeWeapon("Brick", ", It's a half broken brick, looks brittle but can be probably be used as a weapon before it decays...", 10);
        Item weapon5 = new MeleeWeapon("Sword", ", It's long and rusty - Perfect for self-defense", 45);

        //Creating all foods
        Item food1 = new Food("Apple", ", It's green and looks tasty", 20);
        Item food2 = new Food("Banana", ", It's looking real ripe, but has a hole with a worm sticking out of it - maybe it wont be so bad?", -30);
        Item food3 = new Food("Sugar", ", It's an old-fashioned looking can of Sugar - its a half full" , 15);
        Item food4 = new Food("Dead-chicken", ", It's a body of a dead chicken, looks like the bugs are enjoying it as a meal - surely i can too?", (-75));
        Item food5 = new Food("Watermelon", ", It's a whole, untouched watermelon. It looks perfectly fine" , 75);

        // Creating all items
        Item item2 = new Item("Lamp", ", It's old and worn");
        Item item3 = new Item("Hat", ", It's black and dusty");

        Item item5 = new Item("Shoe", ", It's missing the bottom half ");
        Item item6 = new Item("Stick", ", It's a perfectly intact stick");

        Item item7 = new Item("Letter",", It has the words 'Hello' written on it");
        Item item8 = new Item("rock", ", It's shaped like a razor ");
        Item item9 = new Item("Stick", ", It's broken in half");

        Item item10 = new Item("GoldCoin",", It's shiny");
        Item item11 = new Item("shield", ", The wood looks moldy");
        Item item12 = new Item("scroll", ", The words are unreadable");


        // Creating all rooms
        Room room1 = new Room("\n---Stone Pillar Hall---", "\nA big, open space with a tall stone pillar at the center. Large rocks are scattered around, and the ceiling is full of sharp, hanging stones. \nTwo exits are visible: one through a narrow archway and another through a rough, uneven doorway leading deeper into the cave.");
        room1.addItem(weapon5);
        room1.addItem(item2);
        room1.addItem(food1);

        Room room2 = new Room("\n---Painted Wall Room---", "\nThis room has a very weird-looking painting on the wall. \nThere are two doorways here, one through a low, stone arch and another leading back to where you came from.");
        room2.addItem(item3);
        room2.addItem(food2);
        Room room3 = new Room("\n---Silent Chamber---", "\nThis room has no distinct features, with bare rock walls and a cold draft. \nA small tunnel slopes downward ahead, while a rough-hewn doorway lies in the opposite direction.");
        room3.addItem(weapon2);

        Room room4 = new Room("\n---Musty Hollow---", "\nThe air here smells strange and musty, making you uncomfortable. \nThere’s a cracked opening in the rock ahead, and a wide stone arch leading back to the previous room.");
        room4.addItem(item5);
        room4.addItem(item6);
        room4.addItem(weapon1);


        Room room5 = new Room("\n---Golden Chest Room---", "\nA large golden chest dominates the center of this room. \nA heavy wooden door, slightly ajar, invites you to continue forward.\n");
        room5.addItem(item7);
        room5.addItem(food5);
        Room room6 = new Room("\n---Sharp Rock Chamber---", "\nA cold, bare room with sharp rocks poking out of the walls. \nAn open passage lies before you, and a jagged tunnel leads further down.");
        room6.addItem(item8);
        room6.addItem(item9);

        Room room7 = new Room("\n---Cat's Refuge---", "\nA scared cat huddles in the corner, watching your every move. \nA carved stone doorway stands ahead, while a narrow hallway stretches out in another direction");
        room7.addItem(food4);
        room7.addItem(weapon4);

        Room room8 = new Room("\n---Three-Way Cavern---", "\nThis room offers no distinct features but has several exits. \nA plain stone door lies before you, a small crevice opens between the rocks, and a narrow corridor leads back to where you came from");
        room8.addItem(food3);
        room8.addItem(weapon3);

        Room room9 = new Room("\n---Item Vault---", "\nA few scattered items lie on the ground. \nOne path curves around the stone wall, while a tight opening in the rock leads into another section of the cave.");
        room9.addItem(item10);
        room9.addItem(item11);
        room9.addItem(item12);



        // Set directions for room 1 - Her definerer vi hvor brugeren kan gå
        room1.setEast(room2);
        room1.setSouth(room4);


        // Set directions for room 2
        room2.setEast(room3);
        room2.setWest(room1);

        // Set directions for room 3
        room3.setSouth(room6);
        room3.setWest(room2);

        // Set directions for room 4
        room4.setNorth(room1);
        room4.setSouth(room7);

        // Set directions for room 5
        room5.setSouth(room8);

        // Set directions for room 6
        room6.setNorth(room3);
        room6.setSouth(room9);

        // Set directions for room 7
        room7.setNorth(room4);
        room7.setEast(room8);

        // Set directions for room 8
        room8.setNorth(room5);
        room8.setEast(room9);
        room8.setWest(room7);

        // Set directions for room 9
        room9.setNorth(room6);
        room9.setWest(room8);

        // Vi returnerer room 1 når vi kalder roomCreator(), da vi gerne vil returnere hvor brugeren starter spillet
        return room1;

    }

}