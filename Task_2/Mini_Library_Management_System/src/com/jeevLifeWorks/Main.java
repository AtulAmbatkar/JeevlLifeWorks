package com.jeevLifeWorks;

import java.util.ArrayList;
import java.util.List;
import com.jeevLifeWorks.book.Book;
import com.jeevLifeWorks.library.*;
import com.jeevLifeWorks.members.*;

/** Main class to demonstrate library operation
 * 
 */

public class Main {

	public static void main(String[] args) {

		// Create library instance
		Library library = new Library();
		// Create librarian instance
		Librarian librarian = new Librarian(library);

		// Create some Book that are added in library and remove from library
		Book book1 = new Book(1, "An Uncommon Love: The Early Life of Sudha and Narayana Murthy",
				"Chitra Banerjee Divakaruni");
		Book book2 = new Book(2, "Pride and Prejudice", "Jane Austen");
		Book book3 = new Book(3, "The Idiot", "Fyodor Dostoyevsky");
		Book book4 = new Book(3, "The Book Thief", "Markus Zusak");
		Book book5 = new Book(5, "Communicating with Data", "Carl Allchin");

		// Books added in the library
		System.out.println("Book added to the Library: ");
		librarian.addBook(book1);
		librarian.addBook(book2);
		librarian.addBook(book3);
		librarian.addBook(book4);

		// List books available in the library
		System.out.println("\nBook Available in the library: ");
		for (Book book : library.getBooks()) {
			System.out.println(book.getBookTitle());
		}

		// Create Student Member to library
		Member student1 = new StudentMember(100, "Atul");
		Member student2 = new StudentMember(101, "rushi");

		// Create Teacher Member to library
		Member teacher1 = new TeacherMember(1000, "Sunita madam");
		Member teacher2 = new TeacherMember(1001, "Matpati sir");

		// Create some other Members
		Member staff = new Member(500, "Rahul", 2);

		// Issue books to Members
		System.out.println("\nIssuing Books to Members:");
		library.issueBook(book1, teacher1);
		library.issueBook(book2, student1);
		library.issueBook(book3, teacher2);
		library.issueBook(book4, student2);

		// Return books from Members
		System.out.println("\nReturning books from members: ");
		library.returnBook(book3, teacher2);
		library.returnBook(book5, student1); // This should fail as book5 was not issued
		library.returnBook(book1, teacher1);

		// List of books available in the library after issuing
		System.out.println("\nBook Available in the library: ");
		for (Book book : library.getBooks()) {
			System.out.println(book.getBookTitle());
		}

		// Attempt to remove a book
		librarian.removeBook(book3);
		librarian.removeBook(book3); // This should fail as book3 is already remove

	}
}
