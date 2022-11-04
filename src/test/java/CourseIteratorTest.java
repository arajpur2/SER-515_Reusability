import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CourseIteratorTest {

	CourseIterator courseIterator = new CourseIterator();
	ClassCourseList classCourseList = new ClassCourseList();

	@Test
	void courseIteratorClassCourseList() {
		int expected = 1;
		Course course = new Course("SER515", 1);
		classCourseList.add(course);
		courseIterator = new CourseIterator(classCourseList);
		assertEquals(expected, courseIterator.getTheCourseList().size());
	}

	@Test
	void hasNext() {
		Course course = new Course("SER515", 1);
		classCourseList.add(course);
		CourseIterator courseIterator = new CourseIterator(classCourseList);
		Assertions.assertTrue(courseIterator.hasNext());
	}

	@Test
	void next() {
		Course course = new Course("SER515", 1);
		classCourseList.add(course);
		CourseIterator courseIterator = new CourseIterator(classCourseList);
		Assertions.assertNotNull(courseIterator.next());
	}

	@Test
	void remove() {
		int expected = 0;
		Course course = new Course("SER515", 1);
		classCourseList.add(course);
		CourseIterator courseIterator = new CourseIterator(classCourseList);
		courseIterator.next();
		courseIterator.remove();
		assertEquals(expected, courseIterator.getTheCourseList().size());
	}

	@Test
	void nextString() {
		Course course = new Course("SER515", 1);
		classCourseList.add(course);
		CourseIterator courseIterator = new CourseIterator(classCourseList);
		Assertions.assertNotNull(courseIterator.next("SER515"));
	}

}
