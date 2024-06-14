package com.jeevLifeWorks.entity;

import java.util.Objects;

/**
 * Student class represent Student details
 */
public class Student {

	private long sid;
	private String sname;
	private int sage;
	private String sgrade;
	private String saddress;

	// constructor
	public Student() {
		super();
	}

	// Constructor
	public Student(long sid, String sname, int sage, String sgrade, String saddress) {
		super();
		this.sid = sid;
		this.sname = sname;
		this.sage = sage;
		this.sgrade = sgrade;
		this.saddress = saddress;
	}

	/**
	 * Getter & Setters method for getting reading details
	 * 
	 * @return
	 */
	public long getSid() {
		return sid;
	}

	public void setSid(long sid) {
		this.sid = sid;
	}

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public int getSage() {
		return sage;
	}

	public void setSage(int sage) {
		this.sage = sage;
	}

	public String getSgrade() {
		return sgrade;
	}

	public void setSgrade(String sgrade) {
		this.sgrade = sgrade;
	}

	public String getSaddress() {
		return saddress;
	}

	public void setSaddress(String saddress) {
		this.saddress = saddress;
	}

	/**
	 * The hashCode method helps determine the bucket in which an object will be
	 * stored.
	 */
	@Override
	public int hashCode() {
		return Objects.hash(saddress, sage, sgrade, sid, sname);
	}

	/**
	 * equals methods represent available data are equal or not
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		return Objects.equals(saddress, other.saddress) && sage == other.sage && Objects.equals(sgrade, other.sgrade)
				&& sid == other.sid && Objects.equals(sname, other.sname);
	}

	// represent details
	@Override
	public String toString() {
		return "Student [sid=" + sid + ", sname=" + sname + ", sage=" + sage + ", sgrade=" + sgrade + ", saddress="
				+ saddress + "]";
	}

}
