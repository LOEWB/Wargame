package model;

import java.awt.Color;

import model.ISoldat.*;
/**
 * Created by root on 11/15/16.
 */
public abstract class Element implements IConfig {
    public Position pos;
    public static String nom;
    public Color couleur;
  //les deux types sont null signifie que l'element correspondant est null
    TypesH typeh=null;
    TypesM typem=null;

}
