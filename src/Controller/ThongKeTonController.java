
package Controller;

import Model.ThongKeTonModel;
import View.ThongKeTonView;


public class ThongKeTonController extends AbstractController {
     //Attribute MVC
     ThongKeTonModel model;
     ThongKeTonView view;
     
    //Attribute data
   
    public String thang ;
    public String nam;

    @Override
    public void init() {
        model = new ThongKeTonModel();
        setModel(model);
        view = new ThongKeTonView();
        setView(view);
        setButton(null, null, null, null, null, view.getBtnThoat());
        addActionButton();
        setTable(view.getTable());
        setThongke(view.getBtnOK(),view.getTfNam(),view.getTfThang());
        
    }

    @Override
    public void getData() {
        thang = view.getTfThang().getText();
        nam = view.getTfNam().getText();
        
    }

    @Override
    public void setData() {
        view.getTfThang().setText(thang);
        view.getTfNam().setText(nam);
        
    }

    @Override
    public void nullInput() {
        super.nullInput();
        view.getTfThang().setText(null);
        view.getTfNam().setText(null);
    }
      @Override
    public void eventSelect() {
        super.eventSelect(); 
        Object[] data = getDataInRow();
        thang =  (String) data[0];
        nam = (String) data[1];
        
    }

    @Override
    public void enableInput() {
        super.enableInput(); //To change body of generated methods, choose Tools | Templates.
        view.getTfThang().enable(true);
        view.getTfNam().enable(true);
        
    }

    @Override
    public void unenableInput() {
        super.unenableInput(); 
        view.getTfThang().enable(false);
        view.getTfNam().enable(false);
       
    }
      @Override
    public void actionexit() {
        super.actionexit(); 
        view.dispose();
    }

    @Override
    public void reloadview() {
        super.reloadview(); 
        view.revalidate();
        view.pack();
    }
    
    
    
    
    
}
    

