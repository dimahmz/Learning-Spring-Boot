package lab.hamza.learning_spring_boot.model;

import java.time.LocalDateTime;

public record Content(Integer id,
                      String title,
                      String desc,
                      Type contentType,
                      Status status,
                      LocalDateTime dateCreated,
                      String url) {
}
