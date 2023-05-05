import java.util.ArrayList;

public class Room
{
    private String name;
    private String description;
    private String repeatLine;
    private boolean first = true;
    private ArrayList<String> exits = new ArrayList<String>();
    private ArrayList<Book> books = new ArrayList<Book>();
    private ArrayList<Bat> bats = new ArrayList<Bat>();
    private ArrayList<Key> keys = new ArrayList<Key>();
    
    /**
     * Initialize a room
     * @param name the name of the room
     * @param description the description of the room
     */
    public Room(String name, String description, String repeatLine)
    {
        this.name = name;
        this.description = description;
        this.repeatLine = repeatLine;
    }
    /* Generate getters and setters for the naems and descriptions */
    
    /**
     * Adds an exit to the room
     * @param exit room name of the exit to be added to the room
     */
    public void addExit(String exit)
    {
        this.exits.add(exit);
    }

    //method that adds a book to an ArrayList
    public void addBook(Book book) {
        books.add(book);
    }

    //method that adds a bat to an ArrayList
    public void addBat(Bat bat) {
        bats.add(bat);
    }

    //method that adds a key to an ArrayList
    public void addKey(Key key) {
        keys.add(key);
    }

    //method that returns and removes the bat object from the ArrayList
    public Bat getBat() {
        Bat bat1 = bats.get(0);
        bats.clear();
        return bat1;
    }

    //method that returns and removes the book object from the ArrayList
    public Book getBook() {
        Book book1 = books.get(0);
        books.clear();
        return book1;
    }

    //method that returns and removes the key object from the ArrayList
    public Key getKey() {
        Key key1 = keys.get(0);
        keys.clear();
        return key1;
    }

    //method that tests if the books ArrayList is empty
    public boolean emptyBook() {
        if (!(books.size() > 0)) {
            return false;
        }
        else {
            return true;
        }
    }

    //method that tests if the bat ArrayList is empty
    public boolean emptyBat() {
        if (!(bats.size() > 0)) {
            return false;
        }
        else {
            return true;
        }
    }

    //method that tests if the key ArrayList is empty
    public boolean emptyKey() {
        if (!(keys.size() > 0)) {
            return false;
        }
        else {
            return true;
        }
    }

    /**
     * List all of the rooms as a string
     * @return returns all of the names of the rooms on new lines
     */
    public String listExits()
    {
        String str = "";
        System.out.println("");
        System.out.println("GoTo: ");
        for (String s: exits) {
            str += s + "\n";
        }
        return str;
    }

    //method that lists all of the items that the user can pick up in the current room
    public String listItems() {
        if (books.size() > 0 || bats.size() > 0 || keys.size() > 0) {
            String str = "";
            System.out.println("\nPickup: ");
            if (books.size() > 0) {
                str += "book\n";
            }
            if (bats.size() > 0) {
                str += "bat\n";
            }
            if (keys.size() > 0) {
                str += "key\n";
            }
            return str;
        }
        else {
            return "";
        }
    }

    /**
     * Generates a string representation of the room using the name and description and lists all of the exits.
     */
    public String toString()
    {
        String str = "";
        System.out.println("");
        if (first) {
            str = this.name + ": " + this.description;
            first = false;
        }
        else {
            str = this.name + ": " + this.repeatLine;
        }
        return str;
    }

    //returns the name of the room
    public String getName() {
        return this.name;
    }

    //tests to see if the inputed room in valid
    public boolean testCurr(String curr) {
        boolean boo = false;
        for (String s: exits) {
            if (s.equals(curr)) {
                boo = true;
            }
        }
        return boo;
    }
}
