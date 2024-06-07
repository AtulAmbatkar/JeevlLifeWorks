package com.jeevLifeWorks.student;

import java.util.Objects;

/**
 * Student Class represents Student with id,name,age,grade,addresses It
 * Implement Comparable interface for sorting purpose with id
 */

public class Student implements Comparable<Student> {

	private int id;
	private String name;
	private int age;
	private String grade;
	private String address;

	public Student() {
		super();
	}

	// Constructor
	public Student(int id, String name, int age, String grade, String address) {
		if (id <= 0) {
			throw new IllegalArgumentException(
					"ID must be unique and greater than '0' id: " + id + " ,name: " + name + " In File");
		}
		if (age <= 0) {
			throw new IllegalArgumentException(
					"Age Must be Positive Number: " + age + " ,Student Id: " + id + " In File");
		}
		this.id = id;
		this.name = name;
		this.age = age;
		this.grade = grade;
		this.address = address;
	}

	// Getter and Setter
	public int getId() {
		return id;
	}

	public void setId(int id) {
		if (id <= 0) {
			throw new IllegalArgumentException("ID must be unique and greater than '0' id: " + id + " name: " + name);
		}
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		if (age <= 0) {
			throw new IllegalArgumentException("Age Must be Positive Number" + getName());
		}
		this.age = age;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	// ToString
	@Override
	public String toString() {
		return "Student [id=" + id + ", name='" + name + "', age=" + age + ", grade='" + grade + "', address='"
				+ address + "']";
	}

	// hashCode
	@Override
	public int hashCode() {
		return Objects.hash(id, name, age, grade, address);
	}

	// equals
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		return Objects.equals(address, other.address) && age == other.age && Objects.equals(grade, other.grade)
				&& id == other.id && Objects.equals(name, other.name);
	}

	// fromString
	public static Student fromString(String studentString) {
		String[] parts = studentString.substring(studentString.indexOf("[") + 1, studentString.length() - 1)
				.split(", ");

		int id = Integer.parseInt(parts[0].split("=")[1].trim());
		String name = parts[1].split("=")[1].replace("'", "").trim();
		int age = Integer.parseInt(parts[2].split("=")[1].trim());
		String grade = parts[3].split("=")[1].replace("'", "").trim();
		String address = parts[4].split("=")[1].replace("'", "").trim();
		return new Student(id, name, age, grade, address);
	}

	@Override
	public int compareTo(Student other) {
		return Integer.compare(this.getId(), other.getId());
	}

}
