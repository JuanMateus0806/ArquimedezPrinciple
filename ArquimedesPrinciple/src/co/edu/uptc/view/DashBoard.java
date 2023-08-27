package co.edu.uptc.view;

import co.edu.uptc.presenter.ContractArquimedesPrinciple;

import javax.swing.*;

public class DashBoard extends JFrame implements ContractArquimedesPrinciple.view {

    ContractArquimedesPrinciple.presenter presenter;

    @Override
    public void setPresenter(ContractArquimedesPrinciple.presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void start() {
        this.setVisible(true);
    }
}
