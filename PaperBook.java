public class PaperBook extends Book {
    private int pages;
    
    public PaperBook(String title, String author, String isbn, int pages) {
        super(title, author, isbn);
        this.pages = pages;
    }
    
    public int getPages() { return pages; }
    
    @Override
    public String getType() { return "ورقي"; }
    
    @Override
    public String toString() {
        return super.toString() + " - " + pages + " صفحة (" + getType() + ")";
    }
}