import java.util.*;

/**
 * Title: HACS Description: Copyright: Copyright (c) 2002 Company: msu
 *
 * @author Alok Rajpurohit, arajpur@asu.edu
 * @version 1.0
 * @author mjfindler
 * @version 2.0 use <e> notation
 */

public class ListIterator implements Iterator<Object> {
	ArrayList<Object> theList;
	int CurrentNumber = -1;

	// constructor
	public ListIterator() {
	}

	// parameterized constructor
	public ListIterator(ArrayList<Object> list) {
		theList = list;
	}

	// to check if the list has an object at the next index
	public boolean hasNext() {
		return CurrentNumber < theList.size() - 1;
	}

	// to return the object at the next index in the list
	public Object next() {
		if (hasNext()) {
			CurrentNumber++;
			return theList.get(CurrentNumber);
		} else {
			return null;
		}
	}

	// to remove the current object from the list
	public void remove() {
		theList.remove(CurrentNumber);
	}

	// to return the list
	public ArrayList<Object> getTheList() {
		return theList;
	}
}
