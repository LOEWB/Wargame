package model;

import java.awt.Color;

/**
 * @author: KOMA NIANFO LOEW
 * @version : 1.0
 */
public class Element implements IConfig {
	/**
	 * clickable
	 * pos
	 * nom
	 * texture
	 * vide
	 * heros
	 * monstre
	 */
    private boolean clickable=false;
    protected Position pos;
    public static String nom;
    public String texture;
    public boolean vide;
    protected boolean heros;
    protected boolean monstre;
    /**
     * Element: constructeur Element
     * 
     */
    public Element(){
        this.pos = pos;
        this.texture = TEXTURE_VIDE;
        this.vide = true;
    }
    /**
     * estHeros:
     * @return boolean
     */
    public boolean estHeros(){return this.heros;}
    /**
     * estMonstre:
     * @return boolean
     */
	public boolean estMonstre(){return this.monstre;}
    public Position getPos() {
        return pos;
    }

    public static String getNom() {
        return nom;
    }

    public void setPos(Position pos) {
        this.pos = pos;
    }

    public void setClickable(boolean clickable) {
        this.clickable = clickable;
    }

    public boolean estClickable(){
        return this.clickable;
    }
}
