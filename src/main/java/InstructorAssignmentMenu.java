import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.DateFormat;

/**
 * Title:        HACS
 * Description:
 * Copyright:    Copyright (c) 2002
 * Company:      msu
 * @author Alok Rajpurohit, arajpur@asu.edu
 * @version 1.0
 */

public class InstructorAssignmentMenu extends AssignmentMenu {
  private Assignment theAssignment;

  JComboBox<Solution> CombSolutionList = new JComboBox<>();

  JTextField tbAssignmentName = new JTextField();
  JTextField tbDueDate = new JTextField();
  JTextField tbSuggestedSolution = new JTextField();

  JLabel jLabel1 = new JLabel();
  JLabel jLabel2 = new JLabel();
  JLabel jLabel3 = new JLabel();
  JButton buttonGrade = new JButton();
  JButton buttonReport = new JButton();
  JButton buttonClose = new JButton();


  // constructor
  public InstructorAssignmentMenu() {
    try {
      jbInit();
    }
    catch(Exception e) {
      e.printStackTrace();
    }
  }

  /*
  * initialize and create the GUI for the menu of instructor object's assignments
  * */
  private void jbInit() {
    jLabel1.setText("Assignment Name");
    jLabel1.setBounds(new Rectangle(25, 31, 118, 18));
    this.getContentPane().setLayout(null);
    tbAssignmentName.setText("jTextField1");
    tbAssignmentName.setBounds(new Rectangle(192, 31, 341, 22));
    jLabel2.setText("Due Date");
    jLabel2.setBounds(new Rectangle(28, 90, 113, 18));
    tbDueDate.setText("tbDueDate");
    tbDueDate.setBounds(new Rectangle(195, 87, 337, 22));
    jLabel3.setText("Suggested Solution");
    jLabel3.setBounds(new Rectangle(28, 151, 118, 18));
    tbSuggestedSolution.setText("jTextField2");
    tbSuggestedSolution.setBounds(new Rectangle(197, 149, 339, 22));
    buttonGrade.setText("Grade");
    buttonGrade.setBounds(new Rectangle(458, 199, 79, 29));
    buttonGrade.addActionListener(this::buttonGradeActionPerformed);
    buttonReport.setText("Report");
    buttonReport.setBounds(new Rectangle(365, 249, 79, 29));
    buttonReport.addActionListener(this::buttonReportActionPerformed);
    buttonClose.setText("Close");
    buttonClose.setBounds(new Rectangle(86, 253, 79, 29));
    buttonClose.addActionListener(this::buttonCloseActionPerformed);
    CombSolutionList.setBounds(new Rectangle(32, 204, 413, 22));
    this.getContentPane().add(jLabel1, null);
    this.getContentPane().add(tbAssignmentName, null);
    this.getContentPane().add(jLabel2, null);
    this.getContentPane().add(tbDueDate, null);
    this.getContentPane().add(jLabel3, null);
    this.getContentPane().add(tbSuggestedSolution, null);
    this.getContentPane().add(buttonClose, null);
    this.getContentPane().add(CombSolutionList, null);
    this.getContentPane().add(buttonGrade, null);
    this.getContentPane().add(buttonReport, null);
  }

  public void showMenu(Assignment assignment, Person person) {
    theAssignment=assignment;
    tbAssignmentName.setText(theAssignment.assName);

    DateFormat theDateFormat=DateFormat.getDateInstance(DateFormat.SHORT );
    tbDueDate.setText(theDateFormat.format(theAssignment.dueDate));
    tbSuggestedSolution.setText(theAssignment.suggestSolution.solutionFileName);
    refreshSolutionList();
    setVisible(true);
  }

  void buttonCloseActionPerformed(ActionEvent e) {
    theAssignment.assName = tbAssignmentName.getText() ;
    DateFormat tempDateFormat=DateFormat.getDateInstance(DateFormat.SHORT );
    try
    {
      theAssignment.dueDate =tempDateFormat.parse(tbDueDate.getText() );
    } catch (Exception e1){
      e1.printStackTrace();
    }
    theAssignment.suggestSolution.solutionFileName =tbSuggestedSolution.getText() ;
    setVisible(false);
  }

  void buttonGradeActionPerformed(ActionEvent e) {
    Solution theSolution=(Solution)CombSolutionList.getSelectedItem() ;
    if (theSolution==null)
       return;
    SolutionGradingDlg dlg = new SolutionGradingDlg();
    dlg.show(theSolution);
    refreshSolutionList();
  }

  void buttonReportActionPerformed
          (ActionEvent e) {
    SolutionIterator iterator = new SolutionIterator(theAssignment.theSolutionList );
    while(iterator.hasNext() )
    {
      Solution aSolution = (Solution)iterator.next();
      aSolution.setReported(true);
    }
    refreshSolutionList();
  }
  private void refreshSolutionList() {
    CombSolutionList.removeAllItems() ;
    SolutionIterator iterator = new SolutionIterator(theAssignment.theSolutionList );
    while(iterator.hasNext() )
    {
      //  class AssignmentMenu
      Solution theSolution = (Solution) iterator.next();
      CombSolutionList.addItem(theSolution);
    }
  }
}
