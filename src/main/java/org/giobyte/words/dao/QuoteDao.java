package org.giobyte.words.dao;

import org.giobyte.words.entities.Quote;
import org.springframework.data.repository.CrudRepository;

public interface QuoteDao extends CrudRepository<Quote, Long> {
}
