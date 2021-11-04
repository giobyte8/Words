CREATE TABLE quote(
    id INTEGER PRIMARY KEY AUTO_INCREMENT,
    quote VARCHAR(255) NOT NULL,
    extended_quote VARCHAR(5000),
    author VARCHAR(255),
    source_url VARCHAR(5000)
);
