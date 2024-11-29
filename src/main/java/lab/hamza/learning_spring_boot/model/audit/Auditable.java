package lab.hamza.learning_spring_boot.model.audit;

import java.time.LocalDateTime;

public interface Auditable {
    LocalDateTime getCreatedAt();

    void setCreatedAt(LocalDateTime createdAt);

    LocalDateTime getUpdatedAt();

    void setUpdatedAt(LocalDateTime updatedAt);
}