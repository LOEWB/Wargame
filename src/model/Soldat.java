package model;


public abstract class Soldat extends Element implements ISoldat{

	protected String num;
	protected boolean aJoueCeTour;
	protected int vie;
	public Soldat(String nom){
		this.num = nom;
		vide = false;
		clickable=true;
	}

	public void setPos(Position pos) {
		this.pos = pos;
	}

	public Position getPos() {
		return this.pos;
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
	public int getVieCourante(){
		return vie;
	}
	public void baisserVie(){
		vie--;
	}
	public void setAJoueCeTour(boolean bool)
	{
		this.aJoueCeTour=bool;
	}

	public String getNum() {
		return num;
	}

	public boolean estAPortee(Position posi)
	{
		if (posi.getX()<=(this.getPos().getX()+this.getPortee()) && posi.getX()>=(this.getPos().getX()-this.getPortee()))
			if (posi.getY()<=(this.getPos().getY()+this.getPortee()) && posi.getY()>=(this.getPos().getY()-this.getPortee()))
				return true;
		return false;
	}

	public abstract String getType();
	public abstract int getVie();
}
