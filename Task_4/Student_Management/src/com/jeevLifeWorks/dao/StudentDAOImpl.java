package com.jeevLifeWorks.dao;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.jeevLifeWorks.entity.Student;

/**
 * StudentDAOImpl class interact with MySQL Database. App and database bridge
 * between them DriverManager
 */
public class StudentDAOImpl implements StudentDAO {

	private static final String URL = "jdbc:mysql://localhost:3306/studentmanagement";
	private static final String UNAME = "root";
	private static final String PASS = "root";

	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("MySQL JDBC driver loaded successfully.");
		} catch (ClassNotFoundException e) {
			System.out.println("Failed to load mySQL JDBC driver." + e.getMessage());
		}
	}

	/**
	 * ADD student record in database.
	 */
	@Override
	public void addStudent(Student student) {
		String query = "INSERT INTO students(sid,sname,sage,sgrade,saddress) VALUES (?,?,?,?,?);";
		System.out.println("Attempting to add student to the database...");
		try {

			// Get connection
			try (Connection connection = DriverManager.getConnection(URL, UNAME, PASS);
					// Prepare statement
					PreparedStatement pstmt = connection.prepareStatement(query)) {

				// Set parameters for the query (assuming getters in the Student class)
				pstmt.setInt(1, (int) student.getSid());
				pstmt.setString(2, student.getSname());
				pstmt.setInt(3, student.getSage());
				pstmt.setString(4, student.getSgrade());
				pstmt.setString(5, student.getSaddress());
				pstmt.executeUpdate();
				System.out.println("Added Student Record.");
			}
		} catch (SQLException e) {
			System.out.println("Failed to add student " + e.getMessage());
		}
	}

	/**
	 * get all student record in database create connection them and get it.
	 */
	@Override
	public List<Student> getAllStudent() {
		String query = "SELECT * FROM students";
		System.out.println("Attempting to getting all student record to the database...");
		List<Student> list = null;

		// Get connection
		try (Connection connection = DriverManager.getConnection(URL, UNAME, PASS);
				// Prepare statement
				PreparedStatement pstmt = connection.prepareStatement(query)) {
			try (ResultSet resultSet = pstmt.executeQuery()) {
				list = new ArrayList<>();
				while (resultSet.next()) {
					Student student = new Student();
					// Set parameter for query
					student.setSid(resultSet.getLong(1));
					student.setSname(resultSet.getString(2));
					student.setSage(resultSet.getInt(3));
					student.setSgrade(resultSet.getString(4));
					student.setSaddress(resultSet.getString(5));
					list.add(student);
				}
			}
		} catch (SQLException e) {
			System.out.println("Failed to getAll student " + e.getMessage());
		}
		return list;
	}

	/**
	 * Get one record that available in database with proper validation.
	 */
	@Override
	public Student getStudentById(long id) {
		String query = "SELECT * FROM students WHERE SID=? ";
		System.out.println("Attempting to get student details to the database...");
		Student student = null;

		// Get connection
		try (Connection connection = DriverManager.getConnection(URL, UNAME, PASS);
				// Prepare statement
				PreparedStatement pstmts = connection.prepareStatement(query)) {
			pstmts.setLong(1, id);
			try (ResultSet resultSet = pstmts.executeQuery()) {
				student = new Student();
				while (resultSet.next()) {
					// Set parameter for query
					student.setSid(resultSet.getLong(1));
					student.setSname(resultSet.getString(2));
					student.setSage(resultSet.getInt(3));
					student.setSgrade(resultSet.getString(4));
					student.setSaddress(resultSet.getString(5));
				}
			}
		} catch (SQLException e) {
			System.out.println("Failed to get studetn by id " + e.getMessage());
		}
		return student;
	}

	/**
	 * Update Student record that available id in students table.
	 */
	@Override
	public void updateStudent(Student student1) {
		String query = "UPDATE students SET SNAME=?,SAGE=?,SGRADE=?,SADDRESS=? WHERE SID = ?";
		System.out.println("Attempting to Update student to the database...");
		Student student = student1;

		// Get connection
		try (Connection connection = DriverManager.getConnection(URL, UNAME, PASS);
				// Prepare statement
				PreparedStatement pstmts = connection.prepareStatement(query)) {
			// Set parameter for query
			pstmts.setString(1, student.getSname());
			pstmts.setInt(2, student.getSage());
			pstmts.setString(3, student.getSgrade());
			pstmts.setString(4, student.getSaddress());
			pstmts.setLong(5, student.getSid());
			pstmts.executeUpdate();
			System.out.println("Update Student Record.");
		} catch (SQLException e) {
			System.out.println("Failed to update " + e.getMessage());
		}
	}

	/**
	 * Delete student record in database.
	 */
	@Override
	public void deleteStudent(long id) {
		String query = "DELETE FROM students WHERE SID=?";
		System.out.println("Attempting to delete student to the database...");
		// Get connection
		try (Connection connection = DriverManager.getConnection(URL, UNAME, PASS);
				// Prepare statement
				PreparedStatement pstmts = connection.prepareStatement(query)) {
			// Set parameter for query
			pstmts.setLong(1, id);
			pstmts.executeUpdate();
			System.out.println("Delete one Student Record.");
		} catch (SQLException e) {
			System.out.println("Failed to delete record in database " + e.getMessage());
		}
	}

}
