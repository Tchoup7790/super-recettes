# 📚 Super Recettes - Application de Recettes (Spring Boot + PostgreSQL)

## 🧾 Description

Cette application est une API REST permettant de gérer un catalogue de recettes de cuisine.  
Elle respecte les standards d'architecture REST et est construite en Java avec Spring Boot.

Aucune gestion d'utilisateur ou d'authentification : on se concentre uniquement sur le domaine métier.

---

## 🧱 Structure du projet
```
com.recipes 
│ 
├── controller → Endpoints REST 
├── service → Logique métier 
├── repository → DAO avec JPA 
├── model → Entités JPA 
├── dto → Objets de transfert (optionnel) 
├── config → Config Swagger, QueryDSL, etc. 
├── exception → Gestion centralisée des erreurs 
└── resources 
      └── db/migration → Scripts Flyway (.sql)
```
---

## 📦 Entités principales

1. **Recette**
   - id, titre, tempsPreparation, niveauDifficulte
   - Liens vers Categorie, Ingredients, Etapes

2. **Categorie**
   - id, nom
   - Liée à plusieurs recettes

3. **Ingredient**
   - id, nom
   - Lié à plusieurs recettes (ManyToMany)

4. **Etape**
   - id, description, ordre
   - Liée à une seule recette

---

## 🔄 Endpoints disponibles (exemples)

| Méthode | URI | Description |
|--------|-----|-------------|
| GET    | `/recettes` | Liste paginée des recettes |
| GET    | `/recettes/{id}` | Détails d'une recette |
| POST   | `/recettes` | Créer une recette |
| PUT    | `/recettes/{id}` | Mettre à jour |
| DELETE | `/recettes/{id}` | Supprimer |
| GET    | `/recettes/search` | Filtres dynamiques (QueryDSL) |
| ...    | `/categories`, `/ingredients`, etc. | CRUD des autres entités |

---

## 🔍 Filtres dynamiques possibles (QueryDSL)

- Par titre
- Par catégorie
- Par ingrédient
- Par temps de préparation (inférieur à...)
- Par difficulté

---

## 🔃 Pagination et tri

- Pagination automatique via `Pageable`
- Exemple :  
```
GET /recettes?page=0&size=5&sort=titre,asc
```


---

## ⚠️ Gestion des erreurs

Centralisée via `@ControllerAdvice`.  
Renvoie des statuts HTTP explicites : `400`, `404`, etc.

---
## 👥 Auteurs
Baptiste 
Marius
Maxime
