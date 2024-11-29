package lab.hamza.learning_spring_boot.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@ToString
public class ContentDto {

    private Long id;

    @NotBlank
    private String description;

    @NotBlank
    private String url;

    public ContentDto() {}

    public ContentDto(String description, String url) {
        this.description = description;
        this.url = url;
    }

    public ContentDto(Long id, String description, String url) {
        this.id = id;
        this.description = description;
        this.url = url;
    }

}


