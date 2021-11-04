package org.giobyte.words.dao;

import org.giobyte.words.entities.Quote;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface QuotesDao extends CrudRepository<Quote, Long> {

    @Query(
            nativeQuery = true,
            value = "SELECT * FROM quote " +
                    "WHERE id NOT IN :excludedIds " +
                    "ORDER BY RANDOM() LIMIT 1"
    )
    Quote randomQuote(List<Long> excludedIds);
}
