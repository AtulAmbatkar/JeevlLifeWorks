package com.jeevLifeWorks.members;

/**
 * Represent Teacher Member of the library
 *
 */

public class TeacherMember extends Member {

	// Constructor
	public TeacherMember(int memberId, String name) {
		super(memberId, name, 5); // Teacher can issue up to 5 books.
	}
}