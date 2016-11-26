package model;

public class Monstre extends Soldat{
	private TypesM typeM;

	public Monstre(){
		super();
		this.typeM = TypesM.getTypeMAlea();
		this.couleur = COULEUR_MONSTRES;
	}
}
