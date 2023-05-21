package hokhanhdu.buoi456.repository;

import hokhanhdu.buoi456.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBookRepository extends JpaRepository<Book, Long> {
}
