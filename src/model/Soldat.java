package model;


public class Soldat extends Element implements ISoldat{

	public Soldat(){
		vide = false;
	}

	public void setPos(Position pos) {
		this.pos = pos;
	}

	public Position getPos() {
		return pos;
	}
	@Override
	/**
	 * 
	 * huhk
	 */
	public int getPoints() {
		// TODO Auto-generated method stub
		return 1;
	}

	@Override
	public int getTour() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getPortee() {
		// TODO Auto-generated method stub
		return 2;
	}

	@Override
	public void joueTour(int tour) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void combat(Soldat soldat) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void seDeplace(Position newPos) {
		// TODO Auto-generated method stub
		
	}


}
