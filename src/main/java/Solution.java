import java.util.*;

/**
 * Title: HACS Description: CSE870 Homework 3: Implementing Design Patterns
 * Copyright: Copyright (c) 2002 Company: Department of Computer Science and
 * Engineering, Michigan State University
 *
 * @author Alok Rajpurohit, arajpur@asu.edu
 * @version 1.0
 * @author mjfindler
 * @version 2.0
 *
 * update to Java 8
 */

public class Solution {
	String theAuthor = "";
	String solutionFileName = "";
	Date theSubmitData = new Date();
	int theGrade;
	boolean reported = false;

	// constructor
	public Solution() {
	}

	// to return the string of the student solution and grade
	@Override
	public String toString() {
		String string;
		string = theAuthor + " " + solutionFileName + " Grade = " + getGradeInt() + " ";
		if (isReported())
			string += "(reported)";
		else
			string += "(not reported)";

		return (string);
	}

	// to return the string type of the grade
	String getGradeString() {
		if (isReported())
			return "" + theGrade;
		else
			return "-1";
	}


	/*
	* getters and setters for all the fields
	* */
	int getGradeInt() {
		return theGrade;
	}

	public void setReported(boolean reported) {
		this.reported = reported;
	}

	public boolean isReported() {
		return reported;
	}

	public void setSolutionFileName(String solutionFileName) {
		this.solutionFileName = solutionFileName;
	}

	public String getTheAuthor() {
		return theAuthor;
	}

	public void setTheAuthor(String theAuthor) {
		this.theAuthor = theAuthor;
	}
}
