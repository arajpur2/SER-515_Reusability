import java.text.DateFormat;
import java.util.Date;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AssignmentTest {

	Assignment assignment = new Assignment();
	Solution solution = new Solution();

	@Test
	void setDueDate() {
		Date dueDate = new Date();
		assignment.setDueDate(dueDate);
		assertEquals(dueDate, assignment.getDueDate());
	}

	@Test
	void isOverDue() {
		Assertions.assertTrue(assignment.isOverDue());
	}

	@Test
	void addSolution() {
		int expected = 1;
		assignment.addSolution(solution);
		assertEquals(expected, assignment.getTheSolutionList().size());
	}

	@Test
	void submitSolution() {
		assignment.submitSolution();
	}

	@Test
	void getSolution() {
		solution.setTheAuthor("Alok Rajpurohit");
		assignment.addSolution(solution);
		assertEquals("Alok Rajpurohit", assignment.getSolution("Alok Rajpurohit").getTheAuthor());
	}

	@SuppressWarnings("ConstantConditions")
	@Test
	void getSuggestSolution() {
		assertTrue(assignment.getSuggestSolution() instanceof Solution);
	}

	@Test
	void getSolutionIterator() {
		int expected = 0;
		SolutionIterator solutionIterator = assignment.getSolutionIterator();
		assertEquals(expected, solutionIterator.solutionlist.size());
	}

	@Test
	void testToString() {
		String input = "SER515: Testing and Reuse";
		assignment.setAssName(input);
		assertEquals(input, assignment.toString());
	}

	@Test
	void getDueDateString() {
		Date dueDate = new Date();
		assignment.setDueDate(dueDate);
		DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.SHORT);
		assertEquals(dateFormat.format(dueDate), assignment.getDueDateString());
	}

	@Test
	void accept() {
		assignment.accept(new ReminderVisitor());
		assertTrue(assignment.isAccepted());
	}

}
