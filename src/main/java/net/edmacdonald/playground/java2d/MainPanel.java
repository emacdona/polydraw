package net.edmacdonald.playground.java2d;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainPanel extends JPanel {
    private final PlotPanel plot;
    private GraphControlPanel controls;
    private Log log = LogFactory.getLog(MainPanel.class);

    public MainPanel() {
        plot = new PlotPanel();
        controls = new GraphControlPanel();

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        controls.getRadius().addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent changeEvent) {
                plot.setRadius(((JSlider) changeEvent.getSource()).getValue());
                plot.plot();
                log.trace("Change Event source: " + changeEvent.getSource());
            }
        });

        controls.getPointCount().addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent changeEvent) {
                plot.setPointCount(((JSlider) changeEvent.getSource()).getValue());
                plot.plot();
                log.trace("Change Event source: " + changeEvent.getSource());
            }
        });

        controls.getHorizontalTranslation().addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent changeEvent) {
                plot.setHorizontalOffset(((JSlider) changeEvent.getSource()).getValue());
                plot.plot();
                log.trace("Change Event source: " + changeEvent.getSource());
            }
        });

        controls.getVerticalTranslation().addChangeListener( new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent changeEvent) {
                plot.setVerticalOffset(((JSlider) changeEvent.getSource()).getValue());
                plot.plot();
                log.trace("Change Event source: " + changeEvent.getSource());
            }
        });

        controls.getRotationAngle().addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent changeEvent) {
                plot.setRotationAngle(((JSlider) changeEvent.getSource()).getValue());
                plot.plot();
                log.trace("Change Event source: " + changeEvent.getSource());
            }
        });

        controls.getResetAll().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                for(JButton button : controls.getResetButtons()) {
                    button.doClick();
                }
            }
        });

        controls.getGraphicalDebug().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if(controls.getGraphicalDebug().isSelected()) {
                    plot.setGraphicalDebug(true);
                }
                else {
                    plot.setGraphicalDebug(false);
                }

                plot.plot();
            }
        });

        add(plot);
        add(controls);
    }
}
