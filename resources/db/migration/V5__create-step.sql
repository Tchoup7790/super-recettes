CREATE TABLE step (
    id VARCHAR(255) PRIMARY KEY,
    description TEXT NOT NULL,
    step_order INT NOT NULL,
    recipe_id VARCHAR(255) NOT NULL,
    CONSTRAINT fk_step_recipe FOREIGN KEY (recipe_id) REFERENCES recipe(id)
);
