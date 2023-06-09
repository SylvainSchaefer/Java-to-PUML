
**Rapport hebdomadaire - Semaine 1:**

Ce qui a été fait :

Prise en main de Javadoc, des doclets et de leurs options avec les explications donné par monsieur Schneider.

Compilation des fichiers Java2Puml.java et FirstDoclet.java.

Exécution manuelle de la commande Javadoc avec le doclet FirstDoclet pour le package western en utilisant les options nécessaires.

Configuration de l'exécution de Java2Puml dans IntelliJ pour lancer Javadoc et le doclet, en complétant les arguments de la ligne de commande avec les options nécessaires.

Réalisation d'un diagramme de séquence modélisant l'appel d'un doclet, en se référant à la documentation de l'interface Doclet.

Réalisation d'un DCA et d'un DCC (Diagramme de Classes de Conception) des interfaces et classes nécessaires pour l'utilisation des doclets. Seuls les éléments pertinents pour la réalisation du projet ont été inclus.

Difficultés rencontrées :

Compilation en ligne de commande et avec InteliJ.

Doc Java très à filtrer car beaucoup de classe et interfaces ont des noms ressemblants mais des fonctionnalités différentes.

Difficulté à savoir quel classes et interfaces nous seront réellement utiles pour le projet car nous sommes au début. Le DCC seras mis à jour si besoin. 


**RAPPORT SEMAINE 2**

Ce qui a été fait : 

•    Sylvain :

Modélisation API Java Language Model à partir de la documentation en ligne

DCA et DCC API pumlFromJava

•    Selim : 

Production d’un DCA sans les associations

Création de la commande Java2puml

Difficultés rencontrées :

Compréhension de la doc en ligne car très fournie

Familiarisation avec le fonctionnement de l’API, notamment Element et TypeMirror


**Rapport hebdomadaire - Semaine 3**:

Ce qui a été fait :

Amélioration du DCA en incluant les associations de Généralisations et réalisations entre les classes.

Les DCC et les DCA ont été mis à jour en fonction des nouvelles associations.

Difficultés rencontrées :

Agrégations déduites des variables d'instance et de classe qui n'ont pas un type primitif. A finir en semaine 4.

**RAPPORT SEMAINE 4**

Ce qui a été fait : 

•    Sylvain :

Créations de deux options afin de choisir entre DCA et DCC

Mise à jour DCAset DCC

•    Selim : 

Production d’un DCA sans les associations avec attributs, opérations et modificateurs

Création de nouvelle classes Parameter , modifier en séparent des méthodes de notre ancien code.

Agrégations déduites des variables d'instance et de classe qui n'ont pas un type primitif

Difficultés rencontrées :

Compréhension du fonctionnement des options

Concaténation des chaînes de caractères

Trouver les différents éléments correspondant afin de créer l’UML

**Rapport hebdomadaire - Semaine 5:**

Ce qui a été fait:

Production du DCA µet du DCC avec toutes les associations.

Le DCC oriente et caractérise les associations, traite les rôles (nom, visibilité, multiplicité) et rajoute les dépendances.

Le DCA fait figurer les dépendances sous la forme d'une relation non nommée.

Creation d’une classe abstraite « *GeneralClasse » regroupant* les méthodes communes entre ClasseUML , InterfaceUML et EnumUML. 

Difficultés rencontrées :

Compréhension du fonctionnement des options et leur mise en œuvre dans la génération du DCA et du DCC.

Concaténation des chaînes de caractères pour créer les éléments de l'UML.

Filtré les types primitifs en UML et pas en Java ainsi que les types existant en Java tel que SHORT, CHAR etc qui deviennent INTEGER et STRING en UML.

**Rapport hebdomadaire - Semaine 6:**

Ce qui a été fait:

Option -rel afin de limiter le nombre de relations, on peut choisir entre afficher toutes les relations ou limiter les relations

Difficultés rencontrées :

La principale difficulté a été la lecture et l'inspection des commentaires de documentation pour extraire les informations nécessaires à l'amélioration du diagramme de classe. 


