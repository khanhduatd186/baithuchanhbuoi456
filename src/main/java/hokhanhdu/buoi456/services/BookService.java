package hokhanhdu.buoi456.services;

import hokhanhdu.buoi456.entity.Book;
import hokhanhdu.buoi456.repository.IBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {
    @Autowired
    private IBookRepository bookRepository;
    public List<Book> getAllBooks(){
        return bookRepository.findAll();
    }
    public Book getBookById(long id){
        Optional<Book> optional = bookRepository.findById(id);
        return  optional.orElse(null);
    }
    public void addBook(Book book){
        bookRepository.save(book);
    }
    public void updateBook(Book book){
        bookRepository.save(book);
    }
    public void deleteBook(long id){
        bookRepository.deleteById(id);
    }
}
