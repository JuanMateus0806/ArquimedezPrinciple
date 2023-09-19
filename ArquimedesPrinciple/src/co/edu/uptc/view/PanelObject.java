package co.edu.uptc.view;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;


public class PanelObject extends JPanel {

    private DashBoard dashBoard;
    private Rectangle object;
    private boolean selectObject;

    public PanelObject(DashBoard dashBoard){
        this.dashBoard = dashBoard;
        config();
        initComponent();
    }

    private void config(){
        this.setSize(new Dimension(800,520));
        this.setLayout(null);
    }

    private void initComponent(){
        checkSelectObject();
        selectObject = false;
    }

    public void paint(Graphics g){
        object = dashBoard.presenter.getObjectP().getRectangle();
        try {
            Image sky = ImageIO.read(new File("ArquimedesPrinciple/src/data/Sky.jpg"));
            Image land = ImageIO.read(new File("ArquimedesPrinciple/src/data/Land.jpeg"));
            Image water = ImageIO.read(new File("ArquimedesPrinciple/src/data/Water.jpg"));
            g.drawImage(sky,0,0,800,240,this);
            g.drawImage(land,0,240,800,280,this);
            g.drawImage(water,150,280,500,220,this);
            g.setColor(Color.GRAY);
            g.fillRect(object.x,object.y,object.width,object.height);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void checkSelectObject() {
        this.addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                super.mouseDragged(e);
                if (selectObject) {
                    dashBoard.presenter.setPosition(e.getPoint());
                }
            }
        });
        this.addMouseListener(new MouseAdapter() {

            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                Point point = e.getPoint();
                if (dashBoard.presenter.getObjectP() != null) {
                    selectObject = dashBoard.presenter.getObjectP().getRectangle().contains(point);
                }
            }
        });
    }
}
