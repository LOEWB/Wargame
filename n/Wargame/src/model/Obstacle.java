package model;

import java.awt.Color;

public class Obstacle extends Element {
	public enum TypeObstacle {
		ROCHER (TEXTURE_ROCHER), FORET (TEXTURE_FORET), EAU (TEXTURE_EAU);

		private final String COULEUR;
		TypeObstacle(String couleur) { COULEUR = couleur; }
		public static TypeObstacle getObstacleAlea() {
			return values()[(int)(Math.random()*values().length)];
		}
	}
	private TypeObstacle TYPE;
	Obstacle(Position pos) {
		TYPE = TypeObstacle.getObstacleAlea();
		this.setPos(pos);
		this.texture =TYPE.COULEUR;
		this.vide=false;
		setClickable(false);
	}
	public String toString() { return ""+TYPE; }
}