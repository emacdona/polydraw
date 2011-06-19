package net.edmacdonald.playground.java2d;

import javax.swing.*;

public class App extends JFrame {
    private GraphControlPanel gcp = new GraphControlPanel();
    private PlotPanel pp = new PlotPanel();

    public App(){
        setTitle("Polygons");
        setSize( 800, 800 );
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        getContentPane().add(new MainPanel());
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
