package view;


import controller.ControllerFinTour;
import model.CaseModel;

import javax.swing.*;
import java.awt.*;

public class Footer extends JPanel {
    private JLabel labelPosition;

    public Footer(ControllerFinTour controller) {
        labelPosition = new JLabel();
        labelPosition.setPreferredSize(new Dimension(200,20));
        this.add(BorderLayout.EAST, labelPosition);
    }

    public void notifierHoverCase(CaseModel caseModel){
        labelPosition.setText("["+caseModel.getPos().getX()+","+caseModel.getPos().getY()+"]");
    }

    public void notifierSortieCase(){
        labelPosition.setText("");
    }
}