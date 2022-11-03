import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

@SuppressWarnings("unused")
class ListIteratorTest {

	ListIterator listIterator = new ListIterator();

	@Test
	void listIteratorArrayListOfObject() {
		int expected = 1;
		ArrayList<Object> testList = new ArrayList<>();
		testList.add(1);
		ListIterator listIterator = new ListIterator(testList);
		assertEquals(expected, listIterator.getTheList().size());
	}

	@Test
	void hasNext() {
		ArrayList<Object> testList = new ArrayList<>();
		testList.add(1);
		ListIterator listIterator = new ListIterator(testList);
		assertTrue(listIterator.hasNext());
	}

	@Test
	void next() {
		ArrayList<Object> testList = new ArrayList<>();
		testList.add(1);
		ListIterator listIterator = new ListIterator(testList);
		Assertions.assertNotNull(listIterator.next());
	}

	@Test
	void testRemove() {
		int expected = 0;
		ArrayList<Object> testList = new ArrayList<>();
		testList.add(1);
		ListIterator listIterator = new ListIterator(testList);
		listIterator.next();
		listIterator.remove();
		assertEquals(expected, listIterator.getTheList().size());
	}

}
