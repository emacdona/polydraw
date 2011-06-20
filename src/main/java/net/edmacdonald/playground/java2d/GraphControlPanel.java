package net.edmacdonald.playground.java2d;

import com.sun.tools.internal.ws.processor.model.java.JavaArrayType;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import java.util.List;

public class GraphControlPanel extends JPanel{
    private final Integer INITIAL_RADIUS = 5;
    private final Integer INITIAL_POINT_COUNT = 3;
    private final Integer INITIAL_H_TRANS = 0;
    private final Integer INITIAL_V_TRANS = 0;
    private final Integer INITIAL_ROT_ANG = 90;

    private JSlider radius = new JSlider(1, 10, INITIAL_RADIUS);
    private JSlider pointCount = new JSlider(3,12, INITIAL_POINT_COUNT);
    private JSlider horizontalTranslation = new JSlider(-10, 10, INITIAL_H_TRANS);
    private JSlider verticalTranslation = new JSlider(-10, 10, INITIAL_V_TRANS);
    private JSlider rotationAngle = new JSlider(0, 360, INITIAL_ROT_ANG);

    private JButton resetAll = new JButton("Reset All");
    private JCheckBox graphicalDebug = new JCheckBox("Graphical Debug", false);

    private List<JButton> resetButtons = new ArrayList<JButton>();

    public GraphControlPanel() {

        GridLayout layout = new GridLayout(
                6,  /* rows */
                4,  /* columns */
                2,  /* hgap */
                0   /* vgap */
        );

        this.setLayout(layout);

        addLabelledSlider("Radius", radius, INITIAL_RADIUS);
        addLabelledSlider("Point Count", pointCount, INITIAL_POINT_COUNT);
        addLabelledSlider("Horizontal Translation", horizontalTranslation, INITIAL_H_TRANS);
        addLabelledSlider("Vertical Translation", verticalTranslation, INITIAL_V_TRANS);
        addLabelledSlider("Rotation Angle", rotationAngle, INITIAL_ROT_ANG);

        this.add(new JPanel());
        this.add(graphicalDebug);
        this.add(resetAll);
        this.add(new JPanel());
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

    public JButton getResetAll() {
        return resetAll;
    }

    public JCheckBox getGraphicalDebug() {
        return graphicalDebug;
    }

    public List<JButton> getResetButtons() {
        return resetButtons;
    }

    private void addLabelledSlider(String label, final JSlider slider, final Integer resetValue){
        JLabel jlabel = new JLabel(label);
        final JLabel sliderValue = new JLabel(Integer.valueOf(slider.getValue()).toString());
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

        reset.addActionListener( new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                slider.setValue(resetValue);
            }
        });

        Border border = BorderFactory.createEtchedBorder();
        jlabel.setBorder(border);
        slider.setBorder(border);
        sliderValue.setBorder(border);
        reset.setBorder(border);

        resetButtons.add(reset);

        this.add(jlabel);
        this.add(slider);
        this.add(sliderValue);
        this.add(reset);
    }
}
