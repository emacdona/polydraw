package net.edmacdonald.playground.java2d;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYItemRenderer;
import org.jfree.data.Range;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import javax.swing.*;
import java.awt.*;

public class PlotPanel extends JPanel{

    private Integer radius = 5;
    private Integer pointCount = 3;
    private Integer horizontalOffset = 0;
    private Integer verticalOffset = 0;
    private Integer rotationAngle = 90;
    private Boolean graphicalDebug = false;

    private ChartPanel chartPanel;

    private Log log = LogFactory.getLog(PlotPanel.class);

    public PlotPanel(){

        JFreeChart chart = ChartFactory.createXYLineChart(null, null, null, null, PlotOrientation.VERTICAL, false, false, false);

        chart.getXYPlot().getDomainAxis().setRange(new Range(-10, 10));
        chart.getXYPlot().getRangeAxis().setRange(new Range(-10, 10));
        chartPanel = new ChartPanel(chart);
        plot();

        chartPanel.setPreferredSize(new Dimension(500,500));

        add(chartPanel);
        log.debug("Chart Panel dimension: " + chartPanel.getPreferredSize());
        setPreferredSize( chartPanel.getPreferredSize() );
        setBorder(BorderFactory.createEtchedBorder());
        setVerifyInputWhenFocusTarget(true);
    }

    public void plot() {
        JFreeChart chart = chartPanel.getChart();
        XYPlot plot = chart.getXYPlot();
        XYItemRenderer renderer = plot.getRenderer();

        chart.getXYPlot().getDomainAxis().setRange(new Range(-10, 10));
        chart.getXYPlot().getRangeAxis().setRange(new Range(-10, 10));

        plot.setDataset(null);
        XYSeriesCollection dataset = new XYSeriesCollection();

        dataset.addSeries(getSeries());
        renderer.setSeriesPaint(0, Color.BLUE);

        dataset.addSeries(getCircle());
        renderer.setSeriesPaint(1, Color.RED);

        if(graphicalDebug) {
            dataset.addSeries(getDisplacementVector());
            renderer.setSeriesPaint(2, Color.GRAY);

            dataset.addSeries(getHorizon());
            renderer.setSeriesPaint(3, Color.BLACK);

            dataset.addSeries(getInclination());
            renderer.setSeriesPaint(4, Color.BLACK);

            dataset.addSeries(getInclinationArc());
            renderer.setSeriesPaint(5, Color.BLACK);
        }

        plot.setDataset(dataset);
    }

    public XYSeries getSeries() {
        XYSeries series = new XYSeries("PolygonSeries", false);
        double x, y, theta;

        for(int i=0; i<=pointCount; i++) {
            theta = (Math.PI / 180) * ((360 * i / pointCount) + rotationAngle);
            x = radius * Math.cos(theta) + horizontalOffset;
            y = radius * Math.sin(theta) + verticalOffset;
            log.debug("Adding coordinates <x, y>: <" + x + ", " + y + ">");
            series.add(x,y);
        }

        return series;
    }

    public XYSeries getCircle() {
        XYSeries series = new XYSeries("Circle", false);
        double x, y, theta;

        for(int i=0; i<=200; i++) {
            theta = (Math.PI / 180) * ((360 * i / 200) + rotationAngle);
            x = radius * Math.cos(theta) + horizontalOffset;
            y = radius * Math.sin(theta) + verticalOffset;
            series.add(x,y);
        }
        return series;
    }

    public XYSeries getDisplacementVector() {
        XYSeries series = new XYSeries("Displacement Vector", false);

        series.add(0,0);
        series.add(horizontalOffset, verticalOffset);

        return series;
    }

    public XYSeries getHorizon() {
        XYSeries series = new XYSeries("Horizon", false);

        series.add(horizontalOffset, verticalOffset);
        series.add(horizontalOffset + radius, verticalOffset);

        return series;
    }

    public XYSeries getInclination() {
        XYSeries series = new XYSeries("Horizon", false);
        double x, y, theta;

        theta = (Math.PI / 180) * rotationAngle;
        x = radius * Math.cos(theta) + horizontalOffset;
        y = radius * Math.sin(theta) + verticalOffset;

        series.add(horizontalOffset, verticalOffset);
        series.add(x, y);

        return series;
    }

    public XYSeries getInclinationArc() {
        XYSeries series = new XYSeries("Circle", false);
        double x, y, theta;
        int t = 0;

        if( (rotationAngle != 90) && (rotationAngle != 270) ){
            while(t < rotationAngle) {
                theta = (Math.PI / 180) * t;
                x = 0.25 * radius * Math.cos(theta) + horizontalOffset;
                y = 0.25 * radius * Math.sin(theta) + verticalOffset;
                series.add(x,y);
                t++;
            }
        }
        else {
            double d = 0.25 * radius;
            int factor = rotationAngle == 90 ? 1 : -1;

            series.add(horizontalOffset, verticalOffset);
            series.add(horizontalOffset + d, verticalOffset);
            series.add(horizontalOffset + d, verticalOffset + (factor * d) );
            series.add((float )horizontalOffset, verticalOffset + (factor * d) );
            series.add(horizontalOffset, verticalOffset);
        }

        return series;
    }

    public void setRadius(Integer radius) {
        this.radius = radius;
        log.trace("Radius changed. New value: " + radius);
    }

    public void setPointCount(Integer pointCount) {
        this.pointCount = pointCount;
        log.trace("Point count changed. New value: " + pointCount);
    }

    public void setHorizontalOffset(Integer horizontalOffset) {
        this.horizontalOffset = horizontalOffset;
        log.trace("Horizontal offset changed. New value: " + horizontalOffset);
    }

    public void setVerticalOffset(Integer verticalOffset) {
        this.verticalOffset = verticalOffset;
        log.trace("Vertical offset changed. New value: " + verticalOffset);
    }

    public void setRotationAngle(Integer rotationAngle) {
        this.rotationAngle = rotationAngle;
        log.trace("Rotation angle changed. New value: " + rotationAngle);
    }

    public void setGraphicalDebug(Boolean graphicalDebug) {
        this.graphicalDebug = graphicalDebug;
    }
}
