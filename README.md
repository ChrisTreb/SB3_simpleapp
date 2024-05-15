## Récupérer image docker postgres
docker pull postgres

## Créer et lancer le container
docker run -d --name containername -p 5432:5432 -e POSTGRES_PASSWORD=password postgres

## Vérifier le fonctionnement du container
docker ps

## Run Container 
docker exec -it postgresCont bash

## Connexion à Postgres
psql -h localhost -U postgres

## Créer une base de données
CREATE DATABASE mydatabase;

## Afficher les databases disponibles
\l

## Connexion à la base
\c mydatabase

## Installer PgAdmin4

## Insérer des données (Générer sur mockaroo un csv) avec PgAdmin

## Url du swagger
http://localhost:8080/swagger-ui/index.html
