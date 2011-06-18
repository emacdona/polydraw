package net.edmacdonald.playground.java2d;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import javax.swing.*;
import java.awt.*;

public class PlotPanel extends JPanel{

    private Integer radius;
    private Integer pointCount;
    private Integer horizontalOffset;
    private Integer verticalOffset;
    private Integer rotationAngle;

    private Log log = LogFactory.getLog(PlotPanel.class);

    public PlotPanel(){
        radius = 1;
        pointCount = 10;
        horizontalOffset = 0;
        verticalOffset = 0;
        rotationAngle = 0;

        XYPlot plot = new XYPlot();

        XYSeriesCollection dataset = new XYSeriesCollection();
        dataset.addSeries(getSeries());

        JFreeChart chart = ChartFactory.createXYLineChart(null, null, null, dataset, PlotOrientation.VERTICAL, false, false, false);

        ChartPanel cpanel = new ChartPanel(chart);
        cpanel.setPreferredSize(new Dimension(200, 200));
        setPreferredSize(new Dimension(200,200));
        add(cpanel);
        setBorder(BorderFactory.createEtchedBorder());
        setVerifyInputWhenFocusTarget(true);
    }

    public XYSeries getSeries() {
        XYSeries series = new XYSeries("PolygonSeries", false);
        double x, y, theta;

        for(int i=0; i<=pointCount; i++) {
            theta = (Math.PI / 180) * (360 * i / pointCount) + rotationAngle;
            x = Math.cos(radius * theta) + horizontalOffset;
            y = Math.sin(radius * theta) + verticalOffset;
            log.debug("Adding coordinates <x, y>: <" + x + ", " + y + ">");
            series.add(x,y);
        }

        return series;
    }

    public Integer getRadius() {
        return radius;
    }

    public void setRadius(Integer radius) {
        this.radius = radius;
    }

    public Integer getPointCount() {
        return pointCount;
    }

    public void setPointCount(Integer pointCount) {
        this.pointCount = pointCount;
    }

    public Integer getHorizontalOffset() {
        return horizontalOffset;
    }

    public void setHorizontalOffset(Integer horizontalOffset) {
        this.horizontalOffset = horizontalOffset;
    }

    public Integer getVerticalOffset() {
        return verticalOffset;
    }

    public void setVerticalOffset(Integer verticalOffset) {
        this.verticalOffset = verticalOffset;
    }

    public Integer getRotationAngle() {
        return rotationAngle;
    }

    public void setRotationAngle(Integer rotationAngle) {
        this.rotationAngle = rotationAngle;
    }
}
