package view;

import javafx.geometry.Pos;
import model.*;
import observer.Observer;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.util.ArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;


public class PanneauJeu extends JPanel implements Observer, IConfig {

    private final ArrayList<Case> listeBoutons = new ArrayList<Case>();
    private CaseModel[][] grille=new CaseModel[HAUTEUR_CARTE][LARGEUR_CARTE];

    public final static String CURSEUR = "/ressources/curseur.png";
    public final static String CURSEUR_MOVE = "/ressources/curseur_move.png";
    public final static String CURSEUR_ATTACK = "/ressources/curseur_attack.png";
    public final static String CURSEUR_STOP = "/ressources/curseur_stop.png";
    public final static String CURSEUR_TIME = "/ressources/curseur_time.png";

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
        setCursor(CURSEUR);
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
        this.grille=p.getCarte().getGrille();

        //On met à jour les cases de la grille en fonction du modèle
        for(int i=0;i<LARGEUR_CARTE;i++)
        {
            for(int j=0;j<HAUTEUR_CARTE;j++)
            {
                if(!grille[i][j].getElement().estClickable()) {
                    this.listeBoutons.get(j * LARGEUR_CARTE + i).setText("");
                    this.listeBoutons.get(j * LARGEUR_CARTE + i).setRolloverEnabled(false);
                }
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
                this.listeBoutons.get(j*LARGEUR_CARTE+i).setBorder(new LineBorder(new Color(0x565255),1));
            }
        }


    }

    public void setCursor(String lienCurseur) {
        try{
            Toolkit toolkit = Toolkit.getDefaultToolkit();
            Image curseurImage;
            curseurImage = ImageIO.read(getClass().getResource(lienCurseur));
            Point hotspot = new Point(0,0);
            Cursor cursor = toolkit.createCustomCursor(curseurImage,hotspot,"Stone");
            this.setCursor(cursor);
        }catch (Exception e){

        }
    }

    public void explosion (Position pos){
        final Position posi = pos;
        final Icon ancienIcon = this.listeBoutons.get(pos.getY() * LARGEUR_CARTE + pos.getX()).getIcon();
        java.net.URL imgURL = getClass().getResource("/ressources/explosion.gif");
        if (imgURL != null) {

            this.listeBoutons.get(pos.getY() * LARGEUR_CARTE + pos.getX()).setIcon(new ImageIcon(imgURL));
            Timer timer = new Timer(500, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    listeBoutons.get(posi.getY() * LARGEUR_CARTE + posi.getX()).setIcon(ancienIcon);
                }
            });
            timer.setRepeats(false);
            timer.start();
        } else {
            System.err.println("Couldn't find file: " + "/ressources/explosion.gif");
        }
    }

    public void glowCasesPortee(Heros h){
        for(int i=0;i<LARGEUR_CARTE;i++) {
            for (int j = 0; j < HAUTEUR_CARTE; j++) {
                if(h.estAPortee(new Position(i,j)))
                {
                    if(grille[i][j].getElement().estClickable()){
                        Soldat s = (Soldat)grille[i][j].getElement();
                        if(!s.estHeros()){
                            this.listeBoutons.get(j*LARGEUR_CARTE+i).setBorder(new LineBorder(new Color(0xF8000C),2));
                        }
                    }
                    else
                    {
                        if(h.estAPorteeDeplacement(new Position(i,j))){
                            this.listeBoutons.get(j*LARGEUR_CARTE+i).setBorder(new LineBorder(new Color(0xF8D02A),2));
                        }
                    }


                }
            }
        }
    }

    public void unglowCasesPortee(){
        for(int i=0;i<LARGEUR_CARTE;i++) {
            for (int j = 0; j < HAUTEUR_CARTE; j++) {
                this.listeBoutons.get(j*LARGEUR_CARTE+i).setBorder(new LineBorder(new Color(0x565255),1));
            }
        }
    }


}

