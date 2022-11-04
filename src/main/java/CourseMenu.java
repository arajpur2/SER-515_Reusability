import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


/**
 * Title:        HACS
 * Description:
 * Copyright:    Copyright (c) 2002
 * Company:      msu
 * @author Alok Rajpurohit, arajpur@asu.edu
 * @version 1.0
 */

abstract public class CourseMenu extends JDialog
{
  Course theCourse;
  boolean bLogout=true;

  JRadioButton assignmentRadio = new JRadioButton();
  JComboBox<Assignment> assignmentCombo = new JComboBox<>();
  JButton assignmentViewButton = new JButton();
  JButton assignmentAddButton = new JButton();
  JRadioButton optionRadio = new JRadioButton();
  JLabel assignmentContentLabel = new JLabel();
  @SuppressWarnings("rawtypes")
  JComboBox optionCombo = new JComboBox();
  JButton optionViewButton = new JButton();
  JButton optionAddButton = new JButton();
  JButton buttonChangeCourse = new JButton();
  JButton buttonLogout = new JButton();

  public CourseMenu() {
    try {
      jbInit();
    }
    catch(Exception e) {
      e.printStackTrace();
    }
    setModal(true);
    setSize(503,294);
  }

  // initializing the GUI
  private void jbInit() {
    buttonChangeCourse.setText("ChangeCourse");
    buttonChangeCourse.setBounds(new Rectangle(101, 211, 73, 37));
    buttonChangeCourse.addActionListener(this::buttonChangeCourseActionPerformed);
    this.getContentPane().setLayout(null);
    this.setTitle("");
    buttonLogout.setText("Logout");
    buttonLogout.setBounds(new Rectangle(267, 215, 73, 37));
    buttonLogout.addActionListener(this::buttonLogoutActionPerformed);
    this.getContentPane().add(buttonChangeCourse, null);
    this.getContentPane().add(buttonLogout, null);
  }

  /* when the add button is pressed, call add assignment
  function of facade, after that refresh window
  */

  /* when the add button is pressed, call ViewAssignment
  function of facade, after that refresh window
  */

  @SuppressWarnings("unused")
  abstract void showMenu(Course theCourse);
  abstract void showAddButtons();
  abstract void showViewButtons();
  abstract void showRadios();
  abstract void showComboxes();
  @SuppressWarnings("unused")
  abstract void showLabel();

  void assignmentAddButtonActionPerformed() {
    Hacs.theFacade.addAssignment(theCourse);
    refresh();
  }

  void assignmentViewButtonActionPerformed() {
    Assignment theAss=(Assignment) assignmentCombo.getSelectedItem() ;
    Hacs.theFacade.viewAssignment(theAss);
  }

  void refresh() {
    assignmentCombo.removeAllItems() ;
    for (Assignment assignment : theCourse.assignmentList) {
      assignmentCombo.addItem(assignment);
    }
  }

  void buttonChangeCourseActionPerformed(ActionEvent e) {
    bLogout=false;
    setVisible(false);
  }

  void buttonLogoutActionPerformed(ActionEvent e) {
    bLogout=true;
    setVisible(false);
  }

  boolean ifLogout()
  {
    return bLogout;
  }
}
