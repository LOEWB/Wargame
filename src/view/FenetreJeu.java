package view;


import javax.swing.*;

import controller.ControllerFinTour;
import model.IConfig;
import model.Partie;
import observer.Observer;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class FenetreJeu extends JFrame implements IConfig,Observer{
	public final static String TITRE_FENETRE = "Wargame";
	public final static int LARGEUR_FENETRE = 1150;
	public final static int HAUTEUR_FENETRE = 750;
    private PanneauJeu panneau;
    private Header header;
    private Footer footer;
    private Partie partie;
    private static int index;

    public FenetreJeu(ControllerFinTour controller, Partie partie){
        this.partie = partie;
        initFenetreJeu(controller);
    }

    public void initFenetreJeu(ControllerFinTour controller){
    	this.setTitle(TITRE_FENETRE);
        this.setSize(new Dimension(LARGEUR_FENETRE,HAUTEUR_FENETRE));
        this.setLocationRelativeTo(null);

        panneau = new PanneauJeu(LARGEUR_CARTE,HAUTEUR_CARTE);
        this.getContentPane().add(panneau);
        header = new Header(controller);
        this.getContentPane().add(BorderLayout.NORTH,header);
        footer = new Footer(controller);
        this.getContentPane().add(BorderLayout.SOUTH,footer);


        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        for(index=0;index<this.panneau.getListeBoutons().size();index++){
            System.out.println(index);
            this.panneau.getListeBoutons().get(index).addMouseListener(new MouseAdapter() {
                private int indice = index;
                @Override
                public void mouseEntered(MouseEvent e) {
                    footer.notifierHoverCase(partie.getCarte().getGrille()[indice%LARGEUR_CARTE][indice/LARGEUR_CARTE]);
                }

                @Override
                public void mouseExited(MouseEvent e) {
                    footer.notifierSortieCase();
                }

            });
        }
        
        this.setVisible(true);
    }
    

	public PanneauJeu getPanneau() {
		return panneau;
	}

	public Header getHeader() {
		return header;
	}

    @Override
    public void update(String str, Object o) {
        Partie p = (Partie) o;
        if(p.getJoueurTourCourant()==p.getJoueurReel())
            header.allumerBoutonFinTour();
        else
            header.eteindreBoutonFinTour();
    }
}
