import java.util.Iterator;
import java.util.*;

/**
 * Title: HACS Description: Copyright: Copyright (c) 2002 Company: msu
 *
 * @author Alok Rajpurohit, arajpur@asu.edu
 * @version 1.0
 * @author mjfindler
 * @version 2.0
 *
 * update to Java 8
 */

/*
 * this class will iterate the course list attached to on student and in turn
 * iterate the assignments of a course. after Function Visit(CourseList) it will
 * point to the location before the fist class, hasNext will rerun weather
 * there is next item. the next() will return the next Item Assignment;
 */

public class ReminderVisitor extends NodeVisitor {

	Reminder mReminder;

	// constructor
	public ReminderVisitor() {
	}

	// parameterized constructor
	public ReminderVisitor(Reminder reminder) {
		this.mReminder = reminder;
	}

	public void visitFacade(Facade facade) {
		CourseIterator courseList = new CourseIterator(facade.theCourseList);
		while (courseList.hasNext()) {
			Course course = (Course) courseList.next();
			course.accept(this);
		}
	}

	// getter for the reminder object
	public Reminder getmReminder() {
		return mReminder;
	}

	// to visit and mark a course object
	public void visitCourse(Course course) {
		Iterator<Assignment> assignmentList = course.assignmentList.listIterator();
		if (assignmentList.hasNext()) {
			do {
				Assignment assignment = assignmentList.next();
				assignment.accept(this);
			} while (assignmentList.hasNext());
		}
	}

	// to visit and mark an assignment object
	public void visitAssignment(Assignment assignment) {
		Date today = new Date();
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(today);
		int nToday = calendar.get(Calendar.DAY_OF_YEAR);
		calendar.setTime(assignment.dueDate);
		int nDueDate = calendar.get(Calendar.DAY_OF_YEAR);
		if(mReminder != null){
			if (nDueDate <= (nToday + 1) && nDueDate >= nToday) {
				mReminder.listUpcoming.add("today is " + today + " " + assignment.assName + " Due Date is " + assignment.getDueDateString());
			}
			if (nDueDate < nToday) {
				mReminder.listOverdue.add(assignment.assName + " Due Date is " + assignment.getDueDateString());
			}
		}

	}

}
