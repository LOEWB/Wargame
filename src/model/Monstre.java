package model;

public class Monstre extends Soldat{
	private TypesM typeM;

	public Monstre(String nom,Carte carte){
		super(nom,carte);
		this.heros = false;
		this.typeM = TypesM.getTypeMAlea();
		this.texture = typeM.getTexture();
		vie=getVie();
		this.pointsDeVie=vie;
	}

	@Override
	public String getTypeName() {
		return typeM.name();
	}
	public TypesM getTypeM() {
		return typeM;
	}

	@Override
	public int getVie() {
		return typeM.getPoints();
	}

	public int getPortee(){
		return typeM.getPortee();
	}
	
}
