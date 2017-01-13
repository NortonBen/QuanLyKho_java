
package Controller;

import Libary.AbtractCustomManager;

public abstract class AbstractController extends AbtractCustomManager implements InterfaceController{

    public Object view;
    public Object model;
    public AbstractController() {
      init();
        //initManager();
    }

    @Override
    public abstract void init();
    
    @Override
    public void Request(Object[] obj) {

    }
    
    @Override
    public void setData(Object[] data) {
           
    }

    @Override
    public void EventStateNone() {
        super.EventStateNone(); //To change body of generated methods, choose Tools | Templates.
        setData();
    }

    @Override
    public void loaddata() {
        super.loaddata(); //To change body of generated methods, choose Tools | Templates.
        getData();
    }
    
    
    
    
}
