package view;

import controller.ControllerFinTour;
import model.Partie;


public class Launcher {
    public static void main(String args[]){
        System.out.println("started");
        
        //Partie utilis�e comme Model
        Partie partie = new Partie();
        //WargameController utilis�e comme controller
        ControllerFinTour controller = new ControllerFinTour(partie);
        //FenetreJeu utilis�e comme View
        FenetreJeu fen = new FenetreJeu(controller);
        partie.addObserver(fen);
        partie.addObserver(fen.getPanneau());
        partie.lancerPartie();
        
    }
}
