package view;


     import controller.ControllerFinTour;
     import model.CaseModel;
     import model.Soldat;

     import javax.swing.*;
     import java.awt.*;
     /**
      * @author: KOMA NIANFO LOEW
      * @version : 1.0
      */
     public class Footer extends JPanel {
    	 /**
    	  * labelPosition
    	  *  labelRace
    	  *  iconCoeur
    	  */
         private JLabel labelPosition;
         private JLabel labelRace;
         private JLabel iconCoeur;
         /**
          * Footer
          * @param controller
          */
             public Footer(ControllerFinTour controller) {
                 this.setPreferredSize(new Dimension(200,30));
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
                 iconCoeur.setPreferredSize(new Dimension(200,30));

                 GridBagLayout layout = new GridBagLayout();
                 GridBagConstraints c = new GridBagConstraints();
                 c.gridheight=1;

                 this.setLayout(layout);
                 this.add(labelPosition,c);
                 this.add(labelRace,c);
                 this.add(iconCoeur,c);
                 iconCoeur.setVisible(false);


         }
             /**
              * notifierHoverCase
              * 
              * @param caseModel
              */
             public void notifierHoverCase(CaseModel caseModel){
                 labelPosition.setText("["+caseModel.getPos().getX()+","+caseModel.getPos().getY()+"]");
                 if(caseModel.getElement().estClickable())
                 {
                     Soldat soldatCourant = (Soldat) caseModel.getElement();
                     labelRace.setText(soldatCourant.getTypeName()+" "+soldatCourant.getVieCourante()+"/"+soldatCourant.getVie()+" portee  : "+ soldatCourant.getPortee());
                     iconCoeur.setVisible(true);
                 }
         }

             public void notifierSortieCase(){
                 labelPosition.setText("");
                 labelRace.setText("");
                 iconCoeur.setVisible(false);
         }
 }