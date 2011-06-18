package net.edmacdonald.playground.java2d;

import javax.swing.*;
import java.awt.*;

public class GraphControlPanel extends JPanel{
    private JSlider horizontalTransltion;
    private JSlider verticalTranslaction;
    private JSlider rotationAngle;

    public GraphControlPanel() {
        horizontalTransltion = new JSlider();
        verticalTranslaction = new JSlider();
        rotationAngle = new JSlider();

        BoxLayout layout = new BoxLayout(this, BoxLayout.Y_AXIS);
        setLayout(layout);

        add(horizontalTransltion);
        add(verticalTranslaction);
        add(rotationAngle);
    }
}
