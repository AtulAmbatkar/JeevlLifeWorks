package com.jeevLifeWorks.main;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import com.jeevLifeWorks.entity.Student;
import com.jeevLifeWorks.service.StudentService;

/**
 * StudentApp class represent the student menu,here we all crud operation
 * perform interact with user
 */
public class StudentApp {

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);
		StudentService studenttService = new StudentService();

		System.out.println("-------Student Menu-----------");

		while (true) {

			try {
				// Student Menu
				System.out.println("\n1.- Add a new student");
				System.out.println("2.- View all students");
				System.out.println("3.- View a student by ID");
				System.out.println("4.- Update a student");
				System.out.println("5.- Delete a student");
				System.out.println("6.- Exit,studentApp");

				int userInput = scn.nextInt();

				switch (userInput) {
				case 1:
					System.out.println("--Add student--");
					System.out.print("\tEnter Student Id : ");
					long id = scn.nextLong();
					scn.nextLine();
					if (id <= 0) {
						System.out.println("Id must be Unique and Positive Integr");
						break;
					}
					System.out.print("\tEnter Student Name : ");
					String name = scn.nextLine();
					if (name.isBlank()) {
						System.out.println("Student name cannot be null or empty");
						break;
					}
					System.out.print("\tEnter Student Age: ");
					int age = scn.nextInt();
					if (age <= 0) {
						System.out.println("Student age Must be Positive Integer ");
						break;
					}
					System.out.print("\tEnter Student Grade: ");
					String grade = scn.next();
					scn.nextLine();
					System.out.print("\tEnter Student Address: ");
					String address = scn.nextLine();
					Student student = new Student(id, name, age, grade, address);
					studenttService.addStudent(student);
					break;

				case 2:
					System.out.println("-----View all student------");
					List<Student> list = studenttService.getAllStudent();
					for (Student student1 : list) {
						System.out.println(student1);
					}
					break;

				case 3:
					System.out.println("-----View a student by ID-----");
					System.out.print("\tEnter that you want to get student by Id: ");
					long id1 = scn.nextLong();
					Student student3 = studenttService.getStudentById(id1);
					if (student3 != null) {
						System.out.println(student3);
					} else {
						System.out.println("Student not found dor id : " + id1);
					}
					break;

				case 4:
					System.out.println("-----Update a student-----");
					System.out.print("\tEnter student id that you want to change the details: ");
					long id2 = scn.nextLong();
					scn.nextLine();
					if (studenttService.getStudentById(id2) != null) {
						System.out.print("\tEnter student name: ");
						String name1 = scn.nextLine();
						if (name1.isBlank()) {
							System.out.println("student name cannot be null or empty");
							break;
						}
						System.out.print("\tEnter Student Age: ");
						int age1 = scn.nextInt();
						if (age1 <= 0) {
							System.out.println("Student age Must be Positive Integer ");
							break;
						}
						System.out.print("\tEnter Student Grade: ");
						String grade1 = scn.next();
						scn.nextLine();
						System.out.print("\tEnter Student Address: ");
						String address1 = scn.nextLine();
						Student student1 = new Student(id2, name1, age1, grade1, address1);
						studenttService.updateStudent(student1);
					} else {
						System.out.println("Student is not available for Id: " + id2);
					}
					break;

				case 5:
					System.out.println("-----Delete a student-----");
					System.out.print("\tEnter student id for delete: ");
					long id3 = scn.nextLong();
					studenttService.deleteStudent(id3);
					break;

				case 6:
					scn.close();
					System.out.println("\tExist studentApp,Thank you");
					return;

				default:
					System.out.println("-----Invalid Input,please try again-----");
					continue;
				}
			} catch (InputMismatchException e) {
				System.out.println("Invalid enter input. please enter only Number(1-5): " + e.toString());
				scn.next(); // clear invalid input
			}
		}
	}
}
