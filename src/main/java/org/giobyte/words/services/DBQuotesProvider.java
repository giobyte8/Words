package org.giobyte.words.services;

import org.giobyte.words.dao.QuotesDao;
import org.giobyte.words.entities.Quote;

import java.util.List;

public class DBQuotesProvider implements QuotesProvider {

    private final QuotesDao quotesDao;

    public DBQuotesProvider(QuotesDao quotesDao) {
        this.quotesDao = quotesDao;
    }

    @Override
    public Quote getRandomQuote(List<Long> excludedIds) {
        return null;
    }

    @Override
    public Quote getQuote(long id) {
        return quotesDao.findById(id).get();
    }
}
