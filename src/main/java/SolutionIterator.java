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
public class SolutionIterator implements Iterator {
  SolutionList solutionlist;

  //CurrentSolutionNumber: point to the location before the first element
  int CurrentSolutionNumber=-1;

  public int getCurrentSolutionNumber() {
    return CurrentSolutionNumber;
  }

  // constructor
  public SolutionIterator() {
  }

  // parameterized constructor
  public SolutionIterator(SolutionList thesolutionlist) {
    solutionlist = thesolutionlist;
    moveToHead();
  }

  // getter for the course list
  public void moveToHead() {
    CurrentSolutionNumber=-1;
  }

  // to check if the solution list has a solution at the next index
  public boolean hasNext() {
    return CurrentSolutionNumber < solutionlist.size() - 1;
  }

  // to get the solution at the next index in the solution list
  public Object next() {
    if (hasNext()) {
      CurrentSolutionNumber ++;
      return solutionlist.get(CurrentSolutionNumber);
    }
    else {
      return null;
    }
  }

  // to get the next solution with the given username in the soution list
  public Object next(String UserName) {
    Solution theSolution;
    theSolution=(Solution)next();
    while(theSolution!=null) {
      if(UserName.compareTo(theSolution.theAuthor)==0) {
        return theSolution;
      }
      theSolution=(Solution)next();
    }
    return null;
  }

  // to remove the current solution from the solution list
  public void remove() {
    solutionlist.remove(CurrentSolutionNumber);
  }


}
