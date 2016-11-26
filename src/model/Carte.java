package model;
import java.awt.*;
import java.util.Random;

import view.PanneauJeu;


public class Carte implements ICarte,IConfig{

	CaseModel[][] grille;
	
	public Carte() {
		// TODO Auto-generated constructor stub
		grille =new CaseModel[LARGEUR_CARTE][HAUTEUR_CARTE];
		for(int i=0;i<LARGEUR_CARTE;i++){
			for(int j=0;j<HAUTEUR_CARTE;j++){
				grille[i][j] = new CaseModel(i,j);
			}
		}
	}

	//Placement des 20 Obstacles dans la grille
	public void placeObstacles(){
		for(int i=0; i<NB_OBSTACLES ;i++){
			Position p = trouvePositionVide();
			grille[p.getX()][p.getY()].setElement(new Obstacle(p));
		}
	}
	//Placement des Heros
	public void placeHeros(ArmeeHeros armeeHeros){
		for(int i=0; i<armeeHeros.getListeSoldats().size();i++){
			int x = (int)(Math.random()*(LARGEUR_CARTE/2-1));
			int y = (int)(Math.random()*HAUTEUR_CARTE);
			
			int lettre =(int)(Math.random()*122-65);
			String nom= Double.toString(lettre);
			while(!grille[x][y].getElement().vide){
				x = (int)(Math.random()*(LARGEUR_CARTE/2-1));
				y = (int)(Math.random()*HAUTEUR_CARTE);
			}
			armeeHeros.getListeSoldats().get(i).setPos(new Position(x,y));
			grille[x][y].setElement(armeeHeros.getListeSoldats().get(i));

		}
	}
	//Placement des Monstres
	public void placeMonstres(ArmeeMonstres armeeMonstres){
		for(int i=0; i<armeeMonstres.getListeSoldats().size();i++){
			int x = (int)(Math.random()*(LARGEUR_CARTE/2)+1+(LARGEUR_CARTE/2));
			int y = (int)(Math.random()*HAUTEUR_CARTE);
			
			int lettre =(int)(Math.random()*122-65);
			String nom= Double.toString(lettre);
			while(!grille[x][y].getElement().vide){
				x = (int)(Math.random()*LARGEUR_CARTE/2+1+(LARGEUR_CARTE/2));
				y = (int)(Math.random()*HAUTEUR_CARTE);
			}
			armeeMonstres.getListeSoldats().get(i).setPos(new Position(x,y));
			grille[x][y].setElement(armeeMonstres.getListeSoldats().get(i));
		}
	}

	//Obtenu element à la position pos
	public Element getElement(Position pos){
		return grille[pos.getX()][pos.getY()].getElement();
	}
	public Position trouvePositionVide(){
		
			int a = (int)(Math.random()*LARGEUR_CARTE);
			int b = (int)(Math.random()*HAUTEUR_CARTE);
			while(!grille[a][b].getElement().vide){
				a = (int)(Math.random()*LARGEUR_CARTE);
				b = (int)(Math.random()*HAUTEUR_CARTE);
			} 
			return new Position(a,b);
	}
	public Heros trouveHeros(Position pos){
		return null ;
	}
	public Position trouvePositionVide(Position pos){
		return null;
	}
	public Heros trouveHeros(){
		return null;
	}
	public boolean deplaceSoldat(Position pos, Soldat soldat){
		if(grille[pos.getX()][pos.getY()].setElement(soldat)) return true;
		return false;
	}
	public void mort(Soldat perso){
		if(perso.getPoints()==0){
			//grille[perso.getPos().getX()][perso.getPos().getY()].getElement()=null;
			//NB_HEROS--;
		}
	}
	public boolean actionHeros(Position pos, Position pos2){
		/*if(grille[pos.getX()][pos.getY()].element.typeh==null)
			return false ;
		if(grille[pos2.getX()][pos2.getY()].element.typeh==null) 
			return deplaceSoldat(pos2,(Soldat)grille[pos.getX()][pos.getY()].element);
		if(grille[pos2.getX()][pos2.getY()].element.typem!=null)
			((Soldat)grille[pos.getX()][pos.getY()].element).combat((Soldat)grille[pos2.getX()][pos2.getY()].element);*/
	return true;
	}
	public void jouerSoldats(PanneauJeu pj){
		
	}

	public CaseModel[][] getGrille() {
		return grille;
	}
}
