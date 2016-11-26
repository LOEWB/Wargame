package model;

import java.awt.Color;

import model.ISoldat.*;
/**
 * Created by root on 11/15/16.
 */
public class Element implements IConfig {
    public boolean clickable=false;
    public Position pos;
    public static String nom;
    public Color couleur;
    public boolean vide;

    public Element(){
        this.couleur = COULEUR_VIDE;
        this.vide = true;
    }

}
