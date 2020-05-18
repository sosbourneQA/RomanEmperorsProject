Coverage: ... SonarQube, ... JUnit

# RomanEmperorsProject

This project uses an H2 Relational Database Management System to store instances of Roman Emperors and articles written about those emperors.

## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes. See deployment for notes on how to deploy the project on a live system.

1. Fork and clone the repo onto your local hard drive.
2. Open the folder in your IDE as a Maven Project.
3. Replace the MySQL links in the IMS and the DAO classes for order, customer, item and order line with ones that point to your MySQL instance. This requires the External IP of the instance.

### Prerequisites

If not already in place:

1. Install Java, Maven and Git.
2. Set up a MySQL instance. This can be done locally by installing SQL, or on Google cloud Platform which is how I chose to do it. For a guide on how to set up an instance on GCP, please click on this [link](https://cloud.google.com/sql/docs/mysql/quickstart).




## Running the tests

The tests were written using Mockito and Junit and cover the customer, items and order classes for the controllers, domains and services.

## Deployment

After the project has been forked, open the folder in your IDE, I used Eclipse which worked well. Go to the folder where the project is located and open the command window in the folder. This will mean that you are pointing to the location of project is in your command window. Preform the following command to create the fat JAR, which is a JAR file with all the dependancies merged into it:

         mvn clean install

## Built With

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

## Versioning

We use [SemVer](http://semver.org/) for versioning.

## Authors


* **Luke Smyth-Osbourne** - *....* - [sosbourneQA](https://github.com/sosbourneQA)


## License

This project is licensed under the MIT license - see the [LICENSE.md](LICENSE.md) file for details 

*For help in [Choosing a license](https://choosealicense.com/)*

## Acknowledgments

* **Chris Perrins**  - [christophperrins](https://github.com/christophperrins) made the initial code base.
* **Nicholas Johnson**  - [nicholasjohnson](https://github.com/nickrstewarttds) taught the skills used in this project.

