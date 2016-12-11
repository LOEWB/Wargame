package view;

import javax.swing.*;

import model.Position;

import java.awt.*;

public class Case extends JButton {

    private PositionView pos;

    public Case(int x, int y){
        super();
        this.setPreferredSize(new Dimension(50,50));
        this.pos = new PositionView(x,y);
    }
}
