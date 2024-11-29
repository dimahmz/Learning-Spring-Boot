package lab.hamza.learning_spring_boot.repository;

import lab.hamza.learning_spring_boot.model.Content;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContentRepository extends JpaRepository<Content, Long> {

}
