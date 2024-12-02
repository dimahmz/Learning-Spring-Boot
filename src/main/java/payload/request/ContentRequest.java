package payload.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ContentRequest {

    @NotBlank
    private String description;

    @NotBlank
    private String url;


}
