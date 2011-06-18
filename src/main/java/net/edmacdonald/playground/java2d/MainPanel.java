package net.edmacdonald.playground.java2d;

import javax.swing.*;

public class MainPanel extends JPanel {
    PlotPanel plot;
    GraphControlPanel controls;

    public MainPanel() {
        PlotPanel plot = new PlotPanel();
        GraphControlPanel controls = new GraphControlPanel();

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        add(plot);
        add(controls);
    }
}
