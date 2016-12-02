package view;


     import controller.ControllerFinTour;
     import model.CaseModel;
     import model.Soldat;

     import javax.swing.*;
     import java.awt.*;

     public class Footer extends JPanel {
         private JLabel labelPosition;
         private JLabel labelRace;

             public Footer(ControllerFinTour controller) {
                 labelPosition = new JLabel();
                 labelPosition.setPreferredSize(new Dimension(200,20));
                 labelRace = new JLabel();
                 labelRace.setPreferredSize(new Dimension(200,20));

                 this.setLayout(new GridLayout(1,3));
                 this.add(labelPosition);
                 this.add(labelRace);

         }

             public void notifierHoverCase(CaseModel caseModel){
                 labelPosition.setText("["+caseModel.getPos().getX()+","+caseModel.getPos().getY()+"]");
                 if(caseModel.getElement().clickable)
                 {
                     Soldat soldatCourant = (Soldat) caseModel.getElement();
                     labelRace.setText(soldatCourant.getType()+" "+soldatCourant.getVie());
                 }
         }

             public void notifierSortieCase(){
                 labelPosition.setText("");
                 labelRace.setText("");
         }
 }