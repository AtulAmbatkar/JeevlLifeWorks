package com.jeevLifeWorks.dao;

import java.util.List;

import com.jeevLifeWorks.entity.Student;

/**
 * StudentDAO class present CRUD operation Interact With Database
 */
public interface StudentDAO {

	public void addStudent(Student student);

	public List<Student> getAllStudent();

	public Student getStudentById(long id);

	public void updateStudent(Student student);

	public void deleteStudent(long id);

}
