/**
 * Title:        HACS
 * Description:
 * Copyright:    Copyright (c) 2002
 * Company:      msu
 * @author Alok Rajpurohit, arajpur@asu.edu
 * @version 1.0
 */
import java.awt.*;

public class HighLevelCourseMenu extends CourseMenu {

	/*
	 * JButton AssignmentAddButton = new JButton(); JRadioButton OptionRadio = new
	 * JRadioButton(); JComboBox OptionCombo = new JComboBox(); JButton
	 * OptionViewButton = new JButton(); JButton OptionAddButton = new JButton();
	 * To initialize and display the Course menu GUI and all its components
	 */

	public HighLevelCourseMenu() {
	}

	void showMenu(Course theCourse) {
		showViewButtons();
		showRadios();
		showComboxes();
		setVisible(true);
	}

	void showAddButtons() {
		assignmentAddButton.addActionListener(e -> assignmentAddButtonActionPerformed());
		assignmentAddButton.setText("Add");
		assignmentAddButton.setBounds(new Rectangle(389, 54, 79, 29));
		optionAddButton.setText("Add");
		optionAddButton.setBounds(new Rectangle(390, 125, 79, 29));
		this.getContentPane().add(assignmentAddButton, null);
		this.getContentPane().add(optionAddButton, null);
	}

	void showRadios() {
		assignmentRadio.setText("Assignment");
		assignmentRadio.setBounds(new Rectangle(21, 55, 103, 26));
		this.getContentPane().add(assignmentRadio, null);
		optionRadio.setText("High Level Presentation");
		optionRadio.setBounds(new Rectangle(21, 128, 103, 26));
		this.getContentPane().add(optionRadio, null);
	}

	void showComboxes() {
		assignmentCombo.setBounds(new Rectangle(140, 57, 126, 22));
		optionCombo.setBounds(new Rectangle(137, 127, 126, 22));
		this.getContentPane().add(assignmentCombo, null);
		this.getContentPane().add(optionCombo, null);
		refresh();
	}

	void showViewButtons() {
		assignmentViewButton.setText("View");
		assignmentViewButton.setBounds(new Rectangle(290, 54, 79, 29));
		assignmentViewButton.addActionListener(e -> assignmentViewButtonActionPerformed());
		optionViewButton.setText("View");
		optionViewButton.setBounds(new Rectangle(290, 124, 79, 29));
		this.getContentPane().add(assignmentViewButton, null);
		this.getContentPane().add(optionViewButton, null);
	}

	void showLabel() {
		assignmentContentLabel.setText("Assignment Content");
		assignmentContentLabel.setBounds(new Rectangle(23, 186, 432, 99));
		this.getContentPane().add(assignmentContentLabel, null);
	}
}
