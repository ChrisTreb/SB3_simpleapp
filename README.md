### Récupérer image docker postgres
docker pull postgres

### Créer et lancer le container
docker run -d --name containername -p 5432:5432 -e POSTGRES_PASSWORD=password postgres

### Vérifier le fonctionnement du container
docker ps

### Run Container 
docker exec -it postgresCont bash

### Connexion à Postgres
psql -h localhost -U postgres

### Créer une base de données
CREATE DATABASE mydatabase;

### Afficher les databases disponibles
\l

### Connexion à la base
\c ctrl

### Installer PgAdmin4
26/05/24 -> Ajout d'un container pgadmin4 dans le fichier docker compose

### Insérer des données (Générer sur mockaroo un csv) avec PgAdmin

### Url du swagger
http://localhost:8080/swagger-ui/index.html

### Lancer le container
docker start postgresCont

### Ajout des droits docker dans intellij
sudo chmod 666 /var/run/docker.sock

### Récupérer l'ip du container postgresContainer our pgadmin4
docker inspect -f '{{range .NetworkSettings.Networks}}{{.IPAddress}}{{end}}' postgresContainer

### Supprimer le cache docker
docker system prune -a

### Telebit
Launch on ubuntu : curl -fsSL https://get.telebit.io | bash

HTTP : ~/telebit http 8080
