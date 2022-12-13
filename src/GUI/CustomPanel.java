package GUI;

import javax.swing.*;
import java.awt.*;

public class CustomPanel extends JPanel {
    public CustomPanel(){
        setOpaque(false);
    }

    @Override
    protected void paintComponent(Graphics g){
        Graphics2D gd = (Graphics2D) g.create();
        super.paintComponent(g);

        gd.setPaint(new GradientPaint(0,0,Color.decode("#8B8B8B"),0, 90,Color.white));
        gd.fillRect(0,0,getWidth(),getHeight());
        gd.dispose();
    }
}
/*
    Tree Way Gradient
        GradientPaint primary = new GradientPaint(200f, -200f, Color.WHITE, 200f, 0f, Color.ORANGE);
        GradientPaint shade = new GradientPaint(0f, 0f, new Color(0, 0, 0, 0),
                                                0f, 200f, new Color(0, 0, 0, 255));
        gd.setPaint(primary);
        gd.fillRect(0, 0, getWidth(),getHeight());
        gd.setPaint(shade);
        gd.fillRect(0, 0, getWidth(),getHeight());
*/