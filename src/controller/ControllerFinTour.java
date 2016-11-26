package controller;

import model.Partie;

public class ControllerFinTour extends AbstractController {
    public ControllerFinTour(Partie p) {
        super(p);
    }

    public void control() {
        if (this.modelPartie.getJoueurTourCourant() == this.modelPartie.getJoueurReel()) {
            this.modelPartie.notificationFinDeTour();
        }
    }
}