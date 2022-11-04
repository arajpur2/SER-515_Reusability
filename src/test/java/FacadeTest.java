import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class FacadeTest {

	Facade facade = new Facade();

	@Test
	void submitSolution() {
		int expected = 1;
		Assignment theAssignment = new Assignment();
		Solution theSolution = new Solution();
		facade.submitSolution(theAssignment, theSolution);
		assertEquals(expected, theAssignment.getTheSolutionList().size());
	}

	@Test
	void createUser() {
		UserInfoItem userInfoItem = new UserInfoItem();
		userInfoItem.setUserType(UserInfoItem.USER_TYPE.Student);
		facade.createUser(userInfoItem);
		Assertions.assertTrue(facade.thePerson instanceof Student);
	}

	@Test
	void createCourseList() {
		int expected = 8;
		facade.createCourseList();
		assertEquals(expected, facade.theCourseList.size());
	}

	@Test
	void attachCourseToUser() {
		int expected = 2;
		UserInfoItem userInfoItem = new UserInfoItem();
		userInfoItem.setUserType(UserInfoItem.USER_TYPE.Student);
		userInfoItem.strUserName = "alok11";
		facade.createUser(userInfoItem);
		facade.createCourseList();
		facade.attachCourseToUser();
		assertEquals(expected, facade.thePerson.getCourseList().size());
	}

}
