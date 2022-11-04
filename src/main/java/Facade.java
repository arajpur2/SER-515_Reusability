import java.io.*;

/**
 * Title: HACS Description: Copyright: Copyright (c) 2002 Company: msu
 *
 * @author Alok Rajpurohit, arajpur@asu.edu
 * @version 1.0
 * @author mjfindler
 * @version 2.0
 * Update to Java 8
 */

public class Facade {
	private Course theSelectedCourse = null;
	private int nCourseLevel = 0;
	ClassCourseList theCourseList;
	Person thePerson;

	public Facade() {
	}

	// initialize and display the login GUI
	static public boolean login(UserInfoItem userinfoItem) {
		Login login = new Login();
		login.setModal(true);
		login.setVisible(true);
		userinfoItem.strUserName = login.getUserName();
		userinfoItem.UserType = login.getUserType();
		return login.isExit();
	}


	/*
	 * When click the add button of the CourseMenu , you call this function.
	 * to fill an assignment with the required information.
	 * It will call InstructorAssignmentMenu or StudentAssignmentMenu according to the
	 * type of the user.
	 * it will not update the course menu.
	 * the courseMenu needs to refreshed outside this function
	 */
	void addAssignment(Course theCourse) {
		AssignmentMenu theAssignmentMenu;
		if (thePerson.type == 0)/// student
		{
			theAssignmentMenu = new StudentAssignmentMenu();
		} else {
			theAssignmentMenu = new InstructorAssignmentMenu();
		}
		Assignment theAssignment = new Assignment();
		theAssignmentMenu.showMenu(theAssignment, thePerson);
		theCourse.addAssignment(theAssignment);
	}


	/*
	 * When you click the view button of the CourseMenu , this function is called
	 * a pointer of the assignment and the person is also passed to this function.
	 * It will call InstructorAssignmentMenu or StudentAssignmentMenu according to the
	 * type of the user.
	 * it will not update the course menu.
	 */
	void viewAssignment(Assignment theAssignment) {
		AssignmentMenu theAssignmentMenu;
		if (thePerson.type == 0)/// student
		{
			theAssignmentMenu = new StudentAssignmentMenu();
		} else {
			theAssignmentMenu = new InstructorAssignmentMenu();
		}

		theAssignmentMenu.showMenu(theAssignment, thePerson);
	}

	/*
	 * to grade the given Solution
	 */
	@SuppressWarnings("unused")
	void gradeSolution(Solution theSolution) {
		SolutionMenu solutionMenu = new SolutionMenu();
		solutionMenu.ShowMenu(theSolution);
	}

	/*
	* to save and publish/update the grade in the student object
	* */
	@SuppressWarnings("unused")
	void reportSolutions(Assignment theAssignment) {
		Solution theSolution;
		SolutionIterator theSolutionIterator;
		theSolutionIterator = theAssignment.getSolutionIterator();
		theSolution = (Solution) theSolutionIterator.next();
		while (theSolution != null) {
			theSolution.setReported(true);
			theSolution = (Solution) theSolutionIterator.next();
		}
	}


	// to save/add the solution in the solution list
    @SuppressWarnings("unused")
    void submitSolution(Assignment theAssignment, Solution theSolution) {
		theAssignment.addSolution(theSolution);
	}

	// to create a new reminder
	void remind() {
		Reminder theReminder = new Reminder();
		theReminder.showReminder();
	}

	// to create a new user object (new user info)
	void createUser(UserInfoItem userinfoitem) {
		if (userinfoitem.UserType == UserInfoItem.USER_TYPE.Student) {
			thePerson = new Student();
		} else {
			thePerson = new Instructor();
		}
		thePerson.UserName = userinfoitem.strUserName;
	}

	/*
	 * create a course list and initialize it with the file CourseInfo.txt
	 */
	void createCourseList() {
		theCourseList = new ClassCourseList();
		theCourseList.initializeFromFile("CourseInfo.txt");
	}

	/*
	 * call this function after creating user, creating course list
	 * read user:course database/file
	 * to match the course name with course list
	 * add the matched course object to the new user object's course list
	 */
	void attachCourseToUser() {
		BufferedReader file;
		try {
			file = new BufferedReader(new FileReader("UserCourse.txt"));
			String aline, strUserName, strCourseName;
			while ((aline = file.readLine()) != null) // not the EOF
			{
				strUserName = getUserName(aline);
				strCourseName = getCourseName(aline);
				if (strUserName.compareTo(thePerson.UserName) == 0) /// the UserName mateches
				{
					theSelectedCourse = findCourseByCourseName(strCourseName);
					if (theSelectedCourse != null) /// Find the Course in the CourseList--->attach
					{
						thePerson.addCourse(theSelectedCourse);
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/*
	 * get the username from text file line format UserName:CourseName
	 */
	private String getUserName(String aline) {
		int Sep = aline.lastIndexOf(':');
		return aline.substring(0, Sep);
	}

	/*
	 * get the CourseName from text file line format UserName:CourseName
	 */
	private String getCourseName(String aline) {
		int Sep = aline.lastIndexOf(':');
		return aline.substring(Sep + 1);
	}

	/*
	 * show the course selection dialog, show the course attached to the person
	 * return the selected course and assign the course
	 */
	public boolean selectCourse() {
		CourseSelectDlg theDlg = new CourseSelectDlg();
		theSelectedCourse = theDlg.ShowDlg(thePerson.CourseList);
		thePerson.CurrentCourse = theSelectedCourse;
		nCourseLevel = theDlg.nCourseLevel;
		return theDlg.isLogout();
	}

	// add the selected course object to the menu
	public boolean courseOperation() {
		thePerson.createCourseMenu(theSelectedCourse, nCourseLevel);
		return thePerson.showMenu();
	}

	/*
	 * find the course in theCourseList that matches strCourseName 1 create a
	 * CourseIterator for the List 2 Find the Course with the Iterator return the
	 * pointer of the Course if not fine, return null;
	 */
	private Course findCourseByCourseName(String strCourseName) {
		CourseIterator Iterator = new CourseIterator(theCourseList);
		return (Course) Iterator.next(strCourseName);
	}

}
