package com.jeevLifeWorks.library;

import com.jeevLifeWorks.book.Book;

/**
 * Represent librarian responsible for managing books in the library
 * 
 */

public class Librarian {
	private Library library;

	// Constructor
	public Librarian(Library library) {
		this.library = library;
	}

	// Method to add a book to the library
	public void addBook(Book book) {
		library.addBook(book);
	}

	// Method to remove a book from the library
	public void removeBook(Book book) {
		library.removeBook(book);
	}
}