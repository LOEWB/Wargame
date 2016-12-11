package model;

import java.util.concurrent.TimeUnit;

public class JoueurIA extends AbstractJoueur{

	public JoueurIA(Partie p) {
		super(p);
		this.armee = new ArmeeMonstres(p.getCarte());
	}

	
	
	@Override
	public void jouerTour() {
		this.armee.initDebutTour();
		//simulation tour du joueur IA
		try {
			System.out.println("L'IA joue...");
			TimeUnit.SECONDS.sleep(2);
			this.partie.notificationFinDeTour();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void ajouterPartie(Partie p) {
		// TODO Auto-generated method stub
		
	}

}
