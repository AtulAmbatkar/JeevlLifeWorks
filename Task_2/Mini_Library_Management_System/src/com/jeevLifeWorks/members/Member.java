package com.jeevLifeWorks.members;

import java.util.List;
import java.util.ArrayList;
import com.jeevLifeWorks.book.Book;
/** Represent Members of the library
 * 
 */
public class Member {

	private int memberId;
	private String name;
	private int maxBooksIssued;
	private List<Book> currentIssuedBooks;

	// Constructor
	public Member(int memberId, String name, int maxBooksIssued) {
		this.memberId = memberId;
		this.name = name;
		this.maxBooksIssued = maxBooksIssued;
		this.currentIssuedBooks = new ArrayList<>();
	}

	// Getters
	public int getMemberId() {
		return memberId;
	}

	public String getName() {
		return name;
	}

	public int getMaxBooksIssued() {
		return maxBooksIssued;
	}

	public List<Book> getCurrentIssuedBooks() {
		return currentIssuedBooks;
	}

	// setters for set name and Nu.Of books can issue a Member
	public void setName(String name) {
		this.name = name;
	}

	public void setMaxBooksIssued(int maxBooksIssued) {
		if (maxBooksIssued >= 0) {
			this.maxBooksIssued = maxBooksIssued;
		} else {
			throw new IllegalArgumentException("Max books issued cannot be negative");
		}
	}

	// Method to issue book and return book
	public void issueBook(Book book) {
		System.out.println("Book issued to '" + this.getName() + "': " + book.getBookTitle());

		currentIssuedBooks.add(book);
		
//		System.out.println("Book issued to '" + this.getName() + "': " + book.getBookTitle());
	}

	public void returnBook(Book book) {
		currentIssuedBooks.remove(book);
		System.out.println("Book returned by '" + this.getName() + "' : " + book.getBookTitle());
	}

	@Override
	public String toString() {
		return "Member [memberId=" + memberId + ", name=" + name + "]";
	}

}
