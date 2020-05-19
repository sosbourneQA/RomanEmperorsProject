Test Coverage: 87.8% SonarQube, 91% JUnit

# RomanEmperorsProject

This is a web-application made using Spring Boot that allows users can create a profile for a Roman emperor and then add articles relating to that emperor. Emperors and articles can be read, updated or destroyed by the user and instances are stored on an H2 Relational Database Management System. The instances are stored in my H2 database. I developed the program as a Maven project, using IntelliJ as my IDE. The back-end is written in Java and the front-end uses a combination of HTML, CSS and JavaScript. I used Jenkins as the CI Server so send and copy of the program to SonarQube, which was used for static anlysis and was hosted on a virtual machine instance on GCP, and to Nexus Artifact Repository. An idea of the workflow is given by the project kanban board which can be found in the 'Projects' tab on GitHub.

The program's server can be run on a terminal of your choice, and has been tested on cmd.exe (Windows Command Prompt) and git bash using the command 'mvn spring-boot:run'. The server is configured to run using 'localport:8181'. Once the program is running, a user can access the application by searching for the configured localport in the browser.

### Prerequisites 

In order to run the program you will need the following installed:

* [Java SE 14](https://www.oracle.com/java/technologies/javase/jdk14-archive-downloads.html)
* [Apache Maven](https://maven.apache.org/)
* [ItelliJ](https://www.jetbrains.com/idea/download/#section=windows) or another suitable IDE for running Spring Boot 


## Deploying the program

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes. See deployment for notes on how to deploy the project on a live system.

1. Clone the repository to the intended client
2. Open in your IDE as a Maven Project.
3.You may now run it from your IDE as a Maven project, or use

                 `mvn clean install`

inside of the project folder, followed by

                 `java -jar target/LukeSO-SoftwareMarch16-HobbyProject-jar-with-dependencies.jar`


### Running the tests

The project uses the following tools for testing: JUnit for Unit Testing, JUnit with Mockito for Integration Testing, and SonarQube for static analysis of code quality.

#### Unit Tests

Individual funstions within the program can be tested using JUnitt.

To do this in IntelliJ:

1.
2.

#### Integration Tests

Iintegration tests are done using Mockito which mocks user input and creates a map of possible inputs to test for errors. They are run using JUnit and so in order to run them follow the same instructions as for Unit Tests.

#### SonarQube



### Built With

* [Maven](https://maven.apache.org/) - Dependency Management
* [Jenkins](https://www.jenkins.io/) - CI Pipeline Tool
* [Eclipse](https://www.eclipse.org/) - IDE
* [Java](https://www.java.com/en/download/) - Code Base
* [JUnit](https://junit.org/junit4/) - Testing Tool
* [Mockito](https://site.mockito.org/) - Testing Tool
* [Google Cloud Platform](https://cloud.google.com/) - Cloud Host
* [SonarQube](https://www.sonarqube.org/) - Static Analysis Tool
* [Nexus](https://repository.apache.org/) - Artefact Repository
* [GitHub](https://github.com/) - Version Control System

### Versioning

We use [SemVer](http://semver.org/) for versioning.

### Authors

* **Luke Smyth-Osbourne** - * Author * - [sosbourneQA](https://github.com/sosbourneQA)


### License

This project is licensed under the MIT license - see the [LICENSE.md](LICENSE.md) file for details 

*For help in [Choosing a license](https://choosealicense.com/)*

### Acknowledgments

* **Nicholas Johnson** - Software Trainer - [nicholasjohnson](https://github.com/nickrstewarttds) - main influence on the project.
* **Tadas Vaidotas** - Software Trainer - [nicholasjohnson](https://github.com/nickrstewarttds).
* **Jordan Harrison** - Software Trainer - [nicholasjohnson](https://github.com/nickrstewarttds).


