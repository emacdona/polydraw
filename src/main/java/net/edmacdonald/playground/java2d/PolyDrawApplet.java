package net.edmacdonald.playground.java2d;

import javax.swing.*;

public class PolyDrawApplet extends JApplet {
    @Override
    public void init() {
        super.init();
        setSize(800, 800);
        add(new MainPanel());
    }
}
