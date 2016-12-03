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

    public ArrayList<Case> getListeBoutons(){
        return this.listeBoutons;
    }

    /**
     * Fonction appellée à chaque mise à jour du modèle, met à jour la grille graphiquement en fonction de la partie
     * @param str
     * @param o Partie en cours dans le modèle
     */
    @Override
    public void update(String str, Object o) {
        Partie p=(Partie) o;
        CaseModel[][] grille = p.getCarte().getGrille();

        //On met à jour les cases de la grille en fonction du modèle
        for(int i=0;i<LARGEUR_CARTE;i++)
        {
            for(int j=0;j<HAUTEUR_CARTE;j++)
            {
                if(!grille[i][j].getElement().estClickable())
                    this.listeBoutons.get(j*LARGEUR_CARTE+i).setRolloverEnabled(false);
                else {
                    Soldat soldat = (Soldat) grille[i][j].getElement();
                    this.listeBoutons.get(j * LARGEUR_CARTE + i).setText(String.valueOf(soldat.getNum()));
                }
                this.listeBoutons.get(j*LARGEUR_CARTE+i).setBackground(grille[i][j].getElement().couleur);
                this.listeBoutons.get(j*LARGEUR_CARTE+i).setMargin(new Insets(0, 0, 0, 0));

                if(grille[i][j].getElement().vide)
                {
                    if(!p.getJoueurReel().getArmee().estAPortee(grille[i][j].getPos()))
                        this.listeBoutons.get(j*LARGEUR_CARTE+i).setBackground(COULEUR_INCONNU);
                }
            }
        }


    }
}

