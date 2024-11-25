package lab.hamza.learning_spring_boot.repository;

import jakarta.annotation.PostConstruct;
import lab.hamza.learning_spring_boot.model.Content;
import lab.hamza.learning_spring_boot.model.Status;
import lab.hamza.learning_spring_boot.model.Type;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class ContentCollectionRepository {
    private final List<Content> contentList = new ArrayList<>();

    public ContentCollectionRepository() {

    }

    public List<Content> findAll() {
        return contentList;
    }

    public Optional<Content> findById(Integer id) {
        return contentList.stream().filter(c -> c.id().equals(id)).findFirst();
    }

    public void save(Content content) {
        contentList.add(content);
    }

    // generate static data
    @PostConstruct
    private void init() {
        Content content = new Content(1,
                "My First Blog Post",
                "My First Blog Post is about programming languages",
                Type.ARTICLE,
                Status.IDEA,
                LocalDateTime.now(),
                "");

        contentList.add(content);
    }

}
