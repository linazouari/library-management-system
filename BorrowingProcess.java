import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class BorrowingProcess {
    private Book book;
    private Borrower borrower;  // تم التغيير من BorrowerClass إلى Borrower
    private LocalDate borrowDate;
    private LocalDate returnDate;
    private boolean isReturned;
    
    public BorrowingProcess(Book book, Borrower borrower) {  // تم تعديل البارامتر
        this.book = book;
        this.borrower = borrower;  // تم تصحيح المتغير هنا
        this.borrowDate = LocalDate.now();
        this.isReturned = false;
    }
    
    public Book getBook() { return book; }
    public Borrower getBorrower() { return borrower; }  // تم تعديل نوع الإرجاع
    public LocalDate getBorrowDate() { return borrowDate; }
    public LocalDate getReturnDate() { return returnDate; }
    public boolean isReturned() { return isReturned; }
    
    public void returnBook() {
        if (isReturned) throw new RuntimeException("تمت إعادة الكتاب بالفعل");
        returnDate = LocalDate.now();
        isReturned = true;
    }
    
    public double calculateFine() {
        if (!isReturned) {
            LocalDate dueDate = borrowDate.plusDays(14);
            if (LocalDate.now().isAfter(dueDate)) {
                return ChronoUnit.DAYS.between(dueDate, LocalDate.now()) * 5;
            }
        }
        return 0;
    }
    
    @Override
    public String toString() {
        String status = isReturned ? "تم الإرجاع" : "معار";
        String returnStr = isReturned ? returnDate.toString() : "لم يتم الإرجاع";
        return "كتاب: " + book.getTitle() + "\nمستعير: " + borrower.getName() + 
               "\nتاريخ الإعارة: " + borrowDate + "\nتاريخ الإرجاع: " + returnStr + 
               "\nالحالة: " + status;
    }
}