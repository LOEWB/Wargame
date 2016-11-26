package model;

import java.util.ArrayList;

public class Armee implements IConfig{
    protected ArrayList<Soldat> listeSoldats;
    public Armee(){
        this.listeSoldats=new ArrayList<Soldat>();
    }

    public ArrayList<Soldat> getListeSoldats() {
        return listeSoldats;
    }

    public void initDebutTour(){
        for(Soldat soldat:this.listeSoldats){
            soldat.setAJoueCeTour(false);
        }
    }
}
