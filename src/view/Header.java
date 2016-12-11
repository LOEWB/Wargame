package view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import controller.ControllerFinTour;

public class Header extends JPanel{
	private JButton boutonTour;
	private ControllerFinTour controller;
	public Header(ControllerFinTour control){
		boutonTour = new JButton("FIN DE TOUR");
		boutonTour.setBackground(Color.GREEN);
		this.controller = control;
		boutonTour.addActionListener(new ActionListener(){
			

			@Override
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
}
