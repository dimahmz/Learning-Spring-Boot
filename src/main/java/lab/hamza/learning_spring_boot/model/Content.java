package lab.hamza.learning_spring_boot.model;

import jakarta.validation.constraints.NotBlank;

import java.time.LocalDateTime;

public record Content(
        Integer id,
        @NotBlank(message="title can't be empty")
        String title,
        String desc,
        Type contentType,
        Status status,
        LocalDateTime dateCreated,
        String url
) {
}
