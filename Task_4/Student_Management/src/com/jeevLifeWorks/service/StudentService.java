package com.jeevLifeWorks.service;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.jeevLifeWorks.dao.StudentDAO;
import com.jeevLifeWorks.dao.StudentDAOImpl;
import com.jeevLifeWorks.entity.Student;

/**
 * StudentService class represent student CRUD operation with valid business
 * logic
 * 
 */
public class StudentService {

	private StudentDAO studentdao;
	Map<Long, Student> studentMap;

	public StudentService() {
		this.studentdao = new StudentDAOImpl();
		this.studentMap = new HashMap<>();
		/**
		 * here we get all available data in database then put into collections for
		 * easily check if a student exists or to quickly retrieve their data
		 */
		List<Student> list = this.studentdao.getAllStudent();
		for (Student student : list) {
			this.studentMap.put(student.getSid(), student);
		}
	}

	/**
	 * Attempt to add student data in database
	 * 
	 * @param student
	 */
	public void addStudent(Student student) {
		if (!studentMap.containsKey(student.getSid())) {
			this.studentdao.addStudent(student);
			studentMap.put(student.getSid(), student);
		} else {
			System.out.println("Student Id Must be Unique");
		}

	}

	/**
	 * Get all student data in database
	 * 
	 * @return
	 */
	public List<Student> getAllStudent() {
		List<Student> list = studentdao.getAllStudent();
		return list;
	}

	/**
	 * Get student data in database first we check it it present or not in database
	 * if present to get else not
	 * 
	 * @param id
	 * @return
	 */
	public Student getStudentById(long id) {
		Student student = null;
		if (studentMap.containsKey(id)) {
			student = studentdao.getStudentById(id);
			System.out.println("Student found for id: " + id);
		} else {
			System.out.println("Student not found for id: " + id);
		}
		return student;
	}

	/**
	 * Update Student details mapping with id that id present or not in student
	 * table
	 * 
	 * @param student
	 */
	public void updateStudent(Student student) {
		if (studentMap.containsKey(student.getSid())) {
			studentdao.updateStudent(student);
			studentMap.put(student.getSid(), student);
		} else {
			System.out.println("Student not found for Updataion : " + student.getSid());
		}
	}

	/**
	 * Delete Student record in database to perform delete operation here also
	 * delete operation map with Id that present or not
	 * 
	 * @param id
	 */
	public void deleteStudent(long id) {
		if (studentMap.containsKey(id)) {
			studentdao.deleteStudent(id);
			studentMap.remove(id);
		} else {
			System.out.println("Student not Available for id: " + id);
			Collection<Student> list2 = studentMap.values();
			for (Student in : list2) {
				System.out.println("in: " + in);
			}
		}
	}
}
