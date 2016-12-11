package view;

import model.*;
import observer.Observer;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.renderable.ParameterBlock;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.LineBorder;


public class PanneauJeu extends JPanel implements Observer, IConfig {

    private final ArrayList<Case> listeBoutons = new ArrayList<Case>();
    private CaseModel[][] grille=new CaseModel[HAUTEUR_CARTE][LARGEUR_CARTE];
    private Partie p;

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
                c.setIcon(new ImageIcon(getClass().getResource(TEXTURE_VIDE)));
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
    //@Override
    public void update(String str, Object o) {
    	if(str.equals("explision")){
    		explosion((Position)o);
    	}
    	else{	
        p=(Partie) o;
        this.grille=p.getCarte().getGrille();

        //On met à jour les cases de la grille en fonction du modèle
        for(int i=0;i<LARGEUR_CARTE;i++)
        {
            for(int j=0;j<HAUTEUR_CARTE;j++)
            {
                this.listeBoutons.get(j*LARGEUR_CARTE+i).setBorder(new LineBorder(new Color(0x29562E),1));
                if(!grille[i][j].getElement().estClickable()) {
                    this.listeBoutons.get(j * LARGEUR_CARTE + i).setText("");
                    this.listeBoutons.get(j * LARGEUR_CARTE + i).setRolloverEnabled(false);
                }
                else {
                    Soldat soldat = (Soldat) grille[i][j].getElement();

                   // this.listeBoutons.get(j * LARGEUR_CARTE + i).setText(String.valueOf(soldat.getNum()));
                }
                this.listeBoutons.get(j * LARGEUR_CARTE + i).setIcon(new ImageIcon(getClass().getResource(grille[i][j].getElement().texture)));

                if(grille[i][j].getElement().vide)
                {
                    if(!p.getJoueurReel().getArmee().estAPortee(grille[i][j].getPos()))
                        this.listeBoutons.get(j*LARGEUR_CARTE+i).setIcon(new ImageIcon(getClass().getResource(TEXTURE_INCONNU)));
                }

            }
        }

        glowCasesSoldats();
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
                //@Override
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
                    this.listeBoutons.get(j*LARGEUR_CARTE+i).setBorder(new LineBorder(new Color(0x1C8CF8),1));
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
        glowCasesSoldats();
    }

    public void glowCasesSoldats(){
        for(Soldat s:p.getJoueurReel().getArmee().getListeSoldats())
        {
            if(s.getAjoueCeTour())
                this.listeBoutons.get(s.getPos().getY()*LARGEUR_CARTE+s.getPos().getX()).setBorder(new LineBorder(new Color(0xC6C6C5),1));
            else
                this.listeBoutons.get(s.getPos().getY()*LARGEUR_CARTE+s.getPos().getX()).setBorder(new LineBorder(new Color(0x31F71E),1));
        }

        for(Soldat s:p.getJoueurIA().getArmee().getListeSoldats())
        {
            if(s.getAjoueCeTour())
                this.listeBoutons.get(s.getPos().getY()*LARGEUR_CARTE+s.getPos().getX()).setBorder(new LineBorder(new Color(0xC6C6C5),1));
            else
                this.listeBoutons.get(s.getPos().getY()*LARGEUR_CARTE+s.getPos().getX()).setBorder(new LineBorder(new Color(0xF78027),1));
        }
        //this.listeBoutons.get(j*LARGEUR_CARTE+i).setBorder(new LineBorder(new Color(0x31F71E),1));
    }


}

