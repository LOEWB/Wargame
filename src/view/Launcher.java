package view;

import controller.WargameController;
import model.Partie;


public class Launcher {
    public static void main(String args[]){
        System.out.println("started");
        
        //Partie utilis�e comme Model
        Partie partie = new Partie();
        //WargameController utilis�e comme controller
        WargameController controller = new WargameController(partie);
        //FenetreJeu utilis�e comme View
        FenetreJeu fen = new FenetreJeu(controller);
        partie.addObserver(fen);
        partie.addObserver(fen.getPanneau());
        partie.lancerPartie();
        
    }
}
