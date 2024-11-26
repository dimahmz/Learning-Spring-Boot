package lab.hamza.learning_spring_boot.controller;


import lab.hamza.learning_spring_boot.model.Content;
import lab.hamza.learning_spring_boot.repository.ContentCollectionRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/content")
public class ContentController {
    private final ContentCollectionRepository repository;

    public ContentController(ContentCollectionRepository repository) {
        this.repository = repository;
    }

    @GetMapping("")
    public List<Content> getAll() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Content getById(@PathVariable Integer id) {
            return repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Could not find content"));
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("")
     public void create(@RequestBody Content content) {
        if(repository.existsById(content.id())){
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Content already exists");
        }
        repository.save(content);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable Integer id, @RequestBody Content content) {
        repository.save(content);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        if(!repository.existsById(id)){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Could not find content");
        }
        repository.deleteByID(id);
    }

}
