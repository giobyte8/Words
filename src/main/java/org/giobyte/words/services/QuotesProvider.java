package org.giobyte.words.services;

import org.giobyte.words.entities.Quote;
import org.springframework.lang.Nullable;

import java.util.List;

public interface QuotesProvider {

    Quote getRandomQuote(@Nullable List<Long> excludedIds);

    Quote getQuote(long id);
}
