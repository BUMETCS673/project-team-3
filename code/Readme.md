## Project Sections

## Backend

Backend is built using spring boot and maven. To add as a maven project:

1) cd to code/Employee_management_system directory.
2) Right click on pom.xml.
3) Click on "Add as Maven project".

## Database

Database is built using Postgres database.

## FrontEnd

FrontEnd is built using React.js.

## How to Run

Please make sure you are using at least java 17.

1) cd to the project directory.
2) Run 'mvn clean install' or 'mvn package' to build the jar.
3) Run "docker-compose up -d" . This will build the containers for backend and frontend.
4) Open [http://localhost:3000/login](http://localhost:3000/login) to view the application in browser.
5) Run "docker-compose down" to stop the containers. 

## Helpful docker commands

1) docker volume prune (remove all volumes)
2) docker system prune (remove all volumes and dangling images)
3) docker image prune -a (remove all images)