-- src/main/ressources/migration/V1__create_categorie.sql
CREATE TABLE categorie (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL
);