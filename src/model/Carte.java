package model;
import java.util.ArrayList;
/**
 * @author: KOMA NIANFO LOEW
 * @version : 1.0
 */
public class Carte implements ICarte,IConfig{
/**
 * grille : grille de la carte
 */
	CaseModel[][] grille;
	boolean obstacle=false;
	/**
	 * Carte : constructeur de la carte
	 */
	public Carte() {
		// TODO Auto-generated constructor stub
		grille =new CaseModel[LARGEUR_CARTE][HAUTEUR_CARTE];
		for(int i=0;i<LARGEUR_CARTE;i++){
			for(int j=0;j<HAUTEUR_CARTE;j++){
				grille[i][j] = new CaseModel(i,j);
			}
		}
	}
/**
 * Placement des 20 Obstacles dans la grille
 */
	public void placeObstacles(){
		for(int i=0; i<NB_OBSTACLES ;i++){
			Position p = trouvePositionVide();
			grille[p.getX()][p.getY()].setElement(new Obstacle(p));
			grille[p.getX()][p.getY()].obstacle=true;
		}
	}
	/**
	 * 
	 * Placement des Heros sur la carte
	 * @param armeeHeros
	*/
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
	
	/**
	 * Placement des Monstres
	 * @param armeeMonstres
	 */
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
	/**
	 * Obtenu element à la position pos
	 * @param pos
	 */
	public Element getElement(Position pos){
		try {
			return grille[pos.getX()][pos.getY()].getElement();
		}catch (ArrayIndexOutOfBoundsException e){
			System.out.println(e.getStackTrace());
			return null;
		}
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
	/**
	 * trouverMonstre
	 * @param pos
	 * @param carte
	 * @return
	 */
	public boolean trouverMonstre(Position pos, Carte carte){
			if((carte.grille[pos.getX()][pos.getY()].getElement()).estMonstre()){
				return true;
			}
	return false;
	}
	public boolean trouveHeros(Position pos,int portee){
		for(int i=pos.getX();i<=pos.getX()+portee;i++){
			for(int j=pos.getY();j<=pos.getY()+portee;j++){
				if(((Soldat)getElement(new Position(i,j))).estHeros()){
					((Soldat)grille[pos.getX()][pos.getY()].getElement()).combat((Soldat)grille[i][j].getElement());
					return true;
				}
			}
		}
		return false;
	}
	public Position trouvePositionVide(Position pos){
		int i = (int)(Math.random()*(pos.getX()+1)-(pos.getX()-1))+(pos.getX()-1);
		int j = (int)(Math.random()*(pos.getY()+1)-(pos.getY()-1))+(pos.getX()-1);
		//Element e= getElement(new Position(i,j));
		while(((Soldat)grille[pos.getX()][pos.getY()].getElement()).estHeros() && grille[pos.getX()][pos.getY()].obstacle){
			i = (int)(Math.random()*(pos.getX()+1)-(pos.getX()-1))+(pos.getX()-1);
			j = (int)(Math.random()*(pos.getY()+1)-(pos.getY()-1))+(pos.getX()-1);
		} 
		return new Position(i,j);
	}
	public Heros trouveHeros(){
		int a = (int)(Math.random()*LARGEUR_CARTE);
		int b = (int)(Math.random()*HAUTEUR_CARTE);
		while(((Soldat)grille[a][b].getElement()).estHeros()){
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
	/**
	 * deplaceSoldat
	 * @param pos
	 * @param soldat
	 */
	public boolean deplaceSoldat(Position pos, Soldat soldat){
		Position p = soldat.pos;
		try{
			if(grille[pos.getX()][pos.getY()].setElement(soldat)){
				grille[p.getX()][p.getY()].setElement(new Element());
				grille[pos.getX()][pos.getY()].getElement().setPos(pos);
				grille[p.getX()][p.getY()].setElement(new Element());
				return true;
			}
		}catch (ArrayIndexOutOfBoundsException e){
			return false;
		}
		return false;
	}

	public CaseModel[][] getGrille() {
		return grille;
	}
	
}
