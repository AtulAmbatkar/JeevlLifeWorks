## Student Management System
  This Java project provides a console-based student management system. The system allows users to perform various operations such as adding, removing, updating, searching, and displaying students. The system saves the student data to a file and can load it from the file when the application starts.

## Assumptions
  1.Student IDs are unique and must be greater than zero.
  2.Student ages must be positive numbers.
  3.The application uses a file named students.dat to store student data.
  4.The user provides valid input when prompted by the application.
 
## How to Run the Program

### Prerequisites
  Java Development Kit (JDK) installed on your system.
  A text editor or an Integrated Development Environment (IDE) such as IntelliJ IDEA, Eclipse, or VSCode

## Added source code
  create Student.java in the file src/com/jeevLifeWorks/student/ and paste
  create StudentManager.java file src/com/jeevLifeWorks/studentManager/ and paste
  crete Main.java in the file src/com/jeevLifeWorks/main/ and paste

## created Data File
  create Data file with name students.dat in the root directory
 
## Compile the code 
  use command line to compile the code javac src/com/jeevLifeWorks/student/Student.java or use IDE
  javac src/com/jeevLifeWorks/student/StudentManager.java
  javac src/com/jeevLifeWorks/student/Main.java
  compile all file that compile file converted into byte code that machine understand code.

## Run the Application
  use coommand line command to run the application java src/com/jeevLifeWorks/student/Main.java here main method
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
