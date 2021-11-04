package org.giobyte.words.dao;

import org.giobyte.words.entities.Quote;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

@RunWith(SpringRunner.class)
@DataJpaTest
public class QuotesDaoTest {

    @Autowired
    private QuotesDao quotesDao;

    @Test
    public void testCreateQuote() {
        Quote quote = new Quote();
        quote.setQuote("Lorem Ipsum");

        quotesDao.save(quote);
        Optional<Quote> dbQuoteOpt = quotesDao.findById(1L);

        assertFalse(
                dbQuoteOpt.isEmpty(),
                "Quote could not be retrieved from db"
        );
        assertEquals(
                quote.getQuote(),
                dbQuoteOpt.orElse(new Quote()).getQuote(),
                "Queries quote does not match inserted one");
    }

    @Test
    public void testGetRandomQuote() {
        Quote quote1 = new Quote();
        quote1.setQuote("Lorem Ipsum");

        Quote quote2 = new Quote();
        quote2.setQuote("Lorem Ipsum");

        Quote quote3 = new Quote();
        quote3.setQuote("Lorem Ipsum");

        quotesDao.save(quote1);
        quotesDao.save(quote2);
        quotesDao.save(quote3);

        Quote randomQuote = quotesDao.randomQuote(Arrays.asList(1L, 3L));
        assertEquals(2L, randomQuote.getId());
    }
}
