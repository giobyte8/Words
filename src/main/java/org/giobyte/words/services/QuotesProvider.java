package org.giobyte.words.services;

import org.giobyte.words.entities.Quote;
import org.springframework.lang.Nullable;

import java.util.List;

public interface QuotesProvider {

    Quote getQuote(@Nullable List<String> excludeIds);

    Quote getQuote();
}
