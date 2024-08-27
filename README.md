# Web-Automation-Practice

## Project Overview

The **Web Automation Framework** is designed to automate the testing of the sauce demo website using Java and Maven as the dependency manager.

## Project Requirements

To work with this project, ensure you meet the following requirements:

1. **Java SDK**: The project is built with Java 22 SDK. Ensure you have Java 22 installed on your system. If using IntelliJ IDEA, it should be version 2024-2. You can download it from JetBrains IntelliJ IDEA as it is the only version of the IDE that supports Java 22.

2. **Clone the Repository**:

   ```bash
   git clone <repo-url>
   cd web-automation.practice
   cd PomPractice (make sure this is the folder you open in the IDE)

2. **Configure the IDE with Java 22**:

2.1. Right-click on the PomPractice folder > Open Module Settings > in the Modules section,         verify that the language level is "22-Unnamed variables and patterns".

2.2. Click on Project, verify that in SDK: it says "22 Oracle OpenJDK 22" and that in Language Level: it says "22-Unnamed variables and patterns".

2.3. Click OK.

3. **Maven**: The project uses Maven for dependency management. Ensure Maven is installed and properly configured on your system.

3.1.Console: 
     mvn clean install -DskipTests

Each test case has its own .xml file in TestNG for its respective execution.

