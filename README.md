# SAE 1256 

## Présentation

## Membres de l'équipe

## Conventions et règles 

### 1. Normalisation 

### 2. Convention de commit 

Nous suivons la convention de commit suivante : [Conventions](https://www.conventionalcommits.org/fr/v1.0.0/). 

Voici quelques **points clés** de cette convention : 

#### Structure du message de commit

Un message de commit se compose de trois parties :

1. En-tête (header)
2. Corps (body)
3. Pied de page (footer)

``` 
<type>(étendue optionnelle): <description>
[corps optionnel]
[pied optionnel]
```

#### En-tête (Header)

L'en-tête est obligatoire et doit être concis. Il se compose de :
- **Type** : Un mot décrivant la nature du commit
- **Sujet** : Une courte description de la modification (max. 50 caractères).

Voici quelques exemples de types : 

- **feat** : Une nouvelle fonctionnalité.
- **fix** : Une correction de bug.
- **docs** : Des modifications concernant la documentation.
- **style** : Des changements de style (formatage, points et virgules manquants, etc.) qui n'affectent pas le code.
- **refactor** : Une modification du code qui n'apporte ni nouvelle fonctionnalité ni - - correction de bug.
- **test** : Ajouter ou modifier des tests.
- **chore** : Des tâches de maintenance qui ne modifient pas le code source (mise à jour des outils de build, configuration, etc.).

Exemples : 

- `fix: type incorrect dans les attributs de la classe Equipe `
- `feat(langue): ajouter la langue polonaise `


#### Corps (Body)

Le corps est optionnel mais recommandé pour les commits complexes. Il fournit une description détaillée des modifications, raisons et contexte.

#### Pied de page (Footer)

Le pied de page est optionnel et est utilisé pour des informations supplémentaires comme les références aux tickets (issues) ou les notes spéciales.

Exemple de commit avec en-tête, corps et pieds de page : 
```
fix: corriger le bug d'affichage sur la page d'accueil

Ce correctif résout un problème où les images ne s'affichaient pas correctement sur la page d'accueil. La cause était une mauvaise URL d'image générée par la fonction de rendu

Reviewed-by: Zanzibar35
Refs: #123
```