/**
 * Title: HACS Description: Copyright: Copyright (c) 2002 Company: msu
 *
 * @author Alok Rajpurohit, arajpur@asu.edu
 * @version 1.0
 */

public class Instructor extends Person {
	public Instructor() {
		type = 1;// type=1 :instructor
	}


	// to initialize and return the menu of course objects
	public CourseMenu createCourseMenu(Course theCourse, int theLevel) {
		theCourseMenu = new HighLevelCourseMenu();
		return theCourseMenu;
	}

	// to display the full GUI for the course menu
	public boolean showMenu() {
		super.showMenu();
		showAddButton();
		showViewButtons();
		showComboxes();
		showRadios();
		show();
		return ifLogout();
	}
}
