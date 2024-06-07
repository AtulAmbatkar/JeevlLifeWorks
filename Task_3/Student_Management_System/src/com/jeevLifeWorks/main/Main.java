package com.jeevLifeWorks.main;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

import com.jeevLifeWorks.student.Student;
import com.jeevLifeWorks.sudentManager.StudentManager;

/**
 * Main Class contain menu-driven Program to manage and display student
 */
public class Main {

	public static void main(String[] args) throws IOException {

		Scanner scn = new Scanner(System.in);

		System.out.println("----------------Student Menu---------------------------------");

		StudentManager studentManager = new StudentManager();
		String fileName = "students.dat";

		studentManager.loadFromFile(fileName);

		while (true) {

			// Display The Menu option to user
			System.out.println(" \n 1 Add a new Student");
			System.out.println(" 2 Remove a Student ");
			System.out.println(" 3 Update Student ");
			System.out.println(" 4 Search a Student");
			System.out.println(" 5 Display all Student's ");
			System.out.println(" 6 Save and Exit data ");

			try {
				int choise = scn.nextInt();

				switch (choise) {
				case 1:
					System.out.println("--Add Student--");
					System.out.print("\nEnter student Id: ");
					int id = scn.nextInt();
					if (id <= 0) {
						System.out.println("ID must be unique and Psitive Number");
						break;
					}
					System.out.print("\nEnter student Name: ");
					String name = scn.next();
					System.out.print("\nEnter student Age: ");
					int age = scn.nextInt();
					if (age <= 0) {
						System.out.println("Age Must be Positive Number");
						break;
					}
					System.out.print("\nEnter Grade: ");
					String grade = scn.next();
					scn.nextLine();
					System.out.print("\nEnter Address: ");
					String address = scn.nextLine();
					Student student = new Student(id, name, age, grade, address);
					studentManager.addStudent(student);
					break;

				case 2:
					System.out.println("--Remove Student--");
					System.out.print("\nEnter student id: ");
					int id1 = scn.nextInt();
					studentManager.removeStudent(id1);
					break;

				case 3:
					System.out.println("--Update Student Details--");
					System.out.print("\nEnter student id that you want to change details: ");
					int id2 = scn.nextInt();
					if (studentManager.searchStudent(id2) != null) {
						System.out.print("\nEnter student Name: ");
						String name1 = scn.next();
						System.out.print("\nEnter student Age(number): ");
						int age1 = scn.nextInt();
						if (age1 <= 0) {
							System.out.println("Age Must be Positive Number");
							break;
						}
						System.out.print("\nEnter Grade: ");
						String grade1 = scn.next();
						System.out.print("\nEnter Address: ");
						String address1 = scn.next();
						scn.nextLine();
						studentManager.updateStudent(id2, name1, age1, grade1, address1);
					} else {
						System.out.println("Student is not Available for this Id '" + id2 + "'");
					}
					break;

				case 4:
					System.out.println("--Search for a student by ID--");
					System.out.print("\nEnter Student id that you want display the student’s details: ");
					int id3 = scn.nextInt();
					Student student3 = studentManager.searchStudent(id3);
					if (student3 != null) {
						System.out.println(student3);
					} else {
						System.out.println("this '" + id3 + "'Student is not found");
					}
					break;

				case 5:
					System.out.println("--Display all students (sorted by chosen attribute)--");
					System.out.print("\nEnter student attribute that you want to sort: ");
					String attribute = scn.next();
					studentManager.displayAllStudent(attribute);
					break;

				case 6:
					System.out.println("--Exit and save data--");
					studentManager.saveToFile(fileName);
					System.out.println("Data saved in file. Exiting....");

					scn.close();
					return;

				default:
					System.out.println("--Invalid choise please try again");
					continue;
				}
			} catch (InputMismatchException e) {
				System.out.println("Envalid enter input plase Enter only number in(1-6) : " + e.getMessage());
				return;
			}

		}
	}
}
