## Student Management System
  This Java project provides a console-based student management system. The system allows users to perform various operations such as adding, removing, updating, searching, and displaying students. The system saves the student data to a MySQL DataBase and can load it from the database when the application starts.

## Assumptions
  1.Student IDs are unique and must be greater than zero.
  2.Student name cannot be null.
  3.Student ages must be positive numbers.
  4.The user provides valid input when prompted by the application.
 
## How to Run the Program

### Prerequisites
  Java Development Kit (JDK) installed on our system.
  A text editor or an Integrated Development Environment (IDE) such as IntelliJ IDEA, Eclipse, or VSCode
  MySQLdatabase is instaled in our system
## How to Run the Program
 ###Setup MySQL Database
 1.stary MySQL server
 2.create database to studen table 
 3.add some dummy data 
## Added source code
  create Student.java in the file src/com.jeevLifeWorks.entity/Student.java and paste
  create StudentService.java file src/com.jeevLifeWorks.service/StudentService.java and paste
  create StudentDAO.interface  file src/com.jeevLifeWorks.dao/StudentDAO.java and paste 
  create StudentDAOImpl.java  file src/com.jeevLifeWorks.dao/StudentDAOImpl.java and paste 
  crete Main.java in the file src/com/jeevLifeWorks/main/StudentApp.java and paste
 
## Compile the code 
  use command line to compile the code javac src/com.jeevLifeWorks.entity/Student.java or use IDE
  javac src/com.jeevLifeWorks.service/StudentService.java
  javac src/com.jeevLifeWorks.service/StudentDAO
  javac src/com.jeevLifeWorks.dao/StudentDAOImpl
  compile all file that compile file converted into byte code that machine understand code.

## Run the Application
  use coommand line command to run the application
  java src/com.jeevLifeWorks.entity/Student.java here main method
  to start the execution line by line.
  
## Example Usage
  Start the program by running Main.java.
  Choose an option from the menu:
    1.Add a new student by entering their details.
    2.Remove a student by providing their ID.
    3.Update a student's details by providing their ID and new details.
    4.Search for a student by ID.
    5.Display all students, optionally sorted by a chosen attribute (ID, name, age, grade, or address).
    6.Save and exit, which saves the student data to students.dat and exits the program.
