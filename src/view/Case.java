package view;

import javax.swing.*;

import model.Position;

public class Case extends JButton {

    private PositionView pos;

    public Case(int x, int y){
        super();
        this.pos = new PositionView(x,y);
    }
}
