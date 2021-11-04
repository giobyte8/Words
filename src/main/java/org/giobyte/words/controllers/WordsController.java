package org.giobyte.words.controllers;

import org.giobyte.words.dao.QuoteDao;
import org.giobyte.words.entities.Quote;
import org.giobyte.words.services.QuotesProvider;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class WordsController {

    private final QuotesProvider quotesProvider;
    private final QuoteDao quoteDao;

    public WordsController(QuotesProvider quotesProvider,
                           QuoteDao quoteDao) {
        this.quotesProvider = quotesProvider;
        this.quoteDao = quoteDao;
    }

    @GetMapping("/quote")
    public Quote getQuote() {
        return quotesProvider.getQuote();
    }

    @PostMapping("/quote")
    public Quote saveQuote(@Valid @RequestBody Quote quote) {
        return quoteDao.save(quote);
    }
}
