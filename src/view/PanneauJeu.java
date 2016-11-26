package view;

import model.CaseModel;
import model.IConfig;
import model.Partie;
import model.Soldat;
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
                if(!grille[i][j].getElement().clickable)
                    this.listeBoutons.get(j*LARGEUR_CARTE+i).setRolloverEnabled(false);
                else {
                    Soldat soldat = (Soldat) grille[i][j].getElement();
                    this.listeBoutons.get(j * LARGEUR_CARTE + i).setText(String.valueOf(soldat.getNom()));
                }
                this.listeBoutons.get(j*LARGEUR_CARTE+i).setBackground(grille[i][j].getElement().couleur);
                this.listeBoutons.get(j*LARGEUR_CARTE+i).setMargin(new Insets(0, 0, 0, 0));

                if(grille[i][j].getElement().vide)
                {
                    if(!p.getJoueurReel().getArmee().estAPortee(grille[i][j].getPos()))
                        this.listeBoutons.get(j*LARGEUR_CARTE+i).setBackground(new Color(0x1E0218));
                }
            }
        }
    }
}

