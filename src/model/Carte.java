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
	//Placement des Heros sur la carte
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
			int x = (int)(Math.random()*(LARGEUR_CARTE/2)+1+(LARGEUR_CARTE/2)-1);
			int y = (int)(Math.random()*HAUTEUR_CARTE);
			
			int lettre =(int)(Math.random()*122-65);
			String nom= Double.toString(lettre);
			while(!grille[x][y].getElement().vide){
				x = (int)(Math.random()*LARGEUR_CARTE/2+1+(LARGEUR_CARTE/2)-1);
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
		int i = (int)(Math.random()*(pos.getX()+1)-(pos.getX()-1));
		int j = (int)(Math.random()*(pos.getY()+1)-(pos.getY()-1));
		while(grille[i][j].getElement().couleur!=COULEUR_HEROS){
			i = (int)(Math.random()*(pos.getX()+1)-(pos.getX()-1));
			j = (int)(Math.random()*(pos.getY()+1)-(pos.getY()-1));
		} 
		return  (Heros)grille[i][j].getElement();
	}
	public Position trouvePositionVide(Position pos){
		int i = (int)(Math.random()*(pos.getX()+1)-(pos.getX()-1));
		int j = (int)(Math.random()*(pos.getY()+1)-(pos.getY()-1));
		while(grille[i][j].getElement()!=null){
			i = (int)(Math.random()*(pos.getX()+1)-(pos.getX()-1));
			j = (int)(Math.random()*(pos.getY()+1)-(pos.getY()-1));
		} 
		return new Position(i,j);
	}
	public Heros trouveHeros(){
		int a = (int)(Math.random()*LARGEUR_CARTE);
		int b = (int)(Math.random()*HAUTEUR_CARTE);
		while(grille[a][b].getElement().couleur!=COULEUR_HEROS){
			a = (int)(Math.random()*LARGEUR_CARTE);
			b = (int)(Math.random()*HAUTEUR_CARTE);
		} 
		return (Heros) grille[a][b].getElement();
	}
	public void mort(Soldat soldat){
		if(soldat.getPoints()==0){
			grille[soldat.getPos().getX()][soldat.getPos().getY()].setElement(null);
		}
	}
	public boolean actionHeros(Position pos, Position pos2){
		if(grille[pos.getX()][pos.getY()].getElement().couleur!=COULEUR_HEROS)
			return false ;
		if(grille[pos2.getX()][pos2.getY()].getElement()==null){ 
			deplaceSoldat(pos2,(Soldat)grille[pos.getX()][pos.getY()].getElement());
			return true;
		}
		if(grille[pos2.getX()][pos2.getY()].getElement().couleur==COULEUR_MONSTRES){
			((Soldat)grille[pos.getX()][pos.getY()].getElement()).combat((Soldat)grille[pos2.getX()][pos2.getY()].getElement());
			return true;
		}
		return false;
	}
	public boolean deplaceSoldat(Position pos, Soldat soldat){
		Position p= soldat.pos;
		if(grille[pos.getX()][pos.getY()].setElement(soldat)){
			grille[p.getX()][p.getY()].setElement(null);
			return true;
		}
		return false;
	}

	public CaseModel[][] getGrille() {
		return grille;
	}
}
