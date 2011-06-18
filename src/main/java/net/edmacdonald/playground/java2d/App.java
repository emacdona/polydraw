package net.edmacdonald.playground.java2d;

import javax.swing.*;

public class App extends JFrame {
    private GraphControlPanel gcp = new GraphControlPanel();
    private PlotPanel pp = new PlotPanel();

    public App(){
        setTitle("Polygons");
        setSize(300, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        pp.add(gcp);
        getContentPane().add(pp);
        //getContentPane().add(gcp);
    }

    public static void main( String[] args )
    {
        SwingUtilities.invokeLater(new Runnable(){
            @Override
            public void run() {
                App app = new App();
                app.setVisible(true);
            }
        });
    }
}
