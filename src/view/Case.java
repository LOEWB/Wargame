package view;

import javax.swing.*;

import model.Position;

import java.awt.*;
/**
 * @author: KOMA NIANFO LOEW
 * @version : 1.0
 */
public class Case extends JButton {
	/**
	 * pos
	 */
    private PositionView pos;
    /**
     * Case:
     * @param x
     * @param y
     */
    public Case(int x, int y){
        super();
        this.setPreferredSize(new Dimension(50,50));
        this.pos = new PositionView(x,y);
    }
}
