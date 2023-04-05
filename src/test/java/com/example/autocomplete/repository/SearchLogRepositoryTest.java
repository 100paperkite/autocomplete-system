package com.example.autocomplete.repository;

import com.example.autocomplete.domain.SearchLog;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class SearchLogRepositoryTest {
    @Autowired
    private SearchLogRepository repository;

    @BeforeEach
    public void beforeEach(){
        repository.deleteAll();
    }

    @Test
    public void 검색_로그가_잘_저장되어야_한다() {
        //given
        SearchLog log = new SearchLog("test", LocalDateTime.now());

        //when
        SearchLog savedLog = repository.save(log);
        Optional<SearchLog> result = repository.findById(savedLog.getId());

        assertThat(result).isPresent();
        assertThat(result.get().getKeyword()).isEqualTo("test");
    }

    @Test
    public void 특정_기간의_로그만_모두_가져올_수_있다() {
        //given
        LocalDateTime start = LocalDateTime.of(2023,1,1,0,0);
        SearchLog first = new SearchLog("first", start);
        SearchLog second = new SearchLog("second", start);

        LocalDateTime afterOneMinute = start.plusMinutes(1);
        LocalDateTime afterTwoMinute = start.plusMinutes(2);

        SearchLog third = new SearchLog("third", afterTwoMinute);

        repository.save(first);
        repository.save(second);
        repository.save(third);

        //when
        List<SearchLog> logs = repository.findBySearchAtBetween(start, afterOneMinute);

        //then
        assertThat(logs).hasSize(2);
        assertThat(logs).usingRecursiveFieldByFieldElementComparator().contains(first);
        assertThat(logs).usingRecursiveFieldByFieldElementComparator().contains(second);

    }
}