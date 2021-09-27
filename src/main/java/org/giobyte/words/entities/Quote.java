package org.giobyte.words.entities;

public class Quote {

    private int id;
    private String quote;
    private String extendedQuote;
    private String author;
    private String sourceUrl;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getQuote() {
        return quote;
    }

    public void setQuote(String quote) {
        this.quote = quote;
    }

    public String getExtendedQuote() {
        return extendedQuote;
    }

    public void setExtendedQuote(String extendedQuote) {
        this.extendedQuote = extendedQuote;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getSourceUrl() {
        return sourceUrl;
    }

    public void setSourceUrl(String sourceUrl) {
        this.sourceUrl = sourceUrl;
    }
}
