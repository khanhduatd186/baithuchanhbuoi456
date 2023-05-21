package hokhanhdu.buoi456.repository;

import hokhanhdu.buoi456.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICategoryRepository extends JpaRepository<Category,Long> {
}
