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
public static <T,D> List<T> map(List<T> originalLst, Function<T,D> function)
```

`map` est une projection. On a en entrée une liste de `T` originalLst, et une fonction `function` qui a en entrée un élément de type `T` et en sortie un élément de type `R`. On applique cette fonction à l'ensemble des éléments de la liste et on obtient une nouvelle liste de `R`.
