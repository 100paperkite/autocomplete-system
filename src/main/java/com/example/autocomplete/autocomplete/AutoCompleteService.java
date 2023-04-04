package com.example.autocomplete.autocomplete;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AutoCompleteService {

    public List<String> search(String prefix) {
        List<String> dummy = List.of(prefix, "apple", "banana", "cycle", "diamond", "five");
        return dummy;
    }
}
