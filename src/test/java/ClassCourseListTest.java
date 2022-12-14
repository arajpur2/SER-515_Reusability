import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class ClassCourseListTest {

	ClassCourseList classCourseList = new ClassCourseList();

	@Test
	void testInitializeFromFile() {
		classCourseList.initializeFromFile("CourseInfo.txt");
		assertEquals(8, classCourseList.size());
	}

	@Test
	void testFindCourseByCourseName() {
		String courseName = "SER515";
		classCourseList.initializeFromFile("CourseInfo.txt");
		assertEquals(courseName, classCourseList.findCourseByCourseName(courseName).toString());
	}

}
