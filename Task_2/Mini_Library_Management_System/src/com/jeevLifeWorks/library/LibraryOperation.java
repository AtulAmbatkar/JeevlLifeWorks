package com.jeevLifeWorks.library;

import com.jeevLifeWorks.book.Book;
import com.jeevLifeWorks.members.Member;

/**
 * Interface for library operation
 * 
 */

public interface LibraryOperation {

	public boolean issueBook(Book book, Member member);

	public boolean returnBook(Book book, Member member);

}
