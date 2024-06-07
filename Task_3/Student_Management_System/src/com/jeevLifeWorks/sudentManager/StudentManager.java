package com.jeevLifeWorks.sudentManager;

import java.io.*;
import java.util.*;
import com.jeevLifeWorks.student.Student;

/**
 * StudentManager class Represent student Operation by
 * adding,removing,update,search and display
 * 
 */

public class StudentManager {

	ArrayList<Student> students;
	Map<Integer, Student> studentMap;
	TreeSet<Student> studentTreeSet;

	public StudentManager() {
		this.students = new ArrayList<>();
		this.studentMap = new HashMap<>();
		this.studentTreeSet = new TreeSet<>(new Comparator<Student>() {
			public int compare(Student s1, Student s2) {
				return s1.compareTo(s2);
			}
		});
	}

	/**
	 * Adding new Student in Management given all the details by user
	 * 
	 * @param student
	 */
	public void addStudent(Student student) {
		if (!studentMap.containsKey(student.getId())) {
			students.add(student);
			studentMap.put(student.getId(), student);
			studentTreeSet.add(student);
			System.out.println("successfull added ");
		} else {
			System.out.println("Student ID already exists." + student.getName());
		}
	}

	/**
	 * Remove Student From management given by id that given by user
	 * 
	 * @param id
	 */
	public void removeStudent(int id) {
		Student student1 = studentMap.get(id);
		if (student1 != null) {
			students.remove(student1);
			studentTreeSet.remove(student1);
			studentMap.remove(student1);
			System.out.println("Remove Successfully ");
		} else {
			System.out.println("Student not found");
		}
	}

	/**
	 * Updating Student Details with Existing student id
	 * 
	 * @param id
	 * @param name
	 * @param age
	 * @param grade
	 * @param address
	 */
	public void updateStudent(int id, String name, int age, String grade, String address) {
		Student student = studentMap.get(id);
		if (student != null) {
			studentTreeSet.remove(student);
			student.setId(id);
			student.setName(name);
			student.setAge(age);
			student.setGrade(grade);
			student.setAddress(address);
			students.add(student);
			studentTreeSet.add(student);
			studentMap.put(student.getId(), student);
			System.out.println("Update Successfully " + student.getName());
		} else {
			System.out.println("Student not found ");
		}
	}

	/**
	 * Searching Student for Given by id
	 * 
	 * @param id
	 * @return
	 */
	public Student searchStudent(int id) {
		return studentMap.get(id);
	}

	/**
	 * Display all Student by Sorting Different option given by user
	 * 
	 * @param attribute
	 */
	public void displayAllStudent(String attribute) {
		if (attribute.equalsIgnoreCase("id") || attribute.equalsIgnoreCase("name") || attribute.equalsIgnoreCase("age")
				|| attribute.equalsIgnoreCase("grade") || attribute.equalsIgnoreCase("address")) {
			switch (attribute) {

			case "name":
				Set<Student> studentName = displyStudentByName();
				for (Student student : studentName) {
					System.out.println(student);
				}
				break;
			case "age":
				Set<Student> studentAge = displyStudentByAge();
				for (Student student : studentAge) {
					System.out.println(student);
				}
				break;
			case "grade":
				Set<Student> studentGrade = displaystudentByGrade();
				for (Student student : studentGrade) {
					System.out.println(student);
				}
				break;
			case "address":
				Set<Student> studentAddress = displaystudentByAddress();
				for (Student student : studentAddress) {
					System.out.println(student);
				}
				break;
			default:
				for (Student student : studentTreeSet) {
					System.out.println(student);
				}
			}
		} else {
			System.out.println("Invalid Student attribute");
		}
	}

	private Set<Student> displyStudentByName() {
		TreeSet<Student> treeset = new TreeSet(Comparator.comparing(Student::getName));
		treeset.addAll(studentTreeSet);
		return treeset;
	}

	private Set displyStudentByAge() {
		TreeSet<Student> treeset = new TreeSet(Comparator.comparingInt(Student::getAge));
		treeset.addAll(studentTreeSet);
		return treeset;
	}

	private Set<Student> displaystudentByGrade() {
		TreeSet<Student> treeset = new TreeSet(Comparator.comparing(Student::getGrade));
		treeset.addAll(studentTreeSet);
		return treeset;
	}

	private Set<Student> displaystudentByAddress() {
		TreeSet<Student> treeset = new TreeSet(Comparator.comparing(Student::getAddress));
		treeset.addAll(studentTreeSet);
		return treeset;
	}

	/**
	 * Save all Data in File.We are using a BufferedWriter to write data.
	 * 
	 * @param students.dat
	 */
	public void saveToFile(String filename) {
		try (BufferedWriter br = new BufferedWriter(new FileWriter(filename))) {
			for (Student student : students) {
				br.write(student.toString());
				br.newLine();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Read all Data in File.We are using a BufferedReader to read data from file
	 * and that data is convert into string for getting and then convert into
	 * Student object that object are stored into Collection
	 * 
	 * @param students.dat
	 */
	public void loadFromFile(String filename) {
		try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
			String line;
			while ((line = br.readLine()) != null) {
				if (!line.isBlank()) {
					Student student = Student.fromString(line);
					students.add(student);
					studentMap.put(student.getId(), student);
					studentTreeSet.add(student);
				} else {
					System.out.println("File " + filename + " is Empty");
				}
			}
		} catch (IOException e) {
			System.out.println("Error loading file: " + e.getMessage());
		}
	}
}
