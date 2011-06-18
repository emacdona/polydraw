package net.edmacdonald.playground.java2d;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.log4j.LogSF;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.data.general.Series;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import javax.swing.*;
import javax.swing.border.Border;
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
        pointCount = 100;
        horizontalOffset = 0;
        verticalOffset = 0;
        rotationAngle = 0;

        XYPlot plot = new XYPlot();

        XYSeries series = new XYSeries("XYGraph");
        series.add(0,0);
        series.add(1,1);
        series.add(2,2);
        series.add(3,3);
        series.add(4,4);
        series.add(5,5);
        series.add(6,6);
        series.add(7,7);
        series.add(8,8);
        series.add(9,9);
        series.add(10,10);

        XYSeriesCollection dataset = new XYSeriesCollection();
        dataset.addSeries(getSeries());

        //JFreeChart chart = new JFreeChart("Your Polygon", JFreeChart.DEFAULT_TITLE_FONT, plot, false);
        JFreeChart chart = ChartFactory.createXYLineChart("Polygon","x","y",dataset, PlotOrientation.HORIZONTAL,false,false,false);
        ChartPanel cpanel = new ChartPanel(chart);
        cpanel.setPreferredSize(new Dimension(200, 200));
        setPreferredSize(new Dimension(200,200));
        add(cpanel);
        setBorder(BorderFactory.createEtchedBorder());
        setVerifyInputWhenFocusTarget(true);
    }

    public XYSeries getSeries() {
        XYSeries series = new XYSeries("PolySeries");
        double x, y, theta;

        for(int i=0; i<pointCount; i++) {
            theta = (Math.PI / 180) * (360 * i / pointCount);
            x = Math.cos(radius * theta) + horizontalOffset;
            y = Math.sin(radius * theta) + verticalOffset;
            log.info("Adding coordinates, <x, y> : <" + x + ", " + y + ">");
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
