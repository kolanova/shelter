# Shelter
## Learning basic CRUD of Spring Boot with our methors in UpgradeHub bootcamp

With this project we suppose to deal with different pet shelters by their type. 
Here we will manage 3 types of pets: resquing them by adding to our shelters, adopting them to our users and feeding them.
Since one of our pets is addopted we will remove them from shelter. Also we will controlling the feed time of our animals.

This API has 5 main classes (1 additional *PetFeedId) and 3 types of 3 of them, to assign names to our integral constants.
### *Models*:
* Feed
* Food
* Pet
* PetFeed
* PetFeedId
* Shelter
#### *Enums*:
**FoodType
**PetType
**ShelterTypes

To define a better method of storing, updating, and extracting the data stored from JAVA applications in the backend we use 4 repositories for our application purpose
### *Repositories*
* FeedRepository
* FoodRepository
* PetRepository
* ShelterRepository

With a specific functionality *service* we will check whether the given data is valid or not.
### *Services*
* FeedService
* FoodService
* PetService
* ShelterService

To invoke business logic, updates the model and returns the view that should be rendered we use controllers which are responsible for processing incoming requests.
### *Controllers:*
* AdoptionController 
* ExceptionController
* FoodController
* ShelterController

Also we use *endpoints* that indicates the access of the resource. This method indicates interactions such as GET, POST, or DELETE
To maintain a normal desired flow of our API we use also *exceptions* which provide the means to separate the details of what to do when something out of the ordinary happens from the main logic of a program.
