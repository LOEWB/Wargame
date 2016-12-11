package view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import model.Partie;

import controller.ControllerFinTour;

public class Header extends JPanel{
	private JButton boutonTour;
	private JButton redemarrerTour;
	private JButton enregistrerTour;
	private Launcher launch;
	private ControllerFinTour controller;
	/**
	 *  Header
	 * @param control
	 */
	public Header(ControllerFinTour control){
		
		redemarrerTour = new JButton("REDEMARRER");
		redemarrerTour.setBackground(Color.GREEN);
		add(redemarrerTour,BorderLayout.WEST);
		//this.launch = launch;
		
		redemarrerTour.addActionListener(new ActionListener(){
		
			public void actionPerformed(ActionEvent e) {
				System.out.println("Nouvelle partie");
				launch.redemarrerPartie();
				//.partie1.notifyObserver("");
				repaint();
			}
		});
	
		
		enregistrerTour= new JButton("SAUVEGARDE");
		enregistrerTour.setBackground(Color.GREEN);
		this.add(BorderLayout.EAST,enregistrerTour);
		
		boutonTour = new JButton("FIN DE TOUR");
		boutonTour.setBackground(Color.GREEN);
		this.controller = control;
		boutonTour.addActionListener(new ActionListener(){
			
			public void actionPerformed(ActionEvent arg0) {
				controller.controlFinTour();
			}
		});
	
		this.add(BorderLayout.CENTER, boutonTour);
	}


	public void allumerBoutonFinTour() {
		boutonTour.setBackground(Color.GREEN);
	}
	public void eteindreBoutonFinTour(){
		boutonTour.setBackground(Color.GRAY);
	}
	
	public void allBoutonRedemarrer(){
		redemarrerTour.setBackground(Color.GREEN);
	}
	public void offboutonRedemarrer(){
		redemarrerTour.setBackground(Color.RED);
	}
	
}
