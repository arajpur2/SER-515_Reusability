import java.util.ArrayList;
import java.io.*;

/**
 * Title: HACS Description: Copyright: Copyright (c) 2002 Company: msu
 *
 * @author Zhang ji Zhu Wei
 * @version 1.0
 * @author mjfindler
 * @version 2.0 update to Java 8
 */

public class ClassCourseList extends ArrayList<Course> {

	public ClassCourseList() {
	}

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
