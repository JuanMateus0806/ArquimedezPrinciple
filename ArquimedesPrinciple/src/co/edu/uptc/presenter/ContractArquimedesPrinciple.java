package co.edu.uptc.presenter;

public interface ContractArquimedesPrinciple {

    interface model{
        void setPresenter(ContractArquimedesPrinciple.presenter presenter);
        void refresh();
    }

    interface presenter{
        void setModel(ContractArquimedesPrinciple.model model);
        void setView(ContractArquimedesPrinciple.view view);
        void refresh();
    }

    interface view{
        void setPresenter(ContractArquimedesPrinciple.presenter presenter);
        void start();
        void refresh();
    }



}
