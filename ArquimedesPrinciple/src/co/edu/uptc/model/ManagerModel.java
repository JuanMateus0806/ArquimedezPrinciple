package co.edu.uptc.model;

import co.edu.uptc.presenter.ContractArquimedesPrinciple;
import co.edu.uptc.utils.Utils;

public class ManagerModel implements ContractArquimedesPrinciple.model {

    public ContractArquimedesPrinciple.presenter presenter;
    private boolean start;

    public ManagerModel(){
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

    public double CalculateDensity(double mass, double volume) {
        /* Obtiene la masa y el volumen del objeto
         Calcula la densidad*/
        double density = mass / volume;

        return density;
    }


    public double CalculateFloatingForce(double mass,double volume) {
        // Obtiene la densidad del objeto
        double density = CalculateDensity(mass,volume);
        double gravity = 9.81;
        // Calcular la fuerza de flotación
        double floatingForce = density * volume * gravity;

        return floatingForce;
    }

}
