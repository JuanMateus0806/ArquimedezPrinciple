package co.edu.uptc.presenter;

import co.edu.uptc.pojos.ObjectP;

import java.awt.*;

public class Presenter implements ContractArquimedesPrinciple.presenter{

    ContractArquimedesPrinciple.model model;
    ContractArquimedesPrinciple.view view;

    @Override
    public void setModel(ContractArquimedesPrinciple.model model) {
        this.model = model;
    }

    @Override
    public void setView(ContractArquimedesPrinciple.view view) {
        this.view = view;
    }

    @Override
    public void refresh() {
        view.refresh();
    }

    @Override
    public void setPosition(Point position) {
        model.setPosition(position);
    }

    @Override
    public double changeDensity() {
        return model.changeDensity();
    }

    @Override
    public void updateMassAndVolume(int mass, int volume) {
        model.updateMassAndVolume(mass,volume);
    }

    @Override
    public double changeBuoyancyForce() {
        return model.changeBuoyancyForce();
    }

    @Override
    public ObjectP getObjectP() {
        return model.getObjectP();
    }
}
