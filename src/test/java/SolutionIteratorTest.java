import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class SolutionIteratorTest {

	SolutionList solutionList = new SolutionList();
	Solution solution = new Solution();

	@Test
	void solutionIterator() {
		new SolutionIterator();
	}

	@Test
	void solutionIteratorSolutionList() {
		solutionList.add(solution);
		SolutionIterator solutionIterator = new SolutionIterator(solutionList);
		assertTrue(solutionIterator.hasNext());
	}

	@Test
	void moveToHead() {
		int expected = -1;
		solutionList.add(solution);
		SolutionIterator solutionIterator = new SolutionIterator(solutionList);
		solutionIterator.moveToHead();
		assertEquals(expected, solutionIterator.getCurrentSolutionNumber());
	}

	@Test
	void hasNext() {
		solutionList.add(solution);
		SolutionIterator solutionIterator = new SolutionIterator(solutionList);
		assertTrue(solutionIterator.hasNext());
	}

	@Test
	void next() {
		solutionList.add(solution);
		SolutionIterator solutionIterator = new SolutionIterator(solutionList);
		assertNotNull(solutionIterator.next());
	}

	@Test
	void nextString() {
		solution.setTheAuthor("Alok Rajpurohit");
		solutionList.add(solution);
		SolutionIterator solutionIterator = new SolutionIterator(solutionList);
		assertNotNull(solutionIterator.next("Alok Rajpurohit"));
	}

	@Test
	void remove() {
		int expected = 0;
		solutionList.add(solution);
		SolutionIterator solutionIterator = new SolutionIterator(solutionList);
		solutionIterator.next();
		solutionIterator.remove();
		assertEquals(expected, solutionIterator.solutionlist.size());
	}

}
