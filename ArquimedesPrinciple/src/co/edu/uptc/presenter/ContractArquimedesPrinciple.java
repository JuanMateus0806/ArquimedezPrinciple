package co.edu.uptc.presenter;

import co.edu.uptc.pojos.ObjectP;

import java.awt.*;

public interface ContractArquimedesPrinciple {

    interface model{
        void setPresenter(ContractArquimedesPrinciple.presenter presenter);
        void refresh();
        void setPosition(Point position);
        double changeDensity();
        void updateMassAndVolume(int mass, int volume);
        ObjectP getObjectP();

    }

    interface presenter{
        void setModel(ContractArquimedesPrinciple.model model);
        void setView(ContractArquimedesPrinciple.view view);
        void refresh();
        void setPosition(Point position);
        double changeDensity();
        void updateMassAndVolume(int mass, int volume);
        ObjectP getObjectP();
    }

    interface view{
        void setPresenter(ContractArquimedesPrinciple.presenter presenter);
        void start();
        void refresh();
    }



}
