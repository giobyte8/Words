package org.giobyte.words.services;

import org.giobyte.words.entities.Quote;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class InMemoryQuotesProvider implements QuotesProvider {

    private List<Quote> quotes = new ArrayList<>();

    public InMemoryQuotesProvider() {
        Quote quote = new Quote();
        quote.setQuote("You have to think selfish sometimes");
        quotes.add(quote);

        Quote quote1 = new Quote();
        quote1.setQuote("You can't have both happiness and the truth, choose the happiness .. unless you feel a calling, a true calling");
        quotes.add(quote1);
    }


    @Override
    public Quote getRandomQuote(List<Long> excludedIds) {
        return quotes.get(0);
    }

    @Override
    public Quote getQuote(long id) {
        return null;
    }
}
