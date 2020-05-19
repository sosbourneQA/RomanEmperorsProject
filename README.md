Test Coverage: 87.8% SonarQube, 91% JUnit

# RomanEmperorsProject

This is a spring web-application made using Spring Boot that allows users can create profiles for a Roman emperors and then add articles relating to specific emperors. Emperors and articles can be read, updated or destroyed by the user and instances are stored on an H2 Relational Database Management System. The instances are stored in my H2 database. I developed the program as a Maven project, using IntelliJ as my IDE. The back-end is written in Java and the front-end uses a combination of HTML, CSS and JavaScript. I used Jenkins as the CI Server so send and copy of the program to SonarQube, which was used for static anlysis and was hosted on a virtual machine instance on GCP, and to Nexus Artifact Repository. An idea of the workflow is given by the project kanban board which can be found in the 'Projects' tab on GitHub.

The program's server can be run in a terminal, and has been tested on Windows Command Promp and Git Bash using the command 'mvn spring-boot:run'. The server is configured to run on 'localport:8181'. Once the program is running, a user can access the application by searching for the configured localport URL in the browser.

### Prerequisites 

In order to run the program you will need the following installed:

* [Java SE 14](https://www.oracle.com/java/technologies/javase/jdk14-archive-downloads.html)
* [Apache Maven](https://maven.apache.org/)
* [ItelliJ](https://www.jetbrains.com/idea/download/#section=windows) or another suitable IDE for running Spring Boot 
* [Jenkins](https://www.jenkins.io/download/)


## Deploying the program

The project is open source, therefore is available to anyone. These instructions will get you a copy of the project up and running on youe local device for development and testing purposes:

1. Clone the repository in the terminal using the command `git clone https://github.com/sosbourneQA/RomanEmperorsProject.git`, or 'Fork' the repository and use input the same command but replacing the URL with the forked version.
2. Open in your IDE as a Maven Project.
3. You may now run it from your IDE as a Maven project, or use these commands in a terminal:

                 `mvn clean install`

                 `cd target/`

                 `java -jar target/LukeSO-SoftwareMarch16-HobbyProject-jar-with-dependencies.jar`


### Running the tests

The project uses the following tools for testing: JUnit for Unit Testing, JUnit with Mockito for Integration Testing, and SonarQube for static analysis of code quality.

#### Unit Tests

Individual funstions within the program can be tested using JUnitt.

To do this in IntelliJ do the following:

1. Right click on the class you wish to test in the file explorer of the IntelliJ IDE, as found in src/test/java, not the actual classes found in src/main/java (to run all tests, right click the src/test/java folder instead).
2. Hover over 'Run As' on the dropdown menu.
3. Click '2 JUnit Test'.
4. All tests within the application are undertaken and can be reviewed using the 'JUnit' and 'Coverage' windows.

#### Integration Tests

Iintegration tests are done using Mockito which mocks user input and creates a map of possible inputs to test for errors. They are run using JUnit and so in order to run them follow the same instructions as for Unit Tests.

#### SonarQube

1. Create a VM Instance on GCP called 'sonarqube'.
2. Click on the instance name.
3. Click 'edit'.
4. Scroll down to network tags and assign the tag 'tcp-9000'.
5. Go back to your instance list and click 'SSH' beneath 'connect'.
6. Enter this command into the terminal to install Docker:

`curl https://gist.githubusercontent.com/christophperrins/760262e7308ceb8d9c51b4b984792a43/raw/00970ff2aa1857ab54f573f750c9f4f23d6c9578/installDocker.sh | sh`

7. Exit the terminal, then open again and enter this command to install SonarQube:

`curl https://gist.githubusercontent.com/christophperrins/760262e7308ceb8d9c51b4b984792a43/raw/00970ff2aa1857ab54f573f750c9f4f23d6c9578/installDocker.sh | sh`

8. Exit the terminal, then open again and enter the command `docker start sonarqube` to run SonarQube inside the VM instance
9. Open a new tab in any browser and enter the external IP address of your instance (next to 'SSH'), followed by a colon, followed by '9000' (`http://YOUR_GCP_VM_EXTERNAL_IP_ADDRESS:9000`) to access SonarQube.

#### Deploy using Jenkins

1. Create a new 'Freestyle project' on Jenkins by clicking on 'New Item' on the homepage.
2. In the 'Source Code Management' section click 'Git' and link the project to your project repository by iputting the URL.
3. In 'Build Triggers' click 'Build periodically' and input `* * * * *` to ensure the project builds each minute.
4. In 'Build Environment' click 'Add timestamps to the Console Output' and 'Abort the build if it's stuck'.
5. In 'Build' click 'Add build step' and select 'Execute Windown batch command'. 
6. Enter the command: 

        `mvn clean package`
        
7. Do step 5. again and enter the command:

        `mvn sonar:sonar -Dsonar.host.url=http://YOUR_GCP_VM_EXTERNAL_ID_ADDRESS:9000 -Dsonar.login.admin=admin -Dsonar.password=admin`
        
8. If you have copied these steps correctly you should now be able to see an instance of the project in your SonarQube account and read the code analysis at `http://YOUR_GCP_VM_EXTERNAL_ID_ADDRESS:9000`


### Built With

* [Maven](https://maven.apache.org/) - Dependency Management
* [Jenkins](https://www.jenkins.io/) - CI Pipeline Tool
* [IntelliJ](https://www.jetbrains.com/idea/) - IDE
* [Visual Studio Code](https://code.visualstudio.com/) - IDE
* [Java](https://www.java.com/en/download/) - Code Base
* [JUnit](https://junit.org/junit4/) - Testing Tool
* [Mockito](https://site.mockito.org/) - Testing Tool
* [Google Cloud Platform](https://cloud.google.com/) - Cloud Host
* [SonarQube](https://www.sonarqube.org/) - Static Analysis Tool
* [Nexus](https://repository.apache.org/) - Artefact Repository
* [GitHub](https://github.com/) - Online Repository, Version Control System and Project Management
* [Postman](https://www.postman.com/) - Testing APIs
* [Git](https://git-scm.com/) - Local Repository and Version Control Sytem
* [H2 Database Engine](https://www.h2database.com/html/main.html) - Relational Database management System
* [Spring Boot] (https://spring.io/projects/spring-boot) - Java-based Framework that is an API Development Platform

### Versioning

We use [SemVer](http://semver.org/) for versioning.

### Authors

* **Luke Smyth-Osbourne** - *Author* - [sosbourneQA](https://github.com/sosbourneQA)


### License

This project is licensed under the MIT license - see the [LICENSE.md](LICENSE.md) file for details 

*For help in [Choosing a license](https://choosealicense.com/)*

### Acknowledgments

* **Nicholas Johnson** - Software Trainer - [nicholasjohnson](https://github.com/nickrstewarttds) - main influence on the project.
* **Tadas Vaidotas** - Software Trainer - [nicholasjohnson](https://github.com/nickrstewarttds).
* **Jordan Harrison** - Software Trainer - [nicholasjohnson](https://github.com/nickrstewarttds).


