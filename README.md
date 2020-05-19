Coverage: ... SonarQube, ... JUnit

# RomanEmperorsProject

This project uses an H2 Relational Database Management System to store instances of Roman Emperors and articles written about those emperors.

## Deploying the program

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes. See deployment for notes on how to deploy the project on a live system.

1. Clone the repository to the intended client
2. Open in your IDE as a Maven Project.
3.You may now run it from your IDE as a Maven project, or use

                 mvn clean install

inside of the project folder, followed by

                 java -jar target/LukeSO-SoftwareMarch16-HobbyProject-jar-with-dependencies.jar

5. 

### Prerequisites

In order to run the program from the command line, Maven must be used to create a jar containing the dependencies. 

### Creating Development Environment 

You will need to install Maven, Java, Git & Jenkins software and ensure they are up to date with the project.

1. 
2.
3...


### Running the tests

SonarQube was used for static analysis, whereas JUnit, together with Mockito, were used to test the functionality of the program. Controller classes, Service classes, DAO classes and the Domains themselves all have their own tests. Testing will drop the database and all information containing it! Be aware of this before running a test.



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

* **Luke Smyth-Osbourne** - *....* - [sosbourneQA](https://github.com/sosbourneQA)


### License

This project is licensed under the MIT license - see the [LICENSE.md](LICENSE.md) file for details 

*For help in [Choosing a license](https://choosealicense.com/)*

### Acknowledgments

* **Nicholas Johnson**  - [nicholasjohnson](https://github.com/nickrstewarttds) taught the skills used in this project.

