package model;

public class Monstre extends Soldat{
	private TypesM typeM;

	public Monstre(String nom){
		super(nom);
		this.typeM = TypesM.getTypeMAlea();
		this.couleur = COULEUR_MONSTRES;
	}
}
