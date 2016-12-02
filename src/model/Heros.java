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
	}

	@Override
	public String getType() {
		return typeH.name();
	}

	@Override
	public int getVie() {
		return typeH.getPoints();
	}
}
