package model;


public class CaseModel{

	    private Position pos;
	    private Element element=null;
	    protected boolean obstacle=false;

	    public CaseModel(int x, int y){
	        pos = new Position(x,y);
			element = new Element();
	    }

		public boolean setElement(Object elem) {
			// TODO Auto-generated method stub
			this.element = (Element) elem;
			return true;
		}

		public Element getElement(){
			return element;
		}

		public Position getPos(){
			return this.pos;
		}
}
