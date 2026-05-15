
# LAB NEXUS — Gestion des Artéfacts

# 1. Besoin métier

Nexus permet de :

- stocker les builds Maven
- centraliser les artéfacts
- sécuriser les versions
- éviter la perte de dépendances

# 2. Concepts

## Hosted Repository
Stockage des artéfacts internes (.jar)

## Proxy Repository
Cache des dépendances externes

## Group Repository
Fusion de plusieurs repositories

# 3. Installation

docker run -d \
--name nexus \
-p 8081:8081 \
-v nexus-data:/nexus-data \
sonatype/nexus3:latest
# 4. Accès

http://localhost:8081
# 5.Récupérer mot de passe
docker exec -it nexus cat /nexus-data/admin.password
# 6.Configuration Maven
<distributionManagement>
    <repository>
        <id>nexus</id>
        <url>http://localhost:8081/repository/maven-releases/</url>
    </repository>
</distributionManagement>
# 7.Résultat attendu
fichier .jar uploadé dans Nexus
repository visible dans l’interface
