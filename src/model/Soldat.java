package model;


public abstract class Soldat extends Element implements ISoldat{

	protected String num;
	protected boolean enVie =true;
	protected boolean aJoueCeTour;
	protected int vie;
	protected int pointsDeVie;
	protected Carte carte;
	protected boolean heros;

	public Soldat(String nom, Carte carte){
		this.carte=carte;
		this.num = nom;
		vide = false;
		this.setClickable(true);
	}

	public void setPos(Position pos) {
		this.pos = pos;
	}

	public Position getPos() {
		return this.pos;
	}


	/**
	 * @param pos position du héros à attaquer/case sur laquelle aller
	 * @return boolean -> True si l'attaque/déplacement s'est effectué, false sinon
     */
	public boolean actionHeros(Position pos) {
		if(!carte.getElement(pos).vide) {
			if (carte.getElement(pos).estClickable()) {
				Soldat s = (Soldat) carte.getElement(pos);
				//si le soldat attaqué est de faction differente
				if (!(this.estHeros() && s.estHeros())) {
					return this.combat(s);
				}
				else
					return false;
			}
			//si on essaye de se déplacer sur un obstacle
			else
				return false;
		}

		return carte.deplaceSoldat(pos,this);
	}

	@Override
		public int getPoints() {
		// TODO Auto-generated method stub
		return 1;
	}

	@Override
	public int getTour() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getPortee() {
		// TODO Auto-generated method stub
		return 2;
	}

	@Override
	public void joueTour(int tour) {
		// TODO Auto-generated method stub
		
	}

	/**
	 *
	 * @param soldat à attaquer
	 * @return true si attaque effectuee false si erreur
     */
	@Override
	public boolean combat(Soldat soldat) {
		Monstre monstre;
		Heros heros;
		try{
			if(this.heros) {
				heros = (Heros) this;
				if(this.estAPortee(soldat.getPos()))
					soldat.baisserVie((int)Math.random()*heros.getTypeH().getPuissance());
			}
			else
			{
				monstre = (Monstre) this;
				if(this.estAPortee(soldat.getPos()))
					soldat.baisserVie((int)Math.random()*monstre.getTypeM().getPuissance());
			}

			return true;
		}catch (Exception e)
		{
			System.out.println(e.getStackTrace());
			return false;
		}
		
	}

	@Override
	public void deplaceSoldat(Position newPos) {
		this.carte.deplaceSoldat(newPos,this);
	}

	public int getVieCourante(){
		return pointsDeVie;
	}


	public void baisserVie(int points){
		if(this.pointsDeVie > 0)
			this.vie-=points;
		if(this.pointsDeVie <= 0)
			this.enVie =false;
	}
	public void setAJoueCeTour(boolean bool)
	{
		this.aJoueCeTour=bool;
	}

	public String getNum() {
		return num;
	}

	public boolean estAPortee(Position posi)
	{
		if (posi.getX()<=(this.getPos().getX()+this.getPortee()) && posi.getX()>=(this.getPos().getX()-this.getPortee()))
			if (posi.getY()<=(this.getPos().getY()+this.getPortee()) && posi.getY()>=(this.getPos().getY()-this.getPortee()))
				return true;
		return false;
	}

	public boolean estHeros(){return this.heros;}
	public boolean estEnVie()
	{
		return this.enVie;
	}
	public abstract String getTypeName();
	public abstract int getVie();
}
