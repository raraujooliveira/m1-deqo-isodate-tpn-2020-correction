# TP noté DéQo

**M1 Info DL, IHM**  
**Développement Collaboratif, Qualité**  
**Examen Session 1, 2020-2021**

Durée : 2h (**1h50 de composition + 10mn pour le rendu Git**)

Tout document est autorisé.

Il est strictement interdit de communiquer de manière directe ou indirecte, de quelque manière que ce soit (messagerie instantanée, e-mail, SMS, réseaux sociaux, discord, communication orale, etc.) avec une personne autre que les surveillant(e)s.

**Toute violation de cet interdit entraînera une sanction lourde et est susceptible de poursuite pour fraude à examen.**

Vous pouvez travailler sur vos propres machines.  Vous êtes alors responsable de tout problème technique survenant pendant la séance (panne matériel, panne wifi, panne système, etc.). Votre machine doit alors être configurée avec IntelliJ Ultimate Edition, Git, et JDK 1.8.
  
## 1. Création et initialisation du projet Maven "isodate" (2 points)

* Créez sur votre poste de travail un projet Maven ayant les caractéristiques suivantes :
    * groupId : deqo
    * artifactId : isodate
    
  Vous choisirez également "isodate" comme nom du projet IntelliJ.
* Votre projet utilisera Java en version 1.8 et JUnit en version 4.13.1 pour la création des tests unitaires. Modifiez le fichier pom.xml de votre projet pour exprimer ces méta-données.
* Votre projet utilisera l'outil d'analyse statique de code Checkstyle, le plugin Jxr, ainsi que JaCoCo pour mesurer la couverture du code par les tests sur votre projet.
  Modifiez le fichier pom.xml de votre projet pour pouvoir générer les rapports Checkstyle, Jxr et JaCoCo.
* Créez un fichier texte "README.md" à la racine du projet en y écrivant votre prénom, votre nom, et votre numéro d'étudiant.

Votre travail consiste à reprendre un projet existant visant la manipulation de jours au format **ISO 8601**, c'est-à-dire YYYY-MM-DD (avec l'année d'abord, puis le mois, puis le jour) ou encore YYYY-DDD (avec l'année et le numéro du jour, c'est-à-dire, le nombre de jours écoulés depuis le 1er janvier de l'année), sans utiliser la bibliothèque standard `Date`.

