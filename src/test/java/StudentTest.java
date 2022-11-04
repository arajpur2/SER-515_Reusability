import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class StudentTest {

	Student student = new Student();

	@Test
	void student() {
		int expected = 0;
		assertEquals(expected, student.type);
	}

	@Test
	void createCourseMenu() {
		CourseMenu courseMenu = student.createCourseMenu(new Course("SER:515", 0), 0);
		Assertions.assertTrue(courseMenu instanceof HighLevelCourseMenu);
	}

}
