package org.giobyte.words.dao;

import org.giobyte.words.entities.Quote;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

@RunWith(SpringRunner.class)
@DataJpaTest
public class QuoteDaoTest {

    @Autowired
    private QuoteDao quoteDao;

    @Test
    public void testCreateQuote() {
        Quote quote = new Quote();
        quote.setQuote("Lorem Ipsum");

        quoteDao.save(quote);
        Optional<Quote> dbQuoteOpt = quoteDao.findById(1L);

        assertFalse(
                dbQuoteOpt.isEmpty(),
                "Quote could not be retrieved from db"
        );
        assertEquals(
                quote.getQuote(),
                dbQuoteOpt.orElse(new Quote()).getQuote(),
                "Queries quote does not match inserted one");
    }
}
