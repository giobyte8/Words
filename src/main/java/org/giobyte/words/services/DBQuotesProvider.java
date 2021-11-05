package org.giobyte.words.services;

import org.giobyte.words.dao.QuotesDao;
import org.giobyte.words.entities.Quote;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("dbQuotesProvider")
public class DBQuotesProvider implements QuotesProvider {

    private final QuotesDao quotesDao;

    public DBQuotesProvider(QuotesDao quotesDao) {
        this.quotesDao = quotesDao;
    }

    @Override
    public Quote getRandomQuote(List<Long> excludedIds) {
        return quotesDao.randomQuote(excludedIds);
    }

    @Override
    public Quote getQuote(long id) {
        return quotesDao
                .findById(id)
                .orElse(null);
    }
}
