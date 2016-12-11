package model;

public interface ISoldat {
	/**
	 * enum TypesH
	 * enum TypesM 
	 *
	 */
   static enum TypesH {
      HUMAIN (40,3,10,2,"/ressources/texture_humain.png"), NAIN (80,1,20,0,"/ressources/texture_nain.png"), ELF (70,5,10,6,"/ressources/texture_elf.png"), HOBBIT (20,3,5,2,"/ressources/texture_hobbit.png");
      private final int POINTS_DE_VIE, PORTEE_VISUELLE, PUISSANCE, TIR;
       public final String TEXTURE;
      TypesH(int points, int portee, int puissance, int tir,String texture) {
POINTS_DE_VIE = points; PORTEE_VISUELLE = portee;
PUISSANCE = puissance; TIR = tir; TEXTURE = texture;
      }
       public String getTexture(){return TEXTURE;}
      public int getPoints() { return POINTS_DE_VIE; }
      public int getPortee() { return PORTEE_VISUELLE; }
      public int getPuissance() { return PUISSANCE; }
      public int getTir() { return TIR; }
      public static TypesH getTypeHAlea() {
         return values()[(int)(Math.random()*values().length)];
      }
   }
   public static enum TypesM {
      TROLL (100,1,30,0,"/ressources/texture_troll.png"), ORC (40,2,10,3,"/ressources/texture_orc.png"), GOBELIN (20,2,5,2,"/ressources/texture_gobelin.png");
      private final int POINTS_DE_VIE, PORTEE_VISUELLE, PUISSANCE, TIR;
       private final String TEXTURE;
      TypesM(int points, int portee, int puissance, int tir,String texture) {
POINTS_DE_VIE = points; PORTEE_VISUELLE = portee;
PUISSANCE = puissance; TIR = tir; TEXTURE = texture;

      }
       public String getTexture(){return TEXTURE;}
      public int getPoints() { return POINTS_DE_VIE; }
      public int getPortee() { return PORTEE_VISUELLE; }
      public int getPuissance() { return PUISSANCE; }
      public int getTir() { return TIR; }
      public static TypesM getTypeMAlea() {
         return values()[(int)(Math.random()*values().length)];
      }
   }

   int getPoints(); int getTour(); int getPortee();
   void joueTour(int tour);
   boolean combat(Soldat soldat);
   void deplaceSoldat(Position newPos);
}