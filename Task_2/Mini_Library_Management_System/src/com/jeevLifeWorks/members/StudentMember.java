package com.jeevLifeWorks.members;

/**
 * Represent Student Member of the library
 * 
 */

public class StudentMember extends Member {

	// Constructor
	public StudentMember(int memberId, String name) {
		super(memberId, name, 3); // Student can issue up to 3 books.
	}
}
