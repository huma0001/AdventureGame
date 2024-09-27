public class Map {
    public Room roomCreator(){
        // Rooms
        Room room1 = new Room("Room 1", "has no distinct features, except two doors");
        Room room2 = new Room("Room 2", "a very weird looking painting on the wall, it has two doors.");
        Room room3 = new Room("Room 3", "has no distinct features, except two doors");
        Room room4 = new Room("Room 4", "Has a very weird smell, and two doors");
        Room room5 = new Room("Room 5", "has a big golden chest and one door");
        Room room6 = new Room("Room 6", "has no distinct features, except two doors");
        Room room7 = new Room("Room 7", "has a cat in the corner, it looks scared - it also has two doors");
        Room room8 = new Room("Room 8", "has no distinct features but it has an extra door to choose from - three doors in total");
        Room room9 = new Room("Room 9", "has no distinct features, except two doors");


        // Set directions for room 1
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


        return room1;
    }
}
