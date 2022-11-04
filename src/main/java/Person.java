import java.util.*;

/**
 * Title: HACS Description: CSE870 Homework 3: Implementing Design Patterns
 * Copyright: Copyright (c) 2002 Company: Department of Computer Science and
 * Engineering, Michigan State University
 *
 * @author Ji Zhang, Wei Zhu
 * @version 1.0
 */

abstract public class Person {
	int type = 0; // type=0 : student, type=1 instructor
	String UserName;
	ClassCourseList CourseList;
	CourseMenu theCourseMenu;
	Course CurrentCourse;

	public Person() {
		CourseList = new ClassCourseList();
	}

	abstract public CourseMenu createCourseMenu(Course theCourse, int theLevel);

	public void showAddButton() {
		theCourseMenu.showAddButtons();
	}

	public void showViewButtons() {
		theCourseMenu.showViewButtons();
	}

	public void showComboxes() {
		theCourseMenu.showComboxes();
	}

	public void showRadios() {
		theCourseMenu.showRadios();
	}

	public void show() {
		theCourseMenu.setVisible(true);
	}

	public boolean ifLogout() {
		return theCourseMenu.ifLogout();
	}

	// show the assignment list
	@SuppressWarnings("rawtypes")
	public boolean showMenu() {
		Iterator iterator = CurrentCourse.assignmentList.iterator();
		theCourseMenu.theCourse = CurrentCourse;
		Assignment theAssignment;
		while (iterator.hasNext()) {
			theAssignment = (Assignment) iterator.next();
			theCourseMenu.assignmentCombo.addItem(theAssignment);
		}
		return false;
	}

	public ClassCourseList getCourseList() {
		return CourseList;
	}

	public void addCourse(Course theCourse) {
		CourseList.add(theCourse);
	}
}
