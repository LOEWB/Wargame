package view;


     import controller.ControllerFinTour;
     import model.CaseModel;
     import model.Soldat;

     import javax.swing.*;
     import java.awt.*;

     public class Footer extends JPanel {
         private JLabel labelPosition;
         private JLabel labelRace;
         private JLabel iconCoeur;

             public Footer(ControllerFinTour controller) {
                 labelPosition = new JLabel();
                 labelPosition.setPreferredSize(new Dimension(200,20));
                 labelRace = new JLabel();
                 labelRace.setPreferredSize(new Dimension(200,20));

                 java.net.URL imgURL = getClass().getResource("/ressources/heart.png");
                 if (imgURL != null) {
                     iconCoeur = new JLabel(new ImageIcon(imgURL));
                 } else {
                     System.err.println("Couldn't find file: " + "/ressources/heart.png");
                 }
                 iconCoeur.setPreferredSize(new Dimension(200,20));

                 GridBagLayout layout = new GridBagLayout();
                 GridBagConstraints c = new GridBagConstraints();
                 c.gridheight=1;

                 this.setLayout(layout);
                 this.add(labelPosition,c);
                 this.add(labelRace,c);
                 this.add(iconCoeur,c);
                 iconCoeur.setVisible(false);


         }

             public void notifierHoverCase(CaseModel caseModel){
                 labelPosition.setText("["+caseModel.getPos().getX()+","+caseModel.getPos().getY()+"]");
                 if(caseModel.getElement().clickable)
                 {
                     Soldat soldatCourant = (Soldat) caseModel.getElement();
                     labelRace.setText(soldatCourant.getType()+" "+soldatCourant.getVie());
                     iconCoeur.setVisible(true);
                 }
         }

             public void notifierSortieCase(){
                 labelPosition.setText("");
                 labelRace.setText("");
                 iconCoeur.setVisible(false);
         }
 }