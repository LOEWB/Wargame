package view;


import controller.ControllerFinTour;
import model.Partie;
import model.Position;
import java.util.Observable;
/**
 * @author: KOMA NIANFO LOEW
 * @version : 1.0
 */

public class Launcher  {
	
    public static void main(String args[]){
        System.out.println("started");
        
        //Partie utilis�e comme Model
        Partie partie = new Partie();
        //WargameController utilis�e comme controller
        ControllerFinTour controller = new ControllerFinTour(partie);
        //FenetreJeu utilis�e comme View
        FenetreJeu fen = new FenetreJeu(controller,partie);
        partie.addObserver(fen);
        partie.addObserver(fen.getPanneau());
        partie.lancerPartie();
        
        
    }
    /**
     * redemarrerPartie
     */
    public void redemarrerPartie(){
    	Partie partie1 = new Partie();
  
    	partie1.lancerPartie();
    	partie1.notifyObserver("");
    }
}
