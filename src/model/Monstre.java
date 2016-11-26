package model;

public class Monstre extends Soldat{
	private TypesM typeM;

	public Monstre(){
		this.typeM = TypesM.getTypeMAlea();
	}
}
