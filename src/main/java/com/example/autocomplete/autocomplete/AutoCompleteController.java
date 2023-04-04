package com.example.autocomplete.autocomplete;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/complete")
public class AutoCompleteController {
    @Autowired AutoCompleteService autoCompleteService;

    @GetMapping("/search")
    ResponseEntity<List<String>> search(@RequestParam("q") String prefix){
        List<String> result = autoCompleteService.search(prefix);
        return ResponseEntity.ok().body(result);
    }
}
