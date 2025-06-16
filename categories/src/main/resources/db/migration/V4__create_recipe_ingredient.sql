CREATE TABLE recipe_ingredient (
    recipe_id VARCHAR(255) NOT NULL,
    ingredient_id VARCHAR(255) NOT NULL,
    PRIMARY KEY (recipe_id, ingredient_id),
    CONSTRAINT fk_recipe FOREIGN KEY (recipe_id) REFERENCES recipe(id),
    CONSTRAINT fk_ingredient FOREIGN KEY (ingredient_id) REFERENCES ingredient(id)
);
