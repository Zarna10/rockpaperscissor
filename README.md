Rest API for Rock Paper Scissor Game Application

Technology used

    • Java
    • Spring boot : Web application
    • Maven : Building project

Web Application Configuration

    • Web application is running on port 8080

Steps to run the app:

1) Start the application through following command from project directory
mvn clean install spring-boot:run 

2) To run as a standalone application execute jar through following command(PATH: \rockpaperscissor\target)
java -jar rockpaperscissor-0.0.1-SNAPSHOT.jar

Testing the application:
Test the application using postman API 
Endpoint
http://localhost:8080/api/rpsgame/{playeroneaction}  - where ‘playeroneaction’ can either be ROCK, PAPER or SCISSOR(not case sensitive)

Request Example:

http://localhost:8080/api/rpsgame/ROCK OR

http://localhost:8080/api/rpsgame/PAPER OR

http://localhost:8080/api/rpsgame/SCISSOR

Response Example:
{
    "playerOneAction": "ROCK",
    "playerTwoAction": "PAPER",
    "result": "LOOSE"
}


Code Functionality

First player action needs to be given at the time of REST API call
Second player action is generated randomly via code
As per the game rules, result will be displayed for the first player, whether he wins or lose.
