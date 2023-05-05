public class Book {
    private String name = "";
    private String writing = "";
    
    //constructor that saves the name and contents of a book object
    public Book(String name, String writing) {
        this.name = name;
        this.writing = writing;
    }

    //method that reads the contents of the book
    public void readBook() {
        String str = "";
        str = this.name + ": " + this.writing;
        System.out.println(str);
    }


}
