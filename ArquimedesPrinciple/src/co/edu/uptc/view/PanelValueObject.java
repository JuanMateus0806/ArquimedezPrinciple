package co.edu.uptc.view;

import co.edu.uptc.pojos.ObjectP;

import javax.swing.*;
import java.awt.*;

public class PanelValueObject extends JPanel {

    private DashBoard dashBoard;
    private JLabel txtVolume;
    private JSlider volume;
    private JLabel txtMass;
    private JSlider mass;
    private JLabel density;
    private JLabel buoyancyForce;

    public PanelValueObject(DashBoard dashBoard){
        this.dashBoard = dashBoard;
        config();
        initComponent();
    }

    public void config(){
        this.setSize(new Dimension(800,80));
        this.setLayout(null);
        this.setBackground(new Color(248,227,197));
    }

    public void initComponent(){
        createTxtMassMaterial();
        createMassMaterial();
        createTxtVolumeMaterial();
        createVolumeMaterial();
        createTxtDensity();
        createTxtBuoyancyForce();
    }

    private void createTxtMassMaterial(){
        txtMass = new JLabel("Masa del material:");
        txtMass.setFont(new Font("Arial",Font.BOLD,12));
        txtMass.setForeground(new Color(22,33,111));
        txtMass.setBounds(25,15,180,20);
        add(txtMass);
    }

    private void createMassMaterial(){
        mass = new JSlider(SwingConstants.HORIZONTAL,100,700,200);
        mass.setBounds(25,40,140,20);
        mass.createStandardLabels(100,216);
        add(mass);
    }

    public void changeMassExact(){
        txtMass.setText("Masa del material: "+mass.getValue() +" Kg");
    }

    private void createTxtVolumeMaterial(){
        txtVolume = new JLabel("Volumen del material:");
        txtVolume.setFont(new Font("Arial",Font.BOLD,12));
        txtVolume.setForeground(new Color(22,33,111));
        txtVolume.setBounds(600,15,190,20);
        add(txtVolume);
    }

    private void createVolumeMaterial(){
        volume = new JSlider(SwingConstants.HORIZONTAL,100,700,200);
        volume.setBounds(600,40,140,20);
        add(volume);
    }

    public void changeVolumeExact(){
        txtVolume.setText("Volumen del objeto: "+ volume.getValue()+ " m^3");
    }

    private int massObject(){
        return mass.getValue();
    }

    private int volumeObject(){
        return volume.getValue();
    }

    public void updateMassAndVolume(){
        dashBoard.presenter.updateMassAndVolume(massObject(),volumeObject());
    }

    public void createTxtDensity(){
        density = new JLabel("Densidad: ");
        density.setBounds(220,30,130,20);
        density.setForeground(new Color(22,33,111));
        density.setFont(new Font("Arial",Font.BOLD,12));
        add(density);
    }

    public void changeDensity(){
        density.setText("Densidad: "+ dashBoard.presenter.changeDensity());
    }

    public void createTxtBuoyancyForce(){
        buoyancyForce = new JLabel("F.Flotacion: 0 N");
        buoyancyForce.setBounds(360,30,180,20);
        buoyancyForce.setForeground(new Color(22,33,111));
        buoyancyForce.setFont(new Font("Arial",Font.BOLD,12));
        add(buoyancyForce);
    }

    public void changeBuoyancyForce(){
        buoyancyForce.setText("F.Flotacion: "+ dashBoard.presenter.changeBuoyancyForce()+" N");
    }

}
