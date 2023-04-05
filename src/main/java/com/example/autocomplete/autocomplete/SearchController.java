package com.example.autocomplete.autocomplete;

import com.example.autocomplete.domain.SearchLog;
import com.example.autocomplete.repository.SearchLogRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDateTime;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class SearchController {

    @Autowired
    private SearchLogRepository repository;

    @GetMapping("/search")
    public ResponseEntity<List<String>> search(@RequestParam("q") String keyword){
        SearchLog saved = repository.save(new SearchLog(keyword, LocalDateTime.now()));
        return ResponseEntity.ok(List.of(saved.getKeyword()));
    }
}
