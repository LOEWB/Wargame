package model;
/**
 * @author: KOMA NIANFO LOEW
 * @version : 1.0
 */
public class JoueurReel extends AbstractJoueur{
/**
 * JoueurTour:
 * @param p
 */
	public JoueurReel(Partie p) {
		super(p);
		this.armee = new ArmeeHeros(p.getCarte());
		// TODO Auto-generated constructor stub
	}

	@Override
	/**
	 * jouerTour
	 */
	public void jouerTour() {
		System.out.println("A vous de jouer");
		this.armee.initDebutTour();
		while(this.partie.getJoueurTourCourant()==this){
			try {
			       Thread.sleep(1);
			    } catch(InterruptedException e) {
			    }
		}		
	}

	@Override
	public void ajouterPartie(Partie p) {
		// TODO Auto-generated method stub
	}


	
	

}
