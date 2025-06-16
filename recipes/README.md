<img src="./logo.png" alt="Project img" align="center" />

<h1 align="center">Super Recettes API</h1>
<p align="center">
<i>Le projet est a but pédagogique, un déploiement n'est pas prévu</i>
</p>

Une API REST permettant de gérer des recettes de cuisine, leurs ingrédients, étapes de préparation et catégories.


## Description

Ce projet vise à offrir une API complète de gestion de recettes, permettant :

- la création de recettes avec leurs étapes (`steps`)
- l'association d'ingrédients et de catégories
- la consultation, modification et suppression de chaque entité
- une relation structurée entre les entités avec gestion des cycles (évite les boucles infinies dans les réponses)

### Usage

Les cas d'usage principaux incluent :

- Création d’une recette avec ses ingrédients et étapes
- Consultation d’une recette complète
- Ajout d’une étape indépendamment
- Mise à jour ou suppression d’un ingrédient

### Fonctionnalités

- 🔸 CRUD complet sur `recipes`, `steps`, `ingredients`, `categories`
- 🔁 Gestion des relations entre entités (OneToMany, ManyToMany)
- 🧠 Boucles d’objets contrôlées avec `@JsonManagedReference` et `@JsonBackReference`
- 🧪 Base de données relationnelle (PostrgeSQL) avec persistance

### Build With

- [Java 17](https://openjdk.org/)
- [Spring Boot](https://spring.io/projects/spring-boot)
- [Hibernate / JPA](https://hibernate.org/)
- [Lombok](https://projectlombok.org/)
- [PostrgeSQL](https://www.postgresql.org/)
- [Postman](https://www.postman.com/)


## Contribution

### How To

Nous accueillons les contributions avec plaisir ! Pour contribuer :

1. Ouvrez une **[issue](#)** pour décrire votre problème ou la fonctionnalité que vous aimeriez avoir.

2. Lorsque **l’issue** est approuvée, créez une **branch** :

```bash
git checkout -b feature/nom-feature
```

3. Ouvrez une **[Pull Request](#)** avec une description claire des modifications.

### Structure du projet

```
src/main/java/com/group/SuperRecipes
│
├── controller/    # RestControllers
├── model/         # Entités JPA
│     ├── dao/           # Data Access Objects
│     └── dto/           # Data Transfer Objects
├── repository/        # Interfaces JpaRepository
├── exception/        # Interfaces Exception
├── service/           # Logique métier
└── SuperRecipesApplication.java
```
```
src/main/ressources/
│
├── db/migration    # Migration
└── application.yml
```


### Pré-requis

* [Java 17](https://openjdk.org/)
* [Gradle](https://gradle.org/)
* [PostrgeSQL](https://www.postgresql.org/)
* (facultatif) [Postman](https://www.postman.com/)


### Initialisation du projet

1. Clonez le dépôt

```bash
git clone https://github.com/Tchoup7790/super-recettes
```

2. Accédez au dossier

```bash
cd ./super-recettes
```

3. Ouvrez le projet avec IntelliJ et Installez les dépendances

4. Lancer une base de donnée PostrgeSQL et vérfier la configuration dans le fichier `/src/main/ressources/application.yml`

6. Lancez l'application

7. Accédez à l’API via `http://localhost:8080`


## Exemple de requête

### POST api/v1/steps

```json
{
  "description": "Mélanger les œufs et la farine",
  "stepOrder": 1,
  "recipeId": "{{recipeId}}"
}
```

### GET api/v1/recipes/{id}

```json
{
  "title": "Pancakes",
  "preparationTime": 15,
  "categoryId": "{{CATEGORY_ID}}",
   "ingredientIds": [
       "{{INGREDIENT_ID}}"
   ],
  "steps": [
    {
      "description": "Mélanger les œufs et la farine",
      "stepOrder": 1
    },
    {
      "description": "Faire cuire à la poêle",
      "stepOrder": 2
    }
  ]
}
```


### API Endpoints

| Ressource    | Méthode | Endpoint               | Description                  |
|--------------|---------|------------------------|------------------------------|
| Categories   | POST    | `/categories`          | Créer une catégorie          |
|              | GET     | `/categories`          | Lister toutes les catégories |
|              | GET     | `/categories/{:id}`    | Récupérer une catégorie      |
|              | PUT     | `/categories/{:id}`    | Mettre à jour une catégorie  |
|              | DELETE  | `/categories/{:id}`    | Supprimer une catégorie      |
| Ingredients  | POST    | `/ingredients`         | Créer un ingrédient          |
|              | GET     | `/ingredients`         | Lister tous les ingrédients  |
|              | GET     | `/ingredients/{:id}`   | Récupérer un ingrédient      |
|              | PUT     | `/ingredients/{:id}`   | Mettre à jour un ingrédient  |
|              | DELETE  | `/ingredients/{:id}`   | Supprimer un ingrédient      |
| Recipes      | POST    | `/recipes`             | Créer une recette            |
|              | GET     | `/recipes`             | Lister toutes les recettes   |
|              | GET     | `/recipes/{:id}`       | Récupérer une recette        |
|              | PUT     | `/recipes/{:id}`       | Mettre à jour une recette    |
|              | DELETE  | `/recipes/{:id}`       | Supprimer une recette        |
| Steps        | POST    | `/steps`               | Créer une étape              |
|              | GET     | `/steps`               | Lister toutes les étapes     |
|              | GET     | `/steps/{:id}`         | Récupérer une étape          |
|              | PUT     | `/steps/{:id}`         | Mettre à jour une étape      |
|              | DELETE  | `/steps/{:id}`         | Supprimer une étape          |



### Body pour les requêtes

**Recipe**
```json
{
    "title": "",
    "preparationTime": 0,
    "categoryId": "",
    "ingredientIds": [
        ""
    ],
    "steps": [
        {
            "description": "",
            "stepOrder": 0
        }
    ]
}
```

**Ingredient**
```json
{
    "name": ""
}
```


**Category**
```json
{
    "name": ""
}
```

**Step**
```json
{
  "description": "",
  "stepOrder": 0,
  "recipeId": ""
}
```

## À Propos

### Auteur

* [Tchoup7790](https://github.com/Tchoup7790)
* [clementmarius](https://github.com/clementmarius)
* [ryannnasa](https://github.com/ryannnasa)

### Contact

Pour toute question ou suggestion :
[juliojuliobaptiste@gmail.com](mailto:juliojuliobaptiste@gmail.com)
