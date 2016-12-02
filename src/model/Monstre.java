package model;

public class Monstre extends Soldat{
	private TypesM typeM;
	private int vieM;
	public Monstre(String nom){
		super(nom);
		this.typeM = TypesM.getTypeMAlea();
		this.couleur = COULEUR_MONSTRES;
		vieM=getVie();
	}

	@Override
	public String getType() {
		return typeM.name();
	}

	@Override
	public int getVie() {
		return typeM.getPoints();
	}
	public int getVieCourante(){
		return vieM;
	}
	public void baisserVie(){
		vieM--;
	}
}
