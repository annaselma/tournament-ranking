# Kata Tournament Ranking
![Author](https://img.shields.io/badge/Author-salmaDev-green)![Language](https://img.shields.io/badge/Language-kotlin-blue) ![Language](https://img.shields.io/badge/Framework-SpringBoot-blue)

Development of an application exposing a REST API to manage the ranking of players during a tournament.
Players are sorted based on each one's number of points: from the player with the most points to the one with the least.

OBJECTIVES:

The API should allow:
##### GET
>fetch player informations by playerId
##### POST
>Adding a player
##### PUT
>Updating a player's number of points.
##### GET
> fetch players sorted by points
##### DELETE
>Delete all players
### Technologies
* This project is a CRUD REST API  using kotlin and Springboot Application.
The layers definition is based in hexagonal architecture and DDD.
I opted for this architecture as it's enforce a clear separation between the domain logic and external concerns  ike frameworks, databases, and UI. In a CRUD API.

* Open API for describing the API
##### Using commandline
You can also build the project and run all tests in the terminal:

```
./gradlew bootRun
```


##### To ensure a smooth production deployment 
>`Security`: Implement security measures such as identity and access management

> `Integration Tests`: Conduct integration tests to ensure different modules of the application work correctly together.

> `DataBase`: Configure the database properly for production environments. With prod credentials and secured in vault.

> `Monitoring` and logging : add logs and enable to monitor the app in prod environnements.

> `Continuous` Deployment:Implement a continuous deployment pipeline to automate the deployment process and ensure reliable and reproducible deployments.
