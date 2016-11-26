package model;

/*
 * 
 */

public class Heros extends Soldat{

	TypesH typeH;

	public Heros(){
		super();
		this.typeH = TypesH.getTypeHAlea();
		this.couleur = COULEUR_HEROS;
	}
}
