package model;

import java.util.ArrayList;
/**
 * @author: KOMA NIANFO LOEW
 * @version : 1.0
 */
public class Armee implements IConfig{
	/**
	 * listeSoldats
	 * carte
	 */
    protected ArrayList<Soldat> listeSoldats;
    protected Carte carte;
    /**
     * Armee
     */
    public Armee(){
        this.listeSoldats=new ArrayList<Soldat>();
    }
    /**
     * getListeSoldats
     * 
     * @return listeSoldats
     */
    public ArrayList<Soldat> getListeSoldats() {
        return listeSoldats;
    }
    /**
     * initDebutTour
     */
    public void initDebutTour(){
        for(Soldat soldat:this.listeSoldats){
            soldat.setAJoueCeTour(false);
        }
    }
    /** 
     * estAPortee
     * 
     * @param pos
     * @return boolean
     */

    public boolean estAPortee(Position pos)
    {
        for(Soldat soldat:this.listeSoldats)
        {
            if(soldat.estAPortee(pos))
                return true;
        }
        return false;
    }
}
