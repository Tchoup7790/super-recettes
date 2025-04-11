<img src="./logo.png" alt="Project img" align="center" />

<h1 align="center">Super Recettes API</h1>
<p align="center">
<i>Le projet est a but pédagogique, un déploiement n'est pas prévu</i>
</p>

<p align="center">
  <a href="#description">Description</a> •
  <a href="#contribution">Contribution</a> •
  <a href="#about">About</a>
</p>

Une API REST permettant de gérer des recettes de cuisine, leurs ingrédients, étapes de préparation et catégories.

---

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

---

## Fonctionnalités

- 🔸 CRUD complet sur `recipes`, `steps`, `ingredients`, `categories`
- 🔁 Gestion des relations entre entités (OneToMany, ManyToMany)
- 🧠 Boucles d’objets contrôlées avec `@JsonManagedReference` et `@JsonBackReference`
- 🧪 Base de données relationnelle (PostrgeSQL) avec persistance

---

## Build With

- [Java 17](https://openjdk.org/)
- [Spring Boot](https://spring.io/projects/spring-boot)
- [Hibernate / JPA](https://hibernate.org/)
- [Lombok](https://projectlombok.org/)
- [PostrgeSQL](https://www.postgresql.org/)
- [Postman](https://www.postman.com/)

---

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

---

## Pré-requis

* [Java 17](https://openjdk.org/)
* [Gradle](https://gradle.org/)
* [PostrgeSQL](https://www.postgresql.org/)
* (facultatif) [Postman](https://www.postman.com/)

---

## Initialisation du projet

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

---

## Exemple de requête

### POST /steps

```json
{
  "description": "Mélanger les œufs et la farine",
  "stepOrder": 1,
  "recipeId": "{{recipeId}}"
}
```

### GET /recipes/{id}

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

---

## À Propos

### Auteur

* [Tchoup7790](https://github.com/Tchoup7790)
* [clementmarius](https://github.com/clementmarius)
* [ryannnasa](https://github.com/ryannnasa)

### Contact

Pour toute question ou suggestion :
[juliojuliobaptiste@gmail.com](mailto:juliojuliobaptiste@gmail.com)
