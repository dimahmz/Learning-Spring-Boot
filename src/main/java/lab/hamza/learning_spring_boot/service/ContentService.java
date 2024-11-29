package lab.hamza.learning_spring_boot.service;

import lab.hamza.learning_spring_boot.dto.ContentDto;
import lab.hamza.learning_spring_boot.model.Content;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;



import java.util.List;

@Service
public interface  ContentService {


    ResponseEntity<Content> addContent(ContentDto contentDto);

    ResponseEntity<Object> deleteContent(Long id);

    ResponseEntity<Content> updateContent(Long id , ContentDto contentDto);

    ResponseEntity<Object> getContent(Long id);

    List<ContentDto> getAllContents();


}
