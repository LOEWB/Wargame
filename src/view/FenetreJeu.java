package view;


import javax.swing.*;

import controller.ControllerFinTour;
import model.*;
import observer.Observer;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;

public class FenetreJeu extends JFrame implements IConfig,Observer{
	public final static String TITRE_FENETRE = "Wargame";
	public final static int LARGEUR_FENETRE = 1150;
	public final static int HAUTEUR_FENETRE = 750;
    private PanneauJeu panneau;
    private Header header;
    private Footer footer;
    private Partie partie;
    private static int index;
    private static model.Heros herosDepart;
    private static model.Position positionEntered;

    public FenetreJeu(ControllerFinTour controller, Partie partie){
        this.partie = partie;
        initFenetreJeu(controller);
    }

    public void initFenetreJeu(final ControllerFinTour controller){
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
                public void mouseClicked(MouseEvent e) {
                    super.mouseClicked(e);
                }

                @Override
                public void mousePressed(MouseEvent e) {
                    super.mousePressed(e);

                    model.Element elemClique=partie.getCarte().getGrille()[indice%LARGEUR_CARTE][indice/LARGEUR_CARTE].getElement();
                    if(elemClique.estClickable()){
                        Soldat soldat = (Soldat) elemClique;
                        if(soldat.estHeros()){
                            herosDepart = (Heros) soldat;
                            System.out.println("depart "+this.indice);
                        }

                    }
                }

                @Override
                public void mouseReleased(MouseEvent e) {
                    super.mouseReleased(e);
                    if(herosDepart!=null)
                        if(partie.getCarte().getGrille()[positionEntered.getX()][positionEntered.getY()].getElement().vide)
                            if(herosDepart.estAPorteeDeplacement(positionEntered)) {
                                System.out.println("Déplacé en " + positionEntered);
                                controller.controlActionJoueur(herosDepart,positionEntered);
                            }
                    herosDepart=null;
                }

                @Override
                public void mouseEntered(MouseEvent e) {
                    footer.notifierHoverCase(partie.getCarte().getGrille()[indice%LARGEUR_CARTE][indice/LARGEUR_CARTE]);

                    positionEntered = new Position(indice%LARGEUR_CARTE,indice/LARGEUR_CARTE);
                }

                @Override
                public void mouseExited(MouseEvent e) {
                    footer.notifierSortieCase();
                }

                @Override
                public void mouseWheelMoved(MouseWheelEvent e) {
                    super.mouseWheelMoved(e);
                }

                @Override
                public void mouseDragged(MouseEvent e) {
                    super.mouseDragged(e);
                }

                @Override
                public void mouseMoved(MouseEvent e) {
                    super.mouseMoved(e);
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
