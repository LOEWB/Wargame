package view;

import model.CaseModel;
import model.IConfig;
import model.Partie;
import observer.Observer;

import java.awt.*;
import java.util.ArrayList;

import javax.swing.*;


public class PanneauJeu extends JPanel implements Observer, IConfig {

    private final ArrayList<Case> listeBoutons = new ArrayList<Case>();

	public PanneauJeu(int nbCol, int nbLignes){
		this.setLayout(new GridLayout(nbLignes,nbCol));
		for(int i=0;i<nbLignes;i++)
        {
            for(int j=0;j<nbCol;j++)
            {
                Case c = new Case(i,j);
                c.setBackground(COULEUR_VIDE);
                this.listeBoutons.add(c);
                this.add(c);
            }
        }
	}


    @Override
    public void update(String str, Object o) {
        Partie p=(Partie) o;
        CaseModel[][] grille = p.getCarte().getGrille();

        for(int i=0;i<LARGEUR_CARTE;i++)
        {
            for(int j=0;j<HAUTEUR_CARTE;j++)
            {
                this.listeBoutons.get(j*LARGEUR_CARTE+i).setBackground(grille[i][j].getElement().couleur);
            }
        }
    }
}

