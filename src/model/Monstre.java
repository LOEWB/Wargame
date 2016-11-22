package model;

public class Monstre extends Soldat{

	public Monstre(Grille carte, TypesH type ,String nom, Position pos){
		//super(carte,type,nom,pos);
		this.couleur=COULEUR_MONSTRES;
	}
}
