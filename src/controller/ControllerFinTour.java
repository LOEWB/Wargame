package controller;

import javafx.geometry.Pos;
import model.*;

public class ControllerFinTour extends AbstractController {
    public ControllerFinTour(Partie p) {
        super(p);
    }

    public void controlFinTour() {
        if (this.modelPartie.getJoueurTourCourant() == this.modelPartie.getJoueurReel()) {
            this.modelPartie.notificationFinDeTour();
        }
    }

    public void controlActionJoueur(Heros heros, Position posElem){
        if (this.modelPartie.getJoueurTourCourant() == this.modelPartie.getJoueurReel()) {
            heros.actionHeros(posElem);
            this.modelPartie.notifyObserver("");
        }
    }
}