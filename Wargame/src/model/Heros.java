package model;

public class Heros extends Soldat{

	TypesH typeH;
	
	public Heros(String nom, Carte carte){
		super(nom,carte);
		this.heros=true;
		this.typeH = TypesH.getTypeHAlea();
		this.texture = typeH.getTexture();
		vie=getVie();
		this.pointsDeVie=vie;
	}

	public String getTypeName() {
		return typeH.name();
	}
	public TypesH getTypeH() {
		return typeH;
	}


	public int getVie() {
		return typeH.getPoints();
	}

	public int getPortee(){
		return typeH.getPortee();
	}
}
