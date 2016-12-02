package model;

/*
 * 
 */

public class Heros extends Soldat{

	TypesH typeH;
	private int vieH;

	public Heros(String nom){
		super(nom);
		this.typeH = TypesH.getTypeHAlea();
		this.couleur = COULEUR_HEROS;
		vieH=getVie();
	}

	public String getType() {
		return typeH.name();
	}

	@Override
	public int getVie() {
		return typeH.getPoints();
	}
	public int getVieCourante(){
		return vieH;
	}
	public void baisserVie(){
		vieH--;
	}
}
