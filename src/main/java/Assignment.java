/**
 * Title:        HACS
 * Description:  CSE870 Homework 3:  Implementing Design Patterns
 * Copyright:    Copyright (c) 2002
 * Company:      Department of Computer Science and Engineering, Michigan State University
 * @author Ji Zhang, Wei Zhu
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


  public Assignment() {
    this.isAccepted = false;
  }

  public void setDueDate(Date theDueDate){
    this.dueDate = theDueDate;
  }

  public boolean isOverDue(){
    Date today;
    today = new Date();
    return today.after(this.dueDate);
  }

  @SuppressWarnings({"unused", "UnnecessaryLocalVariable"})
  public Solution addSolution(){
    Solution mySolution = new Solution();
    return mySolution;
  }

  public void setAssName(String assName) {
    this.assName = assName;
  }

  ////add the theSolution to the SolutionList
  public void addSolution(Solution theSolution) {
    theSolutionList.add(theSolution);
  }

  public void submitSolution(){
  }

  public Solution getSuggestSolution() {
    return suggestSolution;
  }

  public SolutionList getTheSolutionList() {
    return theSolutionList;
  }

  /* return the solution of the give name
  */
  public Solution getSolution(String studentName)
  {
    SolutionIterator Iterator=(SolutionIterator)theSolutionList.iterator();
    return (Solution)Iterator.next(studentName);
  }

  @SuppressWarnings("unused")
  public Solution getSugSolution(){
    return suggestSolution;
  }

  public Date getDueDate() {
    return dueDate;
  }

  @SuppressWarnings("UnnecessaryLocalVariable")
  public SolutionIterator getSolutionIterator() {
    SolutionIterator theSolutionIterator=new SolutionIterator(theSolutionList);
    return theSolutionIterator;
  }

  public String toString()
  {
    return assName;
  }

  public String getDueDateString() {
    DateFormat dateFormat=DateFormat.getDateInstance(DateFormat.SHORT);
    return  dateFormat.format(dueDate);
  }

  public void accept(NodeVisitor visitor)
  {
    visitor.visitAssignment(this);
    this.isAccepted = true;
  }

  public boolean isAccepted() {
    return this.isAccepted;
  }
}
