import java.util.Iterator;

/**
 * Title:        HACS
 * Description:
 * Copyright:    Copyright (c) 2002
 * Company:      msu
 * @author Alok Rajpurohit, arajpur@asu.edu
 * @version 1.0
 */

@SuppressWarnings("rawtypes")
public class CourseIterator implements Iterator {

  ClassCourseList theCourseList;
  int CurrentCourseNumber=-1;

  // constructor
  public CourseIterator() {
  }

  // parameterized constructor
  public CourseIterator(ClassCourseList courseList)
  {
    theCourseList=courseList;
  }

  // getter for the course list
  public ClassCourseList getTheCourseList() {
    return theCourseList;
  }

  // to check if the course list has a course at the next index
  public boolean hasNext() {
    return CurrentCourseNumber < theCourseList.size() - 1;
  }

  // to get the course at the next index in the course list
  public Object next() {
    if (hasNext()) {
      CurrentCourseNumber ++;
      return theCourseList.get(CurrentCourseNumber);
    }
    else {
      return null;
    }
  }

  // to remove the current course from the course list
  public void remove()
  {
    theCourseList.remove(CurrentCourseNumber);
  }

  // to get the next course with the given course name in the course list
  public Object next(String CourseName) {
    Course theCourse;
    theCourse=(Course)next();
    while(theCourse!=null) {
      if(CourseName.compareTo(theCourse.toString())==0) {
        return theCourse;
      }
      theCourse=(Course)next();
    }
    return null;
  }


}
