/**
 * Title: HACS Description: Copyright: Copyright (c) 2002 Company: msu
 *
 * @author Alok Rajpurohit, arajpur@asu.edu
 * @version 1.0
 */

abstract public class NodeVisitor {

	public NodeVisitor() {
	}

	@SuppressWarnings("unused")
	public NodeVisitor(Object visitee) {
	}

	abstract public void visitFacade(Facade facade);

	abstract public void visitCourse(Course course);

	abstract public void visitAssignment(Assignment assignment);

}
