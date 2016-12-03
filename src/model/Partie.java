package model;

import java.util.ArrayList;
import java.util.Collection;

import observer.Observable;
import observer.Observer;

public class Partie implements Observable{
	
	private AbstractJoueur joueurTourCourant;
	private JoueurReel joueurReel;
	private JoueurIA joueurIA;
	private Carte carte;
	private boolean partieEnCours = false;
	private ArrayList<Observer> listObserver = new ArrayList<Observer>(); 

	public Partie(){
		initPartie();
	}

	private void initPartie() {
		this.carte = new Carte();
		this.joueurReel = new JoueurReel(this);
		this.joueurIA = new JoueurIA(this);		
		//TODO A definir aleatoirement
		this.joueurTourCourant = this.joueurReel;
		
	}
	
	public void lancerPartie(){
		this.carte.placeObstacles();
		this.carte.placeHeros((ArmeeHeros) this.joueurReel.getArmee());
		this.carte.placeMonstres((ArmeeMonstres) this.joueurIA.getArmee());
		this.partieEnCours = true;
		this.notifyObserver("");
		while(this.partieEnCours){
			this.joueurReel.jouerTour();
			this.notifyObserver("");
			this.joueurIA.jouerTour();
			this.notifyObserver("");
		}
	}
	/**
	 * notification appel�e par un des joueurs pour signaler la fin de son tour
	 */
	public void notificationFinDeTour(){
		if(this.joueurTourCourant == joueurReel)
			this.joueurTourCourant = joueurIA;
		else
			this.joueurTourCourant = joueurReel;
	}
	
	/**
	 * notification appel�e par un des joueurs pour signaler qu'il est mort
	 */
	public void notificationFinDeJeu(){
		this.partieEnCours = false;
	}

	public AbstractJoueur getJoueurTourCourant() {
		return joueurTourCourant;
	}

	public JoueurReel getJoueurReel() {
		return joueurReel;
	}

	public Carte getCarte() {
		return carte;
	}

	public JoueurIA getJoueurIA() {
		return joueurIA;
	}

	public boolean isPartieEnCours() {
		return partieEnCours;
	}

	@Override
	public void addObserver(Observer obs) {
		this.listObserver.add(obs);
		
	}

	@Override
	public void removeObserver() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void notifyObserver(String str) {
		for(Observer obs : listObserver)
			obs.update("",this);
	}
}

