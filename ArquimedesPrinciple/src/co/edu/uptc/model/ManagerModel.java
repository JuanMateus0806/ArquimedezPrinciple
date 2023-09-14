package co.edu.uptc.model;

import co.edu.uptc.pojos.ObjectP;
import co.edu.uptc.presenter.ContractArquimedesPrinciple;
import co.edu.uptc.utils.Utils;
import co.edu.uptc.view.PanelObject;

import java.awt.*;

public class ManagerModel implements ContractArquimedesPrinciple.model {

    ContractArquimedesPrinciple.presenter presenter;
    private boolean start;
    private ObjectP objectP;

    public ManagerModel(){
        objectP = new ObjectP(new Rectangle(0,0,40,40),200,200);
        start = true;
        refresh();
    }

    @Override
    public void setPresenter(ContractArquimedesPrinciple.presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void refresh() {

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                while(start){
                    presenter.refresh();
                    Utils.sleepP(100);
                }
            }
        });
        thread.start();
    }

    @Override
    public void setPosition(Point position) {
        Dimension aux = new Dimension(objectP.getRectangle().width,objectP.getRectangle().height);
        objectP.setRectangle(new Rectangle(position,aux));
    }

    @Override
    public double changeDensity() {
        return objectP.getDensity();
    }

    @Override
    public ObjectP getObjectP() {
        return objectP;
    }

    @Override
    public void updateMassAndVolume(int mass, int volume) {
        objectP.setMass(mass);
        objectP.setVolume(volume);
        updateDensity();
        updateDimensionObject();
    }

    private void updateDensity(){
        objectP.setDensity(objectP.getMass()/objectP.getVolume());
    }

    private void updateDimensionObject(){
        int l = (int) (9*Math.cbrt(objectP.getVolume()));
        objectP.setRectangle(new Rectangle(objectP.getRectangle().x,objectP.getRectangle().y,
                l,l));
    }

}