(Un avantage de ces formats est qu'ils comportent toujours le même nombre de caractères, et sont tels que des jours croissants donnent des chaînes de caractères classées dans le même ordre...)

* Récupérez le dossier "src" fourni sur Moodle puis remplacez le dossier "src" de votre projet par le dossier "src" récupéré.
* Veillez à ce que vous n'ayez pas de fichier-squelette-résiduel `App.java` ni `AppTest.java` dans votre projet.
* Étudiez le code source de votre projet. Vérifiez qu'il compile normalement. Vous pouvez lancer différentes commandes Maven pour vérifier que votre configuration fonctionne comme attendue (génération des rapports OK, etc.).
  
## 2. Supervision du projet "isodate" par Git (1 point)

* Faites en sorte que votre projet soit supervisé par Git. On s'attachera à vérifier que le dossier ".git" soit bien à la racine du dossier "isodate".
* Faites en sorte que les dossiers "target", ".idea" et les fichiers "\*.iml" soient ignorés par Git.
* Effectuez un premier commit permettant d'ajouter votre projet sur la branche master de votre dépôt Git local.
* Cliquez sur le lien fourni sur Moodle et suivez les instructions pour créer automatiquement un dépôt privé pour votre TP au sein de l'organisation GitHub DCLL-MDL.
* Après avoir localement configuré le remote correspondant à votre dépot privé sur Github, poussez votre branche master sur votre dépôt distant.

**Aucune création d'Issue ou de Pull Request n'est demandée dans ce sujet.**  
Les questions suivantes doivent être traitées dans l'ordre.  
Si vous manquez de temps pour traiter toutes les questions, il est indispensable de consacrer les 10 dernières minutes de l'épreuve à la question 8 pour effectuer le rendu de votre travail .

## 3. Amélioration du respect des conventions de codage (3 points)

Créez une nouvelle branche à partir de master, intitulée "conventions". Basculez sur cette nouvelle branche. Modifiez les classes de votre projet pour que :
* le nombre d'erreurs Checkstyle soit diminué d'au moins 50% (exemple : si initialement il y a 46 erreurs, il faut tomber à 23 erreurs ou moins). Prenez note du nombre d'erreurs Checkstyle de départ et le nombre d'erreurs restants car vous allez avoir besoin à la question #7.
  (Il peut être préférable d'ouvrir le fichier `target/site/index.html` avec votre explorateur ("Show in Files" ou "Show in Explorer") plutôt que *via* le serveur embarqué d'IntelliJ ("Open in Browser") qui peut causer des problèmes de cache.)
* Commitez vos modifications.
* Fusionnez vos modifications sur la branche "master" (idéalement, **en no-fast-forward**).
* N’envoyez pas encore les modifications vers le dépôt distant, ceci est à faire à la question 8.

## 4. Couverture du code par les tests de la classe Year (3 points)

* Créez une nouvelle branche (et basculez dessus) intitulée "testsYear".
* Créez la classe de test unitaire permettant de tester la classe Year.
* Écrivez les tests unitaires permettant de couvrir le code de la classe Year à 100% en utilisant comme cas de tests au moins les années 1900, 2000, 2008, 2019 (pour cette question, aucun changement dans la classe à tester n'est autorisé).  
  Comme en TP DéQo, **utilisez de préférence Maven pour lancer les tests** (et le rapport de couverture).
* Commitez vos modifications.
* Fusionnez vos modifications sur la branche "master" (idéalement, **en no-fast-forward**).
* N’envoyez pas encore les modifications vers le dépôt distant, ceci est à faire à la question 8.

## 5. Couverture du code par les tests de la classe IsoDays (3 points)

* Créez une nouvelle branche (et basculez dessus) intitulée "testsIsoDays".
* Créez la classe de test unitaire permettant de tester la classe IsoDays. 
* Écrivez les tests unitaires permettant de couvrir le code de la classe IsoDays à 100% (pour cette question, aucun changement dans la classe à tester n'est autorisé).  
* Commitez vos modifications.
* Fusionnez vos modifications sur la branche "master" (idéalement, **en no-fast-forward**).
* N’envoyez pas encore les modifications vers le dépôt distant, ceci est à faire à la question 8.

## 6. Couverture du code par les tests de la classe IsoDate et Correctif (4 points)

* Créez une nouvelle branche (et basculez dessus) intitulée "testsIsoDate".
* Créez la classe de test unitaire permettant de tester la classe IsoDate.
* Écrivez les tests unitaires permettant de couvrir le code de la classe IsoDate à 100% en utilisant les contraintes suivantes pour les cas de tests :
    * Vous testerez toutes les combinaisons possibles constructeurs/méthodes-publiques (il y a 2 constructeurs et 2 méthodes publiques dans cette classe)
    * Vous testerez les cas nominaux avec les deux jours valides "31 décembre 2000" et "31 décembre 2001" 
    * Vous testerez au moins un cas d'erreur lié à une chaîne de caractères de taille invalide, où l'exception est lévée.
* Vous identifierez et corrigerez un bug lié à la classe IsoDate (indication : nombre de chiffres du mois/jour !)
* Commitez vos modifications.
* Fusionnez vos modifications sur la branche "master" (idéalement, **en no-fast-forward**).
* N’envoyez pas encore les modifications vers le dépôt distant, ceci est à faire à la question 8.

## 7. Validation des données (et vérification Checkstyle) (4 points)

* Créez une nouvelle branche (et basculez dessus) intitulée "check".
* Les classes IsoDays et IsoDate ignorent les contraintes sur la valeur des jours et des mois (par exemple, le mois doit être un nombre *entre 1 et 12*, alors que les classes ne valident pas cela).  
  Dans cette question, on se propose d'y remédier, mais uniquement pour la classe IsoDays (on validera qu'un jour est bien entre 1 et 365 ou 366).
* Ajouter 2 tests unitaires pour IsoDays (un pour chaque constructeur), exigeant qu'une exception "IsoDateException" soit levée dans ces cas. (Ces tests ne passeront donc pas.)
* Modifiez la classe IsoDays pour prendre en compte cette validation (qu'un jour doit être entre 1 et 365 ou 366), lever l'exception "IsoDateException" le cas échéant, et ainsi faire passer les tests.
* Il n'est pas demandé ici d'aboutir à 100% de couverture par les tests.
* En revanche, assurez-vous que vos modifications n'ont pas créé (trop) d'erreurs Checkstyle par rapport au nombre d'erreurs max imposé à la question 3.
* Commitez vos modifications.
* Fusionnez vos modifications sur la branche "master" (idéalement, **en no-fast-forward**).

## Question BONUS: 
Utilisez le template BDD pour l'écriture de vos tests unitaires.

## 8. Rendu du travail sur Github

À la fin de l'épreuve, effectuez les actions suivantes (dans un terminal git-bash) :
* Poussez la branche master.
* créez un tag "final" sur votre dernier commit effectué en utilisant la commande suivante : `git tag -a final -m Final`
* Poussez ce tag en utilisant la commande: `git push origin final`.
* Poussez toutes les branches créées lors des questions précédentes (si vous avez gardé celles-ci).
