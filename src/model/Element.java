package model;

import java.awt.Color;

/**
 * Created by root on 11/15/16.
 */
public class Element implements IConfig {
    private boolean clickable=false;
    protected Position pos;
    public static String nom;
    public String texture;
    public boolean vide;
    public Element(){
        this.pos = pos;
        this.texture = TEXTURE_VIDE;
        this.vide = true;
    }

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
