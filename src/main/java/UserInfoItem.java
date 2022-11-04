/**
 * Title: HACS Description: Copyright: Copyright (c) 2002 Company: msu
 *
 * @author Alok Rajpurohit, arajpur@asu.edu
 * @version 1.0
 * @author mjfindler
 * @version 2.0
 *
 * Update to Java 8
 */

public class UserInfoItem {

	// structure to store the info about the user object
	public enum USER_TYPE { Student, Instructor }

	String strUserName;
	USER_TYPE UserType; // 0 : Student, 1: Instructor

	// setter for the userType field
	public void setUserType(USER_TYPE userType) {
		UserType = userType;
	}
}
