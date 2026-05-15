# LAB SONARQUBE — Analyse Qualité du Code
# 1. Besoin métier
SonarQube permet de :

- détecter les bugs
- réduire la dette technique
- améliorer la qualité du code
- sécuriser les applications
# 2. Concepts

# Quality Gate
Décide si le code est acceptable ou non.

# Code Smells
Mauvaise pratique de programmation.

# Vulnerabilities
Failles de sécurité.

# Bugs
Erreurs détectées dans le code.

# 3. Installation

docker run -d \
--name sonarqube \
-p 9000:9000 \
-e SONAR_ES_BOOTSTRAP_CHECKS_DISABLE=true \
-v sonarqube:data:/opt/sonarqube/data \
-v sonarqube:logs:/opt/sonarqube/logs\
sonarqube:latest
# 4. Accès
http://localhost:9000
admin / admin
# 5. Résultats attendus
Dashboard SonarQube
Bugs détectés
# 6. configuration jacoco pour test
<plugin>
    <groupId>org.jacoco</groupId>
    <artifactId>jacoco-maven-plugin</artifactId>
    <version>0.8.11</version>

    <executions>
        <execution>
            <goals>
                <goal>prepare-agent</goal>
            </goals>
        </execution>

        <execution>
            <id>report</id>
<phase>test</phase>
            <goals>
                <goal>report</goal>
            </goals>
        </execution>
    </executions>
</plugin>
