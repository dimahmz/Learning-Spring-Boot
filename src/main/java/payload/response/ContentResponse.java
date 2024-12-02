package payload.response;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@Data
public class ContentResponse {

    private Long id;
    private String description;
    private String url;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

}
