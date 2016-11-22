package model;
import java.awt.*;
import javax.swing.*;
import view.Case;
import view.PanneauJeu;
import model.ISoldat.*;


public class Grille implements ICarte,IConfig{
	public final static int NB_LIGNES = 15;
    public final static int NB_COLONNES = 25;
    double probaObstacle = 0.2;
    Element element;
	Casemodel[][] grille;
	
	public Grille() {
		// TODO Auto-generated constructor stub
		grille =new Casemodel[NB_LIGNES][NB_COLONNES];	
	}
	//Placement des 20 Obstacles dans la grille
	public void placeObstacles(){
		for(int i=0; i<NB_OBSTACLES ;i++){
			int a = (int)(Math.random()*NB_LIGNES);
			int b = (int)(Math.random()*NB_COLONNES);
			while(grille[a][b].element!=null){
				a = (int)(Math.random()*NB_LIGNES);
				b = (int)(Math.random()*NB_COLONNES);
			} 
		grille[a][a].setElement(null);
		}
	}
	//Placement des Heros
	public void placeHeros(){
		for(int i=0; i<NB_HEROS;i++){
			int a = (int)(Math.random()*NB_LIGNES/2);
			int b = (int)(Math.random()*NB_COLONNES/2);
			
			int lettre =(int)(Math.random()*122-65);
			String nom= Double.toString(lettre);
			while(grille[a][b].element!=null){
				a = (int)(Math.random()*NB_LIGNES/2);
				b = (int)(Math.random()*NB_COLONNES/2);
			}
			grille[a][b].setElement(new Heros(this,Soldat.TypesH.getTypeHAlea(),nom, new Position(a,b)));
		}
	}
	//Placement des Monstres
	public void placeMonstre(){
		for(int i=0; i<NB_MONSTRES;i++){
			int a = (int)(Math.random()*NB_LIGNES-NB_LIGNES/2);
			int b = (int)(Math.random()*NB_COLONNES-NB_COLONNES/2);
			
			int lettre =(int)(Math.random()*122-65);
			String nom= Double.toString(lettre);
			while(grille[a][b].element!=null){
				a = (int)(Math.random()*NB_LIGNES-NB_LIGNES/2);
				b = (int)(Math.random()*NB_COLONNES-NB_COLONNES/2);
			}
			grille[a][b].setElement(new Monstre(this,Soldat.TypesH.getTypeHAlea(),nom, new Position(a,b)));
		}
	}
	//Placer object o dans la grille
	public void setElement(Object o){
		this.element=(Element) o;
	}
	//Obtenu element à la position pos
	public Element getElement(Position pos){
		return grille[pos.getX()][pos.getY()].element;
	}
	public Position trouvePositionVide(){
		
			int a = (int)(Math.random()*NB_LIGNES);
			int b = (int)(Math.random()*NB_COLONNES);
			while(grille[a][b].element!=null){
				a = (int)(Math.random()*NB_LIGNES);
				b = (int)(Math.random()*NB_COLONNES);
			} 
			return new Position(a,b);
	}
	public Heros trouveHeros(Position pos){
		int i = (int)(Math.random()*(pos.getX()+1)-(pos.getX()-1));
		int j = (int)(Math.random()*(pos.getY()+1)-(pos.getY()-1));
		while(grille[i][j].element!=null){
			i = (int)(Math.random()*(pos.getX()+1)-(pos.getX()-1));
			j = (int)(Math.random()*(pos.getY()+1)-(pos.getY()-1));
		} 
		if(!grille[i][j].element.typeh.equals(null)) return  (Heros)grille[i][j].element;
		return null ;
	}
	public Position trouvePositionVide(Position pos){
		int i = (int)(Math.random()*(pos.getX()+1)-(pos.getX()-1));
		int j = (int)(Math.random()*(pos.getY()+1)-(pos.getY()-1));
		while(grille[i][j].element!=null){
			i = (int)(Math.random()*(pos.getX()+1)-(pos.getX()-1));
			j = (int)(Math.random()*(pos.getY()+1)-(pos.getY()-1));
		} 
		return new Position(i,j);
	}
	public Heros trouveHeros(){
		int a = (int)(Math.random()*NB_LIGNES);
		int b = (int)(Math.random()*NB_COLONNES);
		while(!grille[a][b].element.typeh.equals(null)){
			a = (int)(Math.random()*NB_LIGNES);
			b = (int)(Math.random()*NB_COLONNES);
		}
		return (Heros)grille[a][b].element;
	}
	public boolean deplaceSoldat(Position pos, Soldat soldat){
		if(grille[pos.getX()][pos.getY()].setElement(soldat)) return true;
		return false;
	}
	public void mort(Soldat perso){
		if(perso.getPoints()==0){
			grille[perso.pos.getX()][perso.pos.getY()].element=null;
			//NB_HEROS--;
		}
	}
	public boolean actionHeros(Position pos, Position pos2){
		if(grille[pos.getX()][pos.getY()].element.typeh==null)
			return false ;
		if(grille[pos2.getX()][pos2.getY()].element.typeh==null) 
			return deplaceSoldat(pos2,(Soldat)grille[pos.getX()][pos.getY()].element);
		if(grille[pos2.getX()][pos2.getY()].element.typem!=null)
			((Soldat)grille[pos.getX()][pos.getY()].element).combat((Soldat)grille[pos2.getX()][pos2.getY()].element);
	return true;
	}
	public void toutDessiner(Graphics g){
		
	}
	public void jouerSoldats(PanneauJeu pj){
		
	}
}
