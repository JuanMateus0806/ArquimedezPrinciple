package co.edu.uptc.presenter;

public interface ContractArquimedesPrinciple {

    interface model{
        void setPresenter(ContractArquimedesPrinciple.presenter presenter);
    }

    interface presenter{
        void setModel(ContractArquimedesPrinciple.model model);
        void setView(ContractArquimedesPrinciple.view view);
    }

    interface view{
        void setPresenter(ContractArquimedesPrinciple.presenter presenter);
        void start();
    }



}
