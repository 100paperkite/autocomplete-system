package com.example.autocomplete.autocomplete;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
public class SearchController {

    @GetMapping("/search")
    public ResponseEntity<String> search(@RequestParam("q") String keyword){
        return ResponseEntity.ok(keyword);
    }
}
