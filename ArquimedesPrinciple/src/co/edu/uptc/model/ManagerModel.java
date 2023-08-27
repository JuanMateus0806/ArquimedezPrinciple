package co.edu.uptc.model;

import co.edu.uptc.presenter.ContractArquimedesPrinciple;

public class ManagerModel implements ContractArquimedesPrinciple.model {

    ContractArquimedesPrinciple.presenter presenter;

    @Override
    public void setPresenter(ContractArquimedesPrinciple.presenter presenter) {
        this.presenter = presenter;
    }


}
