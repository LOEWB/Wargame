package model;

/**
 * @author: KOMA NIANFO LOEW
 * @version : 1.0
 */
public class CaseModel{
/**
 * pos
 * element
 * obstacle
 */
	    private Position pos;
	    private Element element=null;
	    protected boolean obstacle=false;
/**
 * CaseModel
 * @param x
 * @param y
 */
	    public CaseModel(int x, int y){
	        pos = new Position(x,y);
			element = new Element();
	    }
	    /**
	     * setElement
	     * @param elem
	     * @return
	     */

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
