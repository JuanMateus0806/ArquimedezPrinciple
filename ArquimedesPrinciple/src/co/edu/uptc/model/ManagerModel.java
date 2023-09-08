package co.edu.uptc.model;

import co.edu.uptc.presenter.ContractArquimedesPrinciple;
import co.edu.uptc.utils.Utils;

public class ManagerModel implements ContractArquimedesPrinciple.model {

    ContractArquimedesPrinciple.presenter presenter;
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
}
