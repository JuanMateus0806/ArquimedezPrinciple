package co.edu.uptc.model;

import co.edu.uptc.pojos.ObjectP;
import co.edu.uptc.presenter.ContractArquimedesPrinciple;
import co.edu.uptc.utils.Utils;
import co.edu.uptc.view.PanelObject;

import java.awt.*;

public class ManagerModel implements ContractArquimedesPrinciple.model {

    public ContractArquimedesPrinciple.presenter presenter;
    private boolean start;
    private ObjectP objectP;
    private Rectangle water;
    private double gravity;
    private double densityWater;


    public ManagerModel(){
        initComponent();
    }

    private void initComponent(){
        this.water = new Rectangle(new Point(150,280),new Dimension(500,220));
        objectP = new ObjectP(new Rectangle(0,0,40,40),200,200);
        start = true;
        this.gravity = 9.8;
        this.densityWater = 1.0;
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

    @Override
    public double changeBuoyancyForce() {
        return calculateBuoyancyForce();
    }

    private void updateDensity(){
        objectP.setDensity(objectP.getMass()/objectP.getVolume());
    }

    private void updateDimensionObject(){
        int l = (int) (9*Math.cbrt(objectP.getVolume()));
        objectP.setRectangle(new Rectangle(objectP.getRectangle().x,objectP.getRectangle().y,
                l,l));
    }

    private double calculateBuoyancyForce(){
        double buoyancyForce = 0.0;
        switch (verifiedObjectInsideWater()){
            case(1)-> buoyancyForce = calculateBuoyancyForteObjectSubmergedTotal();
            case(2)-> buoyancyForce = calculateBuoyancyForceWithObjectSubmergedPartial();
        }
        return buoyancyForce;
    }

    private int verifiedObjectInsideWater(){
        int option = -1;
        if (water.contains(objectP.getRectangle().getLocation())){
            if (objectP.getRectangle().x<((water.x+water.width)-objectP.getRectangle().width)){
                option = 1;
            }
        }else{
            Point p = new Point(objectP.getRectangle().x,(int)(objectP.getRectangle().y+(9*Math.cbrt(objectP.getVolume()))));
            if (water.contains(p)){
                if (objectP.getRectangle().x<((water.x+water.width)-objectP.getRectangle().width)){
                    option = 2;
                }
            }
        }
        return option;
    }

    private int calculateBuoyancyForteObjectSubmergedTotal(){
        return (int) (densityWater*objectP.getVolume()*gravity);
    }

    private int calculateBuoyancyForceWithObjectSubmergedPartial(){
        double volume = calculateVolumeObjectSubmergedPartial();
        return (int) (densityWater*volume*gravity);
    }

    private double calculateVolumeObjectSubmergedPartial(){
        double l = objectP.getRectangle().width/9.0;
        double h = ((objectP.getRectangle().width+objectP.getRectangle().y)-280)/9.0;
        return (l*l*h);
    }

}
