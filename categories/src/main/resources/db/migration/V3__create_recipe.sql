CREATE TABLE recipe (
    id VARCHAR(255) PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    preparation_time INT NOT NULL,
    category_id VARCHAR(255),
    CONSTRAINT fk_category FOREIGN KEY (category_id) REFERENCES category (id)
);
