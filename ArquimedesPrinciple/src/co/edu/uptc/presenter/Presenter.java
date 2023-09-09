package co.edu.uptc.presenter;

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
}
