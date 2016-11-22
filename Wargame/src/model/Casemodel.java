package model;

import javax.swing.JButton;

public class Casemodel extends JButton{

	    private Position pos;
	    Element element;
	    public Casemodel(int x, int y){
	        super();
	        pos = new Position(x,y);
	    }
	public boolean setElement(Object object) {
		// TODO Auto-generated method stub
		if(element==null){
			this.element= (Element) object; return true;
		}
		return false;
	}
}
