package com.jeevLifeWorks.library;

import java.util.ArrayList;
import java.util.List;
import com.jeevLifeWorks.book.Book;
import com.jeevLifeWorks.members.Member;

/**
 * Represent library where boook and Members
 * 
 */

public class Library implements LibraryOperation {

	private List<Book> books;
	private List<Member> members;

	// Constructor
	public Library() {
		super();
		this.books = new ArrayList<>();
		this.members = new ArrayList<>();
	}

	// Getters
	public List<Book> getBooks() {
		return books;
	}

	public List<Member> getMembers() {
		return members;
	}

	// Setter for members
	public void setMembers(List<Member> members) {
		this.members = members;
	}

	// Method to add a book to the library
	void addBook(Book book) {
		for (Book book1 : books) {
			if (book1.getBookId() == book.getBookId()) {
				System.out.println("This ID is already used: " + book.getBookId());
				return;
			}
		}
		books.add(book);
		System.out.println("Book added in Library: " + book);
	}

	// Method to remove a book from the library
	void removeBook(Book book) {
		if (books.remove(book)) {
			System.out.println("Book removed from Library: " + book.getBookTitle());
		} else {
			System.out.println("Book Not found in Library: " + book.getBookTitle());
		}
	}

	@Override
	public boolean issueBook(Book book, Member member) {
		if (book.isIssued()) {
			System.out.println("The Book '" + book.getBookTitle() + "' is already issued to another member.");
			return false;
		}
		if (member.getCurrentIssuedBooks().size() >= member.getMaxBooksIssued()) {
			System.out.println("the Member '" + member.getName() + "' has already issued maximum number of books.");
			return false;
		} else if (books.contains(book)) {
			book.setisIssued(true);
			member.issueBook(book);
			// removeBook(book);
			books.remove(book); // Remove a book in Library only after successful book is issued
			members.add(member);
			return true;
		} else {
			System.out.println("Book Not found in Library: " + book.getBookTitle());
			return false;
		}
	}

	@Override
	public boolean returnBook(Book book, Member member) {
		if (!book.isIssued()) {
			System.out.println("'" + book.getBookTitle() + "' is not issued ");
			return false;
		}
		if (!member.getCurrentIssuedBooks().contains(book)) {
			System.out.println(
					"the book '" + book.getBookTitle() + "' is not isued to member '" + member.getName() + "'");
			return false;
		} else {
			book.setisIssued(false);
			member.returnBook(book);
			// addBook(book);
			books.add(book); // Added a book in Library only after successfully return a book
			return true;
		}
	}

}