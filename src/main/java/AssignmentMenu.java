import javax.swing.*;

/**
 * Title:        HACS
 * Description:
 * Copyright:    Copyright (c) 2002
 * Company:      msu
 * @author Alok Rajpurohit, arajpur@asu.edu
 * @version 1.0
 */

abstract public class AssignmentMenu extends JDialog
{
  abstract void showMenu(Assignment ass, Person per);

  // constructor
  public AssignmentMenu()
  {
    setModal(true);
    setSize(575,330);
  }
}
