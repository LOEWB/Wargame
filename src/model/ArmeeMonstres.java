package model;


public class ArmeeMonstres extends Armee{
    public ArmeeMonstres(){
        for(int i=0;i<NB_MONSTRES;i++){
            this.listeSoldats.add(new Monstre());
        }
    }
}
