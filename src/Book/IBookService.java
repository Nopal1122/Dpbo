/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Book;
import java.util.List;
public interface IBookService {
    boolean addBook(Book book);
    boolean deleteBook(int bookId, int donaturId);
    boolean isDonaturValid(int donaturId);
    
    
    List<Book> getAllBooksByDonatur(int donaturId);

}
