package model;

import java.awt.Graphics;
/**
 * @author: KOMA NIANFO LOEW
 * @version : 1.0
 */

import view.PanneauJeu;
public interface ICarte {
	Element getElement(Position pos);
	Position trouvePositionVide(); // Trouve al�atoirement une position vide sur la carte
	Position trouvePositionVide(Position pos); // Trouve une position vide choisie
								// al�atoirement parmi les 8 positions adjacentes de pos
	Heros trouveHeros(); // Trouve al�atoirement un h�ros sur la carte
	boolean trouveHeros(Position pos, int portee); // Trouve un h�ros choisi al�atoirement
									 // parmi les 8 positions adjacentes de pos
	boolean deplaceSoldat(Position pos, Soldat soldat);
	void mort(Soldat perso);
	//boolean actionHeros(Position pos, Position pos2);
}