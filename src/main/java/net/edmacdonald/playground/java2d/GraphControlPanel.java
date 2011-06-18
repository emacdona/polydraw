package net.edmacdonald.playground.java2d;

import javax.swing.*;

public class GraphControlPanel extends JPanel{
    private JSlider horizontalTransltion;
    private JSlider verticalTranslaction;
    private JSlider rotationAngle;

    public GraphControlPanel() {
        horizontalTransltion = new JSlider();
        verticalTranslaction = new JSlider();
        rotationAngle = new JSlider();

        add(horizontalTransltion);
        add(verticalTranslaction);
        add(rotationAngle);
    }
}
