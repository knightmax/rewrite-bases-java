# DOJO Réécrire les bases - Java

## Principe

Dans ce dojo vous allez implémenter des fonctions de bases du langage vous-même. 
Pour cela le corps de fonctions à compléter vous sont fournis vous n'aurez qu'à écrire le code dedans pour répondre aux spécifications. 
Une batterie de tests unitaires vous permettra de vérifier que votre code fonctionne.

## Prérequis - Outils

1. [JDK 17](https://adoptium.net/) minimum
2. [Maven](https://maven.apache.org/download.cgi)
3. Un IDE : [Intellij](https://www.jetbrains.com/fr-fr/idea/download/) ou [Eclipse](https://www.eclipse.org/downloads/packages/) voir [VSCode](https://code.visualstudio.com/) 

## Tester son code

Pour lancer les tests, lancez la commande :

``` bash
mvn test
```

## Règles

Le but est d'implémenter ces fonctions, donc évidement utiliser la version native pour résoudre le problème est interdit. 
Il faut jouer le jeu sinon cela ne sert à rien. La plupart des fonctions peuvent être résolues juste avec une boucle for classique. 
Essayez de vous y cantonner.

## À vous de jouer !

### 1. filter

``` java
public static <T> List<T> filter(List<T> originalLst, Predicate<T> predicate)
```

`filter` va, comme son nom l'indique filtrer les éléments d'un tableau selon une condition et retourner un nouveau tableau avec uniquement les éléments qui remplissent la condition `predicate`.


### 2. map

``` java
public static <T,D> List<D> map(List<T> originalLst, Function<T,D> function)
```

`map` est une projection. On a en entrée une liste de `T` originalLst, et une fonction `function` qui a en entrée un élément de type `T` et en sortie un élément de type `R`. 
On applique cette fonction à l'ensemble des éléments de la liste et on obtient une nouvelle liste de `R`.

### 3. flatMap

``` java
public static <T,D> List<D> flatMap(List<List<T>> originalLst, Function<List<T>, Stream<? extends D>> function)
```

`flatMap`, tout comme map, elle permet d'appliquer une fonction de mappage, mais produit un flux de nouvelles valeurs. Elle peut être utilisée là où nous devons aplatir ou transformer.
On a une liste de liste `originalLst` en entrée et une fonction `function` qui est appliquée à chaque élément et la fonction renvoie le nouveau flux `Stream<D>`.

## Et Spring dans tout ça ?

Nous avons vu comment réécrire les fonctions Stream afin de démystifier un peu tout cela.
Mais quand on travaille avec Spring, les gens parlent de magie.
Dans cet exercice nous allons tenter de créer un mini framework, que l'on va appeler Summer, qui imitera le principe d'inversion de contrôle (IoC) que l'on connait tous bien.
Plusieurs versions sont mises à disposition avec des **TODO** indiquant les bouts de code à compléter.
La structure des projets est également indiquée avec les endroits à modifier. 

### 1. Posons les bases

Dans le package `fr.java.spring.ioc.version1`, vous trouverez une classe `App` qui utilise `PersonService` pour créer et rechercher une personne dans la foulée.
Il vous faudra utiliser l'injection de dépendance manuellement pour utiliser le Service et exécuter les actions.

```
version1
    |_ webapp
    |   |_ dao
    |   |   |_ PersonDAO.java
    |   |   |_ PersonDAOImpl.java
    |   |_ service
    |       |_ PersonService.java
    |       |_ PersonServiceImpl.java
    |_ App1 (à mettre à jour)
```

### 2. Ajoutons un peu de contexte

Nous allons introduire la notion de contexte, dans le package `fr.java.spring.ioc.version2` vous trouverez une nouvelle version de la webapp mais également les prémices de notre framework :

```
version2
    |_ summer
    |   |_ context
    |       |_ ApplicationContext.java (à mettre à jour)
    |_ webapp
    |   |_ dao
    |   |   |_ PersonDAO.java (à mettre à jour)
    |   |   |_ PersonDAOImpl.java (à mettre à jour)
    |   |_ service
    |       |_ PersonService.java (à mettre à jour)
    |       |_ PersonServiceImpl.java (à mettre à jour)
    |_ App2 (à mettre à jour)
```

Il faudra utiliser, dans la classe `ApplicationContext`, de la reflexion et les annotations présentes dans le package `fr.java.spring.ioc.common.annotation` pour trouver tous les Bean candidats à être instanciés et éventuellement les dépendances vers d'autres Bean.  