import java.io.*;
import java.util.*;

class Book implements Serializable {
    
    public String bookTitle;
    public int bookPrice;
    public long bookId;

    public Book(String bookTitle, int bookPrice, long bookId) {
        this.bookTitle = bookTitle;
        this.bookPrice = bookPrice;
        this.bookId = bookId;
    }

    public String toString() {
        return "Book Title: " + bookTitle + "\nBook Price: " + bookPrice + "\nBook Id: " + bookId;
    }

    public String getTitle() {
        return bookTitle;
    }

    public int getPrice() {
        return bookPrice;
    }

}

public class Java3_6 {

    public static void storeBooks(List<Book> books, ObjectOutputStream oos) {
        
        try {

            oos = new ObjectOutputStream(new FileOutputStream("Fifth.dat"));

            for (Book b : books) {
                oos.writeObject(b);
            }

        }

        catch (Exception e) {
            System.out.println(e);
        }

        finally {
            
            try {
                oos.close();
            }

            catch (Exception e) {
                System.out.println(e);
            }

        }

    }

    public static List<Book> readBooks(ObjectInputStream ois) {

        List<Book> alreadyStoredBooks = new ArrayList<>();

        try {

            ois = new ObjectInputStream(new FileInputStream("Fifth.dat"));

            Book b = (Book) ois.readObject();

            while (true) {

                try {
                    alreadyStoredBooks.add(b);
                    b = (Book) ois.readObject();
                }
                
                catch (EOFException e) {
                    break;
                }

            }

        }

        catch (Exception e) {
            System.out.println(e);
        }

        finally {
            
            try {
                ois.close();
            }

            catch (Exception e) {
                System.out.println(e);
            }

        }

        return alreadyStoredBooks;
    }

    public static void print(List<Book> alreadyStoredBooks) {

        for (Book b : alreadyStoredBooks) {
            System.out.println(b);
            System.out.println();
        }

    }
    public static void search(List<Book> alreadyStoredBooks, String bookTitle) {

        for (Book b : alreadyStoredBooks) {
            
            if (b.getTitle().equals(bookTitle)) {

                System.out.println("Book Found!");
                return ;
            }

        }

        System.out.println("Book Not Found!");
        
    }

    public static void highestPrice(List<Book> alreadyStoredBooks) {

        int maxPrice = 0;
        Book maxPriceBook = null;

        for (Book b : alreadyStoredBooks) {
            
            if (b.getPrice() > maxPrice) {
                maxPriceBook = b;
            }

        }

        System.out.println("Details of Book with Highest Price: \n\n" + maxPriceBook + "\n");
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        List<Book> books = new ArrayList<>();
        
        Book b1 = new Book("FirstBook", 100, 2352123);
        books.add(b1);

        Book b2 = new Book("SecondBook", 200, 2352334);
        books.add(b2);

        Book b3 = new Book("ThirdBook", 300, 2352565);
        books.add(b3);

        Book b4 = new Book("FourthBook", 400, 2352366);
        books.add(b4);

        Book b5 = new Book("FifthBook", 500, 2352127);
        books.add(b5);

        Book b6 = new Book("SixthBook", 600, 2352128);
        books.add(b6);
                
        ObjectOutputStream oos = null;
        ObjectInputStream ois = null;

        System.out.println("\n\n- - - - Storing Books in File - - - -\n\n");
        storeBooks(books, oos);
        System.out.println("- - - - Books Stored Successfully - - - -\n\n");

        List<Book> alreadyStoredBooks = readBooks(ois);

        System.out.println("- - - - Printing All The Already Stored Books From File - - - -\n\n");
        print(alreadyStoredBooks);

        System.out.print("\n\nEnter the title of the book to search: ");
        String toSearchTitle = sc.nextLine().trim();

        System.out.println("\n\n- - - - Searching " + toSearchTitle+ " - - - -");
        search(alreadyStoredBooks, toSearchTitle);

        System.out.println("\n\n- - - - Getting the book with the highest price - - - -\n");
        highestPrice(alreadyStoredBooks);

        try {
            sc.close();
        }

        catch (Exception e) {
            System.out.println(e);
        }
    }
}