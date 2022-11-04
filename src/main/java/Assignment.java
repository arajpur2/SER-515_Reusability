/**
 * Title:        HACS
 * Description:  CSE870 Homework 3:  Implementing Design Patterns
 * Copyright:    Copyright (c) 2002
 * Company:      Department of Computer Science and Engineering, Michigan State University
 * @author Alok Rajpurohit, arajpur@asu.edu
 * @version 1.0
 */

import java.util.*;
import java.text.DateFormat;

public class Assignment {

  protected String assName;
  protected Date dueDate = new Date();
  protected SolutionList theSolutionList = new SolutionList();
  protected Solution suggestSolution = new Solution();

  protected boolean isAccepted;


  // Constructor
  public Assignment() {
    this.isAccepted = false;
  }

  // setter for the field Due Date
  public void setDueDate(Date theDueDate){
    this.dueDate = theDueDate;
  }

  /*
   to check if the due date field is before current date.
   if so it will indicate that the assignment is overdue
   */
  public boolean isOverDue(){
    Date today;
    today = new Date();
    return today.after(this.dueDate);
  }

  /*
  * to create and return a new solution
  * */
  @SuppressWarnings({"unused", "UnnecessaryLocalVariable"})
  public Solution addSolution(){
    Solution mySolution = new Solution();
    return mySolution;
  }

  /*
  * setter for the assignment name field
  * */
  public void setAssName(String assName) {
    this.assName = assName;
  }

  /*
  * to add a solution to your list of solutions
  * */
  public void addSolution(Solution theSolution) {
    theSolutionList.add(theSolution);
  }

  /*
  * to submit and store a solution
  * */
  public void submitSolution(){
  }

  /*
  * getter for the suggested solution
  * */
  public Solution getSuggestSolution() {
    return suggestSolution;
  }

  /*
  * getter for the list of solutions
  * */
  public SolutionList getTheSolutionList() {
    return theSolutionList;
  }

  /*
  return the solution for the given student
  */
  public Solution getSolution(String studentName) {
    SolutionIterator Iterator = getSolutionIterator();
    return (Solution)Iterator.next(studentName);
  }

  @SuppressWarnings("unused")
  /*
  * to return the suggested solution for the particular assignment
  * */
  public Solution getSugSolution(){
    return suggestSolution;
  }

  /*
  * getter for the due date field
  * */
  public Date getDueDate() {
    return this.dueDate;
  }

  /*
  * create and return an iterator to iterate over the list of solutions*/
  @SuppressWarnings("UnnecessaryLocalVariable")
  public SolutionIterator getSolutionIterator() {
    SolutionIterator theSolutionIterator=new SolutionIterator(theSolutionList);
    return theSolutionIterator;
  }

  // to get the String type of the assignment name field
  public String toString() {
    return assName;
  }

  // to get the String type of the due date field
  public String getDueDateString() {
    DateFormat dateFormat=DateFormat.getDateInstance(DateFormat.SHORT);
    return  dateFormat.format(dueDate);
  }


  // to visit and mark an assignment as accepted
  public void accept(NodeVisitor visitor) {
    visitor.visitAssignment(this);
    this.isAccepted = true;
  }

  // return if an assignment has been accepted/visited or not
  public boolean isAccepted() {
    return this.isAccepted;
  }
}
