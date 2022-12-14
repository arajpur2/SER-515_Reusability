import java.util.ArrayList;
import java.io.*;

/**
 * Title: HACS Description: Copyright: Copyright (c) 2002 Company: msu
 *
 * @author Alok Rajpurohit, arajpur@asu.edu
 * @version 1.0
 * @author mjfindler
 * @version 2.0 update to Java 8
 */

public class ClassCourseList extends ArrayList<Course> {

	// constructor
	public ClassCourseList() {
	}

	/*
	* Reading course data from the database(text file)
	* */
	// initialize the list by reading from the file.
	@SuppressWarnings({"SameParameterValue", "unused"})
	void initializeFromFile(String theFileName) {
		try {
			BufferedReader file;
			String strCourseName;
			file = new BufferedReader(new FileReader("CourseInfo.txt"));
			while ((strCourseName = file.readLine()) != null) {
				Course theCourse;
				theCourse = new Course(strCourseName, 0);
//      theCourse.CourseName= strCourseName;
				add(theCourse);
			}
		} catch (Exception e) {
			System.out.println("DATABASE READ ERROR");
		}
	}

	/*
	* searching for a course by course name in the course database (text file)
	* */
	Course findCourseByCourseName(String courseName) {
		for (Course course : this) {
			Course theCourse;
			theCourse = course;
			if (theCourse.courseName.compareTo(courseName) == 0)
				return theCourse;
		}
		return null;
	}

}
