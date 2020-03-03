# OC-java-P7
Développez le nouveau système d’information de la bibliothèque d’une grande ville

### Prérequis
#### Java
Installer java (version 11 du jdk disponible [ici](https://www.oracle.com/technetwork/java/javase/downloads/jdk11-downloads-5066655.html).
 
 #### Maven
 La version utilisé lors du développement du projet est la version 3.6.1. Maven est directement téléchargeable sur le
  site prévu à cet effet [ici](https://maven.apache.org/download.cgi).
  
 ### NodeJS
 NodeJS est téléchargeable à cette [addresse](https://nodejs.org/en/). 
 Merci de prendre la version 13.9.0 
 
 ### Contexte : 
  ```
    Objet : Récapitulatif de notre discussion

    Re-bonjour Patricia,

    Suite à notre réunion de ce matin, tu trouveras ci-dessous le récapitulatif de nos attentes concernant le projet d’outils numériques à destination des bibliothèques de notre très chère ville.

    Je reste à dispo si tu as des questions,

    Bien à toi,

    Luc

    Directeur du service culturel

    ----

    Nous souhaitons confier à la DSI la création d’un ensemble d’outils numériques pour les différents acteurs des bibliothèques de la ville. En voici la liste :

        Un site web et une application mobile pour les usagers de la bibliothèque.
        Un logiciel pour le personnel des bibliothèques.
        Un logiciel pour des traitements automatisés (mails de relance).

    Le site web permettra aux usagers de suivre les prêts de leurs ouvrages. Il pourront :

        Rechercher des ouvrages et voir le nombre d’exemplaires disponibles.
        Consulter leurs prêts en cours. Les prêts sont pour une période de 4 semaines.
        Prolonger un prêt en cours. Le prêt d’un ouvrage n’est prolongeable qu’une seule fois. La prolongation ajoute une nouvelle période de prêt (4 semaines) à la période initiale.

    Nous attendons également une application mobile iOS et Android qui fournira les mêmes services que le site web.

    Le logiciel pour le personnel des bibliothèques permettra notamment de gérer les emprunts et les livres rendus.

    Le logiciel pour les traitements automatisés, que tu as désigné par le terme “batch” il me semble, permettra d’envoyer des mails de relance aux usagers n’ayant pas rendu les livres en fin de période de prêt. L’envoi est automatique à la fréquence d’un par jour.
```
   
   ### Travail demandé :
   Le travail demandé est celui d'un développeur, à savoir développer une solution pour un client.
   ```
Release 1.0
API Web
Application web
Batch 
```
   
   ### Livrables fournis : 
   -    Code source de l'application
   -    Modèle Physique de Données pour représenter les entités et leurs relations dans l'application.
   
  
   ### Lancement du projet.
   Merci de lancer le module ConfigServerApplication en premier. Celui ci ira chercher les informations
   contenus dans les applications.yml pour les autres modules. Vous pouvez consulter les 
   propriétés présentes [ici](https://github.com/metaXIII/OC-java-P7-config).
   Démarrez ensuite les autres modules.
   
   Pour le front, installez d'abord les dépendances du projet ``npm install`` dans le répertoire librairie-front
   et lancez le server localhost avec ``npm start``
   
   ## Copyright
   Ce projet est en licence libre, toutefois n'hésitez pas à ajouter une étoile à ce projet s'il vous a été utile.
   Vous pouvez également me contacter par mail à l'adresse [gael.lehchibi@outlook.com](mailto:gael.lehchibi@outlook.com).
   
   Merci.
   
   