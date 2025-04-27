import java.util.ArrayList;
import java.util.List;

public class LibraryService {
    private List<Book> books = new ArrayList<>();
    private List<Borrower> borrowers = new ArrayList<>();

    public void addBook(Book book) {
        books.add(book);
    }

    public void addBorrower(Borrower borrower) {
        borrowers.add(borrower);
    }

    public Book findBookByTitle(String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                return book;
            }
        }
        return null;
    }

    public Borrower findBorrowerById(String studentId) {
        for (Borrower borrower : borrowers) {
            if (borrower.getStudentId().equals(studentId)) {
                return borrower;
            }
        }
        return null;
    }

    public boolean borrowBook(String studentId, String title) {
        Book book = findBookByTitle(title);
        Borrower borrower = findBorrowerById(studentId);

        if (book != null && borrower != null && !book.isBorrowed()) {
            book.borrow();
            borrower.borrowBook(book);
            return true;
        }
        return false;
    }

    public boolean returnBook(String studentId, String title) {
        Borrower borrower = findBorrowerById(studentId);
        if (borrower != null) {
            for (Book book : borrower.getBorrowedBooks()) {
                if (book.getTitle().equalsIgnoreCase(title)) {
                    book.returnBook();
                    borrower.returnBook(book);
                    return true;
                }
            }
        }
        return false;
    }
}

