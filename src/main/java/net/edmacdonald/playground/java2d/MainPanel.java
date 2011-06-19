package net.edmacdonald.playground.java2d;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class MainPanel extends JPanel {
    private final PlotPanel plot;
    private GraphControlPanel controls;
    private Log log = LogFactory.getLog(MainPanel.class);

    public MainPanel() {
        plot = new PlotPanel();
        controls = new GraphControlPanel();

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        controls.getHorizontalTranslation().addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent changeEvent) {
                plot.setHorizontalOffset(((JSlider) changeEvent.getSource()).getValue());
                log.trace("Change Event source: " + changeEvent.getSource());
            }
        });

        controls.getVerticalTranslation().addChangeListener( new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent changeEvent) {
                plot.setVerticalOffset(((JSlider) changeEvent.getSource()).getValue());
                log.trace("Change Event source: " + changeEvent.getSource());
            }
        });

        controls.getRotationAngle().addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent changeEvent) {
                plot.setRotationAngle(((JSlider) changeEvent.getSource()).getValue());
                log.trace("Change Event source: " + changeEvent.getSource());
            }
        });

        add(plot);
        add(controls);
    }
}
