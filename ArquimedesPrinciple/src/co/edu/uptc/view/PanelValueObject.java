package co.edu.uptc.view;

import javax.swing.*;
import java.awt.*;

public class PanelValueObject extends JPanel {

    private JLabel txtVolume;
    private JSlider volume;
    private JLabel txtVolumeExact;
    private JLabel txtMass;
    private JSlider mass;
    private JLabel txtMassExact;
    private JLabel objectDensity;

    public PanelValueObject(){
        config();
        initComponent();
    }

    public void config(){
        this.setSize(new Dimension(800,80));
        this.setLayout(null);
        this.setBackground(new Color(248,227,197));
    }

    public void initComponent(){
        //createTxtTypeOfMaterial();
        createTxtMassMaterial();
        createMassMaterial();
        createTxtMassExact();
        createTxtVolumeMaterial();
        createVolumeMaterial();
        createTxtVolumeExact();
    }

    private void createTxtTypeOfMaterial(){
        objectDensity = new JLabel("Tipo de material:");
        objectDensity.setFont(new Font("Arial",Font.BOLD,16));
        objectDensity.setBounds(25,15,140,20);
        objectDensity.setForeground(new Color(22,33,111));
        add(objectDensity);
    }

    private void createTxtMassMaterial(){
        txtMass = new JLabel("Masa del material:");
        txtMass.setFont(new Font("Arial",Font.BOLD,16));
        txtMass.setForeground(new Color(22,33,111));
        txtMass.setBounds(25,15,160,20);
        add(txtMass);
    }

    private void createMassMaterial(){
        mass = new JSlider(SwingConstants.HORIZONTAL,100,700,200);
        mass.setBounds(25,40,170,20);
        mass.createStandardLabels(100,216);
        add(mass);
    }
    public void createTxtMassExact(){
        txtMassExact = new JLabel("Masa: " + mass.getValue()+ "Kg");
        txtMassExact.setFont(new Font("Arial",Font.BOLD,12));
        txtMassExact.setForeground(new Color(22,33,111));
        txtMassExact.setBounds(200,30,100,20);
        add(txtMassExact);
    }

    public void changeMassExact(){
        txtMassExact.setText("Masa: "+mass.getValue() +" Kg");
    }

    private void createTxtVolumeMaterial(){
        txtVolume = new JLabel("Volumen del material:");
        txtVolume.setFont(new Font("Arial",Font.BOLD,16));
        txtVolume.setForeground(new Color(22,33,111));
        txtVolume.setBounds(470,15,170,20);
        add(txtVolume);
    }

    private void createVolumeMaterial(){
        volume = new JSlider(SwingConstants.HORIZONTAL,100,700,200);
        volume.setBounds(470,40,160,20);
        add(volume);
    }

    public void createTxtVolumeExact(){
        txtVolumeExact = new JLabel("Volumen: "+volume.getValue()+" m^3");
        txtVolumeExact.setFont(new Font("Arial",Font.BOLD,12));
        txtVolumeExact.setForeground(new Color(22,33,111));
        txtVolumeExact.setBounds(650,30,120,20);
        add(txtVolumeExact);
    }

    public void changeVolumeExact(){
        txtVolumeExact.setText("Volumen: "+volume.getValue()+ " m^3");
    }
}
