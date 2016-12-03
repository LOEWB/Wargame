package controller;


import model.Partie;

public abstract class AbstractController {

    protected Partie modelPartie;

    public AbstractController(Partie p){
        this.modelPartie = p;
    }

    abstract public void controlFinTour();
}
