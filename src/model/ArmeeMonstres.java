package model;


import javax.xml.stream.events.Characters;

public class ArmeeMonstres extends Armee{
    public ArmeeMonstres(){
        for(int i=0;i<NB_MONSTRES;i++){
            this.listeSoldats.add(new Monstre(String.valueOf(i+1)));
        }
    }
}
