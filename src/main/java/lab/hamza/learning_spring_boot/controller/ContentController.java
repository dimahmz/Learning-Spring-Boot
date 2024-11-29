package lab.hamza.learning_spring_boot.controller;


import jakarta.validation.Valid;
import lab.hamza.learning_spring_boot.dto.ContentDto;
import lab.hamza.learning_spring_boot.model.Content;
import lab.hamza.learning_spring_boot.service.ContentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/api/content")
@CrossOrigin
public class  ContentController {

    private final ContentService contentService;

    public ContentController(ContentService contentService) {
        this.contentService = contentService;
    }

    @GetMapping("")
    public List<ContentDto> getAll() {
        return contentService.getAllContents();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getById(@PathVariable Long id) {
        return contentService.getContent(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("")
    public ResponseEntity<Content> create(@Valid @RequestBody ContentDto content) {
        return contentService.addContent(content);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Content> update(@PathVariable Long id, @Valid @RequestBody ContentDto content) {
        return contentService.updateContent(id, content);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteById(@PathVariable Long id) {
        return contentService.deleteContent(id);
    }

}
