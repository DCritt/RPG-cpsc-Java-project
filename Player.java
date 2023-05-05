import java.util.ArrayList;

public class Player {
    private ArrayList<Book> books;
    private ArrayList<Bat> bats;
    private ArrayList<Key> keys;

    //constructor for player class
    public Player() {
        books = new ArrayList<Book>();
        bats = new ArrayList<Bat>();
        keys = new ArrayList<Key>();
    }

    //method that lists all items that the user can drop
    public void listDrops() {
        if (books.size() > 0 || bats.size() > 0 || keys.size() > 0) {
            String str = "";
            System.out.println("Drop: ");
            if (books.size() > 0) {
                str += "book\n";
            }
            if (bats.size() > 0) {
                str += "bat\n";
            }
            if (keys.size() > 0) {
                str += "key\n";
            }
            System.out.print(str + "\n");
        }
    }

    //method that lists all of the objects the user can read
    public void listRead() {
        if (books.size() > 0) {
            String str = "";
            System.out.println("Read: ");
            if (books.size() > 0) {
                str += "book\n";
            }
            System.out.print(str + "\n");
        }
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

    //method that tests if the bats ArrayList is empty
    public boolean emptyBat() {
        if (!(bats.size() > 0)) {
            return false;
        }
        else {
            return true;
        }
    }

    //method that tests if the keys ArrayList is empty
    public boolean emptyKey() {
        if (!(keys.size() > 0)) {
            return false;
        }
        else {
            return true;
        }
    }

    //method that adds a book object to an ArrayList
    public void addBook(Book book) {
        books.add(book);
    }

    //method that adds a bat object to an ArrayList
    public void addBat(Bat bat) {
        bats.add(bat);
    }

    //method that adds a key object to an ArrayList
    public void addKey(Key key) {
        keys.add(key);
    }

    //method that returns the book the user is holding and removes it from the ArrayList
    public Book getBook() {
        Book book1 = books.get(0);
        books.clear();
        return book1;
    }

    //method that returns the bat the user is holding and removes it from the ArrayList
    public Bat getBat() {
        Bat bat1 = bats.get(0);
        bats.clear();
        return bat1;
    }

    //method that returns the key the user is holding and removes it from the ArrayList
    public Key getKey() {
        Key key1 = keys.get(0);
        keys.clear();
        return key1;
    }

    //method that reads the contents of the book the user is holding
    public void readBook() {
        if (books.size() > 0) {
            books.get(0).readBook();
        }
        else {
            System.out.println("You aren't holding a book idiot!!!");
        }
    }
}
