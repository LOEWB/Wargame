
package controller;
import model.Partie;
/**
 * @author KOMA NIANFO LOEW
 * 
 */
public abstract class AbstractController {
/**
 * @serial modelPartie
 */
    protected Partie modelPartie;
 /**
  * AbstractController
  * @param p
  */
    public AbstractController(Partie p){
        this.modelPartie = p;
    }

    abstract public void controlFinTour();
}
