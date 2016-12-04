package model;

import java.awt.Color;
public interface IConfig {
	int LARGEUR_CARTE = 25; int HAUTEUR_CARTE = 15; // en nombre de cases
	int NB_PIX_CASE = 20;
	int POSITION_X = 100; int POSITION_Y = 50; // Position de la fen�tre
	int NB_HEROS = 6; int NB_MONSTRES = 15; int NB_OBSTACLES = 20;
	String TEXTURE_VIDE = "/ressources/texture.png", TEXTURE_INCONNU = "/ressources/texture_inconnu.png";
	Color COULEUR_TEXTE = Color.black, COULEUR_MONSTRES = Color.black;
	Color COULEUR_HEROS = Color.red, COULEUR_HEROS_DEJA_JOUE = Color.pink;
	String TEXTURE_EAU = "/ressources/texture_eau.png", TEXTURE_FORET = "/ressources/texture_foret.png", TEXTURE_ROCHER="/ressources/texture_rocher.png";
}