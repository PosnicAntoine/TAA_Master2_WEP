# API Week-End Planifier: A spring trial Back-End Application.

## Introduction

Cette CRUD API offre le Back-End d'un projet de planification de weekends.
L'idée étant que des utilisateurs pourraient s'inscrire à des addresses où ils pourraient se rendre afin de participer a des activitées disponibles dans les alentours.

Un front-end est disponible sur ce [Repository](https://github.com/DokuWilFael/wep_front).

Ce projet est en réalisation dans le cadre d'études, et à pour but de toucher pour la toute premiére fois à un projet maven. Ainsi qu'a un Back-End.

#
#

## Getting Started

### Prérequis:

* [Un environnement Java](https://java.com/fr/download/), Pour faire tourner l'API.
* [Maven](https://maven.apache.org/), Outil pour le tooling et le management d'un projet Java.

Si Maven n'est pas une possibilité chaques dependencies informée dans le [pom.xlm](https://github.com/PosnicAntoine/WEP/blob/master/pom.xml) devront être installés:


* [Spring Framework](https://spring.io/).
* [Hibernate](http://hibernate.org/).
* [ModelMapper](http://modelmapper.org/).
* [SpringFox](http://springfox.github.io/springfox/).

Notamment

#

### How to-

Afin de se lancer vous devrez connecter l'application a une base de données mySQL. Pour celà il vous faudras creer un fichier '''application.properties'''. Plus d'infos [ici](https://docs.spring.io/spring-boot/docs/current/reference/html/common-application-properties.html)

Run it and go.

#

## Idée derriere ma base de donnée.

Cette simple API manipule 3 types d'entities dans la base:
* [`User`](https://github.com/PosnicAntoine/WEP/blob/master/src/main/java/taa/weekPlanifier/entities/User.java)
* [`Address`](https://github.com/PosnicAntoine/WEP/blob/master/src/main/java/taa/weekPlanifier/entities/Address.java)
* [`Activity`](https://github.com/PosnicAntoine/WEP/blob/master/src/main/java/taa/weekPlanifier/entities/Activity.java)

Des relation Many to Many entre elles, avec `Address` au centre.

De simples operations CRUD sont ensuites disponibles sur chacunes de ces entitées cachés derrieres des DTO qui sont présentes juste pour la forme.

## Authors

* **Posnic Antoine** - *Initial work* - [PosnicAntoine](https://github.com/PosnicAntoine)
