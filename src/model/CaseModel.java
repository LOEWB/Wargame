package model;


public class CaseModel{

	    private Position pos;
	    private Element element=null;

	    public CaseModel(int x, int y){
	        pos = new Position(x,y);
	    }

		public boolean setElement(Object elem) {
			// TODO Auto-generated method stub
			if(this.element==null)
			{
				this.element = (Element) elem;
				return true;
			}
			return false;
		}

		public Element getElement(){
			return element;
		}
}
