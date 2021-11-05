package org.giobyte.words.controllers;

import org.giobyte.words.dao.QuotesDao;
import org.giobyte.words.entities.Quote;
import org.giobyte.words.services.QuotesProvider;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class WordsController {

    private final QuotesProvider quotesProvider;
    private final QuotesDao quotesDao;

    public WordsController(@Qualifier("dbQuotesProvider") QuotesProvider quotesProvider,
                           QuotesDao quotesDao) {
        this.quotesProvider = quotesProvider;
        this.quotesDao = quotesDao;
    }

    @GetMapping("/quote/random")
    public Quote randomQuote(@RequestParam Optional<List<Long>> excludedIds) {
        return quotesProvider.getRandomQuote(
                excludedIds.orElse(new ArrayList<>())
        );
    }

    @PostMapping("/quote")
    public Quote saveQuote(@Valid @RequestBody Quote quote) {
        return quotesDao.save(quote);
    }
}
