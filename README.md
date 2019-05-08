# P10_Ameliorez_la_bibliotheque
Vous trouverez dans ce dossier le code source pour ce projet ainsi que les fichiers de configuration pour un déploiement avec Docker

> Le dossier contient le code source des 3 composants : 
> - batch 
> - client_webApp 
> - webService

Dans chacun de ces dossiers, vous trouverez le code source, la javadoc et un fichier Dockerfile.

De plus, vous trouverez dans le dossier test_docker les fichiers nécessaires aux 3 scénarios de déploiement avec Docker for Windows : 
- les dossiers WS, batch et webApp contiennent leur dockerfile respectif 
- les dossier deploiement_docker-[] contiennent chacun leur docker-compose.yml
----
Pour obtenir les artefacts de déploiement (fichier .jar et .war) : 
- vous pouvez les telecharger à l'url indiquée dans le dockerfile ou laisser Docker le soin de le faire (cela peut échouer, ne pas hésiter à insister)
- vous pouvez compiler les sources avec la commandes : 
    ```mvn clean generate-sources package```
vous aurez les artefacts dans les dossiers 'target' de chacun des trois composants.
----
Vous trouverez les variables d'environnement à modifier dans les fichiers docker-compose.yml : 
- pour le batch : fréquence du cron et propriétés pour l'envoi de mail 
- pour le web service : url de la base de donnée 
- pour la base de donnée : identifiants et nom de la base de donnée 
- pour l'application web : url du web service et chemin des images