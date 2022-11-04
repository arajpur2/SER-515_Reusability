import java.util.*;

/**
 * Title:        HACS
 * Description:  CSE870 Homework 3:  Implementing Design Patterns
 * Copyright:    Copyright (c) 2002
 * Company:      Department of Computer Science and Engineering, Michigan State University
 * @author Alok Rajpurohit, arajpur@asu.edu
 * @version 1.0
 * @author mjfindler
 * @version 2.0
 * Update to Java 8
 */

public class Course {
  String courseName;
  public ArrayList<Assignment> assignmentList=new ArrayList<>();
  int numOfAss;
  int courseLevel;

  boolean isAccepted;

  // getter for the course level field
  public int getCourseLevel() {
    return courseLevel;
  }

  // constructor
  public Course(String strCourse, int theLevel) {
    this.courseName = strCourse;

   //0: HighLevel    1: LowLevel Experiment
    this.courseLevel = theLevel;
   // this.AssList = NULL;
    this.numOfAss = 0;
    this.isAccepted = false;
  }

  // adding new assignment to the assignment list
  public void addAssignment(Assignment newAss)
  {
    assignmentList.add(newAss);
  }

  // return the String type of the course name field
  public String toString()
  {
    return courseName;
  }

  // to visit and mark a course as accepted
  void accept(NodeVisitor visitor) {
    visitor.visitCourse(this);
    this.isAccepted = true;
  }

  // return if a course has been accepted/visited or not
  public boolean isAccepted() {
    return this.isAccepted;
  }

}
