package lab.hamza.learning_spring_boot.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lab.hamza.learning_spring_boot.model.audit.AuditableEntity;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "contents")
@Getter
@Setter
@ToString
public class Content extends AuditableEntity {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @NotBlank(message = "Title is mandatory")
        @Size(max = 100, message = "Title cannot be longer than 100 characters")
        private String description;

        @DateTimeFormat

        private String url;
}
