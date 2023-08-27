package co.edu.uptc.presenter;

import co.edu.uptc.model.ManagerModel;
import co.edu.uptc.view.DashBoard;

public class ManagerGeneral {

    public static ManagerGeneral instance;
    ContractArquimedesPrinciple.model model;
    ContractArquimedesPrinciple.presenter presenter;
    ContractArquimedesPrinciple.view view;

    public void createMVP(){
        view = new DashBoard();

        presenter = new Presenter();
        presenter.setView(view);

        model = new ManagerModel();
        model.setPresenter(presenter);
        presenter.setModel(model);
        view.setPresenter(presenter);
    }


    public static ManagerGeneral getInstance() {
        return instance == null ? instance = new ManagerGeneral() : instance;
    }

    public void runProject(){
        createMVP();
        view.start();
    }

}
