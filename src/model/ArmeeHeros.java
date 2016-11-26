package model;

public class ArmeeHeros extends Armee {
    public ArmeeHeros(){
        for(int i=0;i<NB_HEROS;i++){
            this.listeSoldats.add(new Heros(String.valueOf((char)(i+65))));
        }
    }
}
