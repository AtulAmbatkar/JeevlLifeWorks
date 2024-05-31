package com.jeevLifeWorks.book;

/**
 * Represent Book in the library
 * 
 */
public class Book {

	private int bookId;
	private String bookTitle;
	private String bookAuthor;
	private boolean isIssued;

	// Constructor
	public Book(int bookId, String title, String author) {
		this.bookId = bookId;
		this.bookTitle = title;
		this.bookAuthor = author;
		this.isIssued = false;
	}

	// Getters
	public int getBookId() {
		return bookId;
	}

	public String getBookTitle() {
		return bookTitle;
	}

	public String getBookAuthor() {
		return bookAuthor;
	}

	public boolean isIssued() {
		return isIssued;
	}

	// Setter for isIssued
	public void setisIssued(boolean isIssued) {
		this.isIssued = isIssued;
	}

	// Setter for change id In Case
	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	@Override
	public String toString() {
		return "Book [bookId=" + bookId + ", bookTitle=" + bookTitle + ", bookAuthor=" + bookAuthor + ", isIssued="
				+ isIssued + "]";
	}

}
