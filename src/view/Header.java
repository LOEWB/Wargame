package view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import controller.ControllerFinTour;

public class Header extends JPanel{
	private JButton boutonTour;
	public Header(ControllerFinTour controller){
		boutonTour = new JButton("FIN DE TOUR");
		boutonTour.setBackground(Color.GREEN);
		boutonTour.addActionListener(new ActionListener(){
			

			@Override
			public void actionPerformed(ActionEvent arg0) {
				controller.control();
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
