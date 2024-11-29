package lab.hamza.learning_spring_boot.service.Implementation;

import lab.hamza.learning_spring_boot.dto.ContentDto;
import lab.hamza.learning_spring_boot.model.Content;
import lab.hamza.learning_spring_boot.repository.ContentRepository;
import lab.hamza.learning_spring_boot.service.ContentService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ContentServiceImpl implements ContentService {

    @Autowired
    private  ContentRepository contentRepository;


    public ResponseEntity<Content> addContent(ContentDto contentDto) {
        Content content = new Content();
        content.setDescription(contentDto.getDescription());
        content.setUrl(contentDto.getUrl());
        return new ResponseEntity<>(this.contentRepository.save(content), HttpStatus.CREATED);
    }

    public ResponseEntity<Object> deleteContent(ContentDto contentDto) {
        contentRepository.deleteById(contentDto.getId());
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    public  ResponseEntity<Content> updateContent(Long id , ContentDto contentDto) {
        if (!contentRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Content doesn't exist");
        }

        Content content = new Content();
        content.setId(id);
        content.setDescription(contentDto.getDescription());
        content.setUrl(contentDto.getUrl());
        this.contentRepository.save(content);
        return new ResponseEntity<>(this.contentRepository.save(content), HttpStatus.CREATED);
    }

    public ResponseEntity<Object> getContent(Long id) {
        Optional<Content> retrievedContent = this.contentRepository.findById((id));
        if (retrievedContent.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Could not find content");
        }

        ContentDto contentDto = new ContentDto();
        contentDto.setId(retrievedContent.get().getId());
        contentDto.setDescription(retrievedContent.get().getDescription());
        contentDto.setUrl(retrievedContent.get().getUrl());

        return new ResponseEntity<>(contentDto, HttpStatus.OK);
    }

    public List<ContentDto> getAllContents() {
        List<Content> contents = contentRepository.findAll();
        return contents.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    public ResponseEntity<Object> deleteContent(Long id) {
        Optional<Content> retrievedContent = contentRepository.findById(id);
        if (retrievedContent.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Could not find content");
        }

        contentRepository.delete(retrievedContent.get());

        return new ResponseEntity<>("content with id "+id+" has been deleted", HttpStatus.OK);
    }

    private ContentDto convertToDto(Content content) {
        ContentDto contentDto = new ContentDto();
        BeanUtils.copyProperties(content, contentDto);
        return contentDto;
    }

}
