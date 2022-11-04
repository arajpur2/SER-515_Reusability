import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CourseTest {

	String strCourse = "SER515";
	int theLevel = 0;
	Course course = new Course(strCourse, theLevel);
	Assignment assignment = new Assignment();

	@Test
	void Course() {
		assertEquals(strCourse, this.course.toString());
		assertEquals(theLevel, this.course.getCourseLevel());
	}

	@Test
	void addAssignment() {
		int expected = 1;
		course.addAssignment(assignment);
		assertEquals(expected, this.course.assignmentList.size());
	}

	@Test
	void testToString() {
		assertEquals(this.strCourse, this.course.toString());
	}

	@Test
	void accept() {
		this.course.accept(new ReminderVisitor());
		Assertions.assertTrue(this.course.isAccepted());
	}

}
