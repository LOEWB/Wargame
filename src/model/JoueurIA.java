package model;
import java.util.ArrayList;
import view.PanneauJeu;
import java.util.concurrent.TimeUnit;

public class JoueurIA extends AbstractJoueur implements IConfig{

	public JoueurIA(Partie p) {
		super(p);
		this.armee = new ArmeeMonstres(p.getCarte());
	}

	
	
	@Override
	public void jouerTour() {
		this.armee.initDebutTour();
		//simulation tour du joueur IA
		boolean combat=false;
		
		for(int i=0;i<NB_MONSTRES;i++){
			for(int x=0; x<LARGEUR_CARTE;x++){
				for(int y=0; y<HAUTEUR_CARTE;y++){
					if((this.partie.getCarte().getElement(new Position(x,y))).estHeros()){
						if(this.partie.getJoueurIA().getArmee().getListeSoldats().get(i).estAPortee(new Position(x,y))){
							if(this.partie.getJoueurIA().getArmee().getListeSoldats().get(i).combat((Soldat)this.partie.getCarte().getElement(new Position(x,y)))){
								this.partie.notifyObserverExplosion(((Soldat)this.partie.getCarte().getElement(new Position(x,y))).getPos());
								if(this.partie.getJoueurIA().getArmee().getListeSoldats().get(i).getPortee()<=0){
									this.partie.getJoueurIA().getArmee().getListeSoldats().get(i).mort();
								}
								System.out.println("Combat d'un monstre");
							}
						}
					}
				}
			}
			if(this.partie.getJoueurIA().getArmee().getListeSoldats().get(i).combatM==false)
			{
					for(int x=0; x<LARGEUR_CARTE;x++){
						for(int y=0; y<HAUTEUR_CARTE;y++){
							if(this.partie.getJoueurIA().getArmee().getListeSoldats().get(i).estAPorteeDeplacement(new Position(x,y))){
								if(!this.partie.getJoueurIA().getArmee().getListeSoldats().get(i).deplace){
									Position p=new Position(0,0);	
								 //p.setX(this.partie.getJoueurIA().getArmee().getListeSoldats().get(i).getPos().getX());
								// p.setY(this.partie.getJoueurIA().getArmee().getListeSoldats().get(i).getPos().getY());
								//Position	p1=this.partie.getCarte().trouvePositionVide(p);
								//System.out.print(",x :"+p.getX()+" y:"+p.getY());
									try{
										this.partie.getJoueurIA().getArmee().getListeSoldats().get(i).deplaceSoldat(new Position(x,y));
										this.partie.notifyObserver("");
										TimeUnit.SECONDS.sleep(1);						
								    } catch(InterruptedException e) {
								    	//Thread.sleep(3);
								    }
								this.partie.notifyObserver("");
								}
								
							}
						}
					}
				}
			this.partie.notifyObserver("");
		}
		
		try {
			System.out.println("L'IA joue...");
			TimeUnit.SECONDS.sleep(2);
			this.partie.notificationFinDeTour();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for(int i=0;i<NB_MONSTRES;i++){
			this.partie.getJoueurIA().getArmee().getListeSoldats().get(i).deplace=false;
		}
		
	}

	@Override
	public void ajouterPartie(Partie p) {
		// TODO Auto-generated method stub
		
	}

}
