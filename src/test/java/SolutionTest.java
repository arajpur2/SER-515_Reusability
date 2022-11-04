import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class SolutionTest {

	Solution solution = new Solution();

	@Test
	void ToString() {
		solution.setTheAuthor("Alok Rajpurohit");
		solution.setSolutionFileName("Solution");
		assertEquals("Alok Rajpurohit Solution Grade = 0 (not reported)", solution.toString());
	}

	@Test
	void getGradeString() {
		String expected = "-1";
		assertEquals(expected, solution.getGradeString());
	}

	@Test
	void getGradeInt() {
		int expected = 0;
		assertEquals(expected, solution.getGradeInt());
	}

	@Test
	void setReported() {
		solution.setReported(true);
		assertTrue(solution.isReported());
	}

	@Test
	void isReported() {
		solution.setReported(true);
		assertTrue(solution.isReported());
	}

}
