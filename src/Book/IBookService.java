package Book;

import java.util.List;

public interface IBookService {
    boolean addBook(Book book);
    boolean deleteBook(int bookId, int donaturId);
    boolean isDonaturValid(int donaturId);

    List<Book> getAllBooksByDonatur(int donaturId);
    Book getBookById(int bookId);
    
    // Metode baru untuk fitur ulasan
    boolean addReview(int bookId, int penerimaId, String review, int rating);
    List<String> getReviewsByDonatur(int donaturId);
}
