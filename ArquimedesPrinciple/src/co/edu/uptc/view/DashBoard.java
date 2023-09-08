package co.edu.uptc.view;

import co.edu.uptc.presenter.ContractArquimedesPrinciple;

import javax.swing.*;
import java.awt.*;

public class DashBoard extends JFrame implements ContractArquimedesPrinciple.view {

    ContractArquimedesPrinciple.presenter presenter;
    private PanelValueObject panelObject;

    public DashBoard(){
        config();
        initComponent();
    }

    public void config(){
        this.setSize(new Dimension(800,600));
        this.setLayout(null);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public void initComponent(){
        createPanelObject();
    }

    @Override
    public void setPresenter(ContractArquimedesPrinciple.presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void start() {
        this.setVisible(true);
    }

    @Override
    public void refresh() {
        this.repaint();
        panelObject.changeMassExact();
        panelObject.changeVolumeExact();
    }

    private void createPanelObject(){
        panelObject = new PanelValueObject();
        panelObject.setBounds(0,0,800,80);
        add(panelObject);
    }


}
