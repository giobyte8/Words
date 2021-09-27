package org.giobyte.words.controllers;

import org.giobyte.words.entities.Quote;
import org.giobyte.words.services.QuotesProvider;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WordsController {

    private final QuotesProvider quotesProvider;

    public WordsController(QuotesProvider quotesProvider) {
        this.quotesProvider = quotesProvider;
    }

    @GetMapping("/quote")
    public Quote getQuote() {
        return quotesProvider.getQuote();
    }
}
