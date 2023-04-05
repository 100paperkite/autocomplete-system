package com.example.autocomplete.repository;

import com.example.autocomplete.domain.SearchLog;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.time.LocalDateTime;
import java.util.List;

public interface SearchLogRepository extends MongoRepository<SearchLog, String> {

    @Query("{'searchAt': {$gte: ?0, $lte: ?1}}")
    List<SearchLog> findBySearchAtBetween(LocalDateTime from, LocalDateTime to);
}
