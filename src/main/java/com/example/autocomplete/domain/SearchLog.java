package com.example.autocomplete.domain;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.time.LocalDateTime;

@Getter @Setter
@Document(collection = "search_logs")
public class SearchLog {
    @MongoId
    private String id;

    private String keyword;

    @Indexed
    private LocalDateTime searchAt;

    public SearchLog(String keyword, LocalDateTime searchAt) {
        this.keyword = keyword;
        this.searchAt = searchAt;
    }
}
