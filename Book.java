public abstract class Book {
    private String title;
    private String author;
    private String isbn;
    private boolean isBorrowed;

    public Book(String title, String author, String isbn) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.isBorrowed = false;
    }

    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public String getIsbn() { return isbn; }
    public boolean isBorrowed() { return isBorrowed; }

    public void borrow() {
        if (isBorrowed) throw new RuntimeException("Book is already borrowed");
        isBorrowed = true;
    }

    public void returnBook() {
        if (!isBorrowed) throw new RuntimeException("Book is not currently borrowed");
        isBorrowed = false;
    }

    public abstract String getType();

    @Override
    public String toString() {
        return title + " - " + author + " (ISBN: " + isbn + ")";
    }
}

