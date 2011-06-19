package net.edmacdonald.playground.java2d;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;

public class GraphControlPanel extends JPanel{
    private JSlider horizontalTranslation;
    private JSlider verticalTranslation;
    private JSlider rotationAngle;

    public GraphControlPanel() {
        horizontalTranslation = new JSlider();
        verticalTranslation = new JSlider();
        rotationAngle = new JSlider();

        BoxLayout layout = new BoxLayout(this, BoxLayout.Y_AXIS);
        setLayout(layout);

        add(horizontalTranslation);
        add(verticalTranslation);
        add(rotationAngle);
    }

    public JSlider getHorizontalTranslation() {
        return horizontalTranslation;
    }

    public JSlider getVerticalTranslation() {
        return verticalTranslation;
    }

    public JSlider getRotationAngle() {
        return rotationAngle;
    }
}
