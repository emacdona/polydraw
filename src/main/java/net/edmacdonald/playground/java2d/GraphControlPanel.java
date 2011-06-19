package net.edmacdonald.playground.java2d;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;

public class GraphControlPanel extends JPanel{
    private final Integer INITIAL_RADIUS = 5;
    private final Integer INITIAL_POINT_COUNT = 10;
    private final Integer INITIAL_H_TRANS = 0;
    private final Integer INITIAL_V_TRANS = 0;
    private final Integer INITIAL_ROT_ANG = 0;

    private JSlider radius = new JSlider(1, 10, INITIAL_RADIUS);
    private JSlider pointCount = new JSlider(3,100, INITIAL_POINT_COUNT);
    private JSlider horizontalTranslation = new JSlider(-10, 10, INITIAL_H_TRANS);
    private JSlider verticalTranslation = new JSlider(-10, 10, INITIAL_V_TRANS);
    private JSlider rotationAngle = new JSlider(0, 360, INITIAL_ROT_ANG);

    public GraphControlPanel() {

        BoxLayout layout = new BoxLayout(this, BoxLayout.Y_AXIS);
        setLayout(layout);

        add(getLabelledSlider("Radius", radius, INITIAL_RADIUS));
        add(getLabelledSlider("Point Count", pointCount, INITIAL_POINT_COUNT));
        add(getLabelledSlider("Horizontal Translation", horizontalTranslation, INITIAL_H_TRANS));
        add(getLabelledSlider("Vertical Translation", verticalTranslation, INITIAL_V_TRANS));
        add(getLabelledSlider("Rotation Angle", rotationAngle, INITIAL_ROT_ANG));
    }

    public JSlider getRadius() {
        return radius;
    }

    public JSlider getPointCount() {
        return pointCount;
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

    /*
        Create a nice wrapper panel around a slider that gives you some visual indication
        of what value it has and what that value represents.
     */
    private JPanel getLabelledSlider(String label, final JSlider slider, final Integer resetValue){
        JPanel container = new JPanel();

        JLabel jlabel = new JLabel(label);
        final JTextArea sliderValue = new JTextArea(Integer.valueOf(slider.getValue()).toString());
        JButton reset = new JButton("Reset");

        slider.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent changeEvent) {
                sliderValue.setText(
                    Integer.valueOf(
                            ((JSlider) changeEvent.getSource()).getValue()
                    ).toString()
                );
            }
        });

        reset.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent changeEvent) {
                slider.setValue(resetValue);
            }
        });

        container.setLayout(new BoxLayout(container, BoxLayout.X_AXIS));
        container.setBorder(BorderFactory.createEtchedBorder());

        container.add(jlabel);
        container.add(slider);
        container.add(sliderValue);
        container.add(reset);

        return container;
    }
}
