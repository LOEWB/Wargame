package model;

/*
 * 
 */

public class Heros extends Soldat{

	TypesH typeH;
	
	public Heros(String nom){
		super(nom);
		this.typeH = TypesH.getTypeHAlea();
		this.couleur = COULEUR_HEROS;
		vie=getVie();
	}

	public String getType() {
		return typeH.name();
	}


	public int getVie() {
		return typeH.getPoints();
	}
	
}
