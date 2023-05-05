import java.util.HashMap;

public class AdventureMap
{
    HashMap<String, Room> map;
    Player player = new Player();
    boolean evs = true;
    boolean bradys = true;

    //constructor for AdventureMap
    public AdventureMap()
    {
        map = new HashMap<>();
    }

    /**
     * Adds a room to the AdventureMap
     * The name associated in the room must be lowercase
     * @param room Room to be added to the AdventureMap
     */
    public void addRoom(Room room)
    {
        map.put(room.getName(), room);
    }

    /**
     * Returns the Room assocaited with the string name given
     * @param roomName the name of the room to be returned, room name must be valid
     * @return the Room object assocaited with the name, the name will be in lowercase
     */
    public Room getRoom(String roomName)
    {
       return map.get(roomName);
    }

    //method that adds a book object to the players inventory
    public void getBook(String roomName) {
        if (map.get(roomName).emptyBook()) {
            player.addBook(map.get(roomName).getBook());
        }

        //if there is no book
        else {
            System.out.println("There is no book in the location idiot!!!");
        }
    }

    //method that adds a bat object to the players inventory
    public void getBat(String roomName) {
        if (map.get(roomName).emptyBat()) {
            player.addBat(map.get(roomName).getBat());
        }

        //if there is no bat
        else {
            System.out.println("There is no bat in the location idiot!!!");
        }
    }

    //method that adds a key object to the players inventory
    public void getKey(String roomName) {
        if (map.get(roomName).emptyKey()) {
            player.addKey(map.get(roomName).getKey());
        }

        //if there is no key
        else {
            System.out.println("There is no Key in the location idiot!!!");
        }
    }

    //method that prints the contents of the book
    public void readBook() {
        player.readBook();
    }

    //method that drops the book object the user has
    public void dropBook(String roomName) {
        if (player.emptyBook()) {
            map.get(roomName).addBook(player.getBook());
        }

        //if the user doesnt have a book
        else {
            System.out.println("You aren't holding a book idiot!!!");
        }
    }

    //method that drops the bat object the user has
    public void dropBat(String roomName) {
        if (player.emptyBat()) {
            map.get(roomName).addBat(player.getBat());
        }

        //if the user doesnt have a bat
        else {
            System.out.println("You aren't holding a bat idiot!!!");
        }
    }

    //method that drops the key object the user has
    public void dropKey(String roomName) {
        if (player.emptyKey()) {
            map.get(roomName).addKey(player.getKey());
        }

        //if the user doesnt have a key
        else {
            System.out.println("You aren't holding a key idiot!!!");
        }
    }

    //method that opens the door in the users locatin
    public void openDoor(String roomName) {

        //if the door is Big Ev's
        if (roomName.equals("Big_Ev's")) {

            //if the door is locked and the player has the key
            if (player.emptyKey() && evs) {
                evs = false;
                map.get(roomName).addExit("Inside");
                System.out.println("Door Unlocked!!! Now go beat Big Ev!!!");
            }

            //if the door is locked but the player doesn't have a key
            else if (evs) {
                System.out.println("You need a key to open the door you idiot!!!");
            }

            //if the door is already open
            else {
                System.out.println("The door is already open you idiot!!!");
            }
        }

        //if the door is Big Brady's
        else if (roomName.equals("Big_Brady's")) {

            //if the door is closed
            if (bradys) {
                bradys = false;
                map.get(roomName).addExit("Entrance");
                System.out.println("The door is open!");
            }

            //if the door is open
            else {
                System.out.println("The door is already open you idiot!!!");
            }
        }

        //if the user isn't in a room with a door
        else {
            System.out.println("\nThere isn't anything to open you idiot!!!");
        }
    }

    //method that lists all of the things the user can drop
    public void listDrops() {
        player.listDrops();
    }

    //method that lists all of the things the user can read
    public void listRead() {
        player.listRead();
    }

    //method that lists all of the things the user can open
    public void listOpen(String roomName) {
        if (roomName.equals("Big_Ev's") && evs) {
            System.out.println("Open: ");
            System.out.println("door\n");
        }
        else if (roomName.equals("Big_Brady's") && bradys) {
            System.out.println("Open: ");
            System.out.println("door\n");
        }
    }

    //tests if the user has a bat
    public boolean hasBat() {
        return (player.emptyBat());
    }

}
