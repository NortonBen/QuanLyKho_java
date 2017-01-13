
package Controller;

import View.ThongKeNhapView;
import Model.ThongKeNhapModel;


public class ThongKeNhapController extends AbstractController {
    //Attribute MVC
     ThongKeNhapModel model;
     ThongKeNhapView view;
    //Attribute data
   
    public String thang ;
    public String nam;

    @Override
    public void init() {
        model = new ThongKeNhapModel();
        setModel(model);
        view = new ThongKeNhapView();
        setView(view);
        setButton(null, null, null, null,null, view.getBtnThoat());
        addActionButton();
        setTable(view.getTable());
        setThongke(view.getBtnOK(),view.getTfThang(),view.getTfNam());
       
        
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
        
        view.getTfThang().setText(null);
        view.getTfNam().setText(null);
    }
   
    

    @Override
    public void enableInput() {
       
        view.getTfThang().enable(true);
        view.getTfNam().enable(true);
        
    }

    @Override
    public void unenableInput() {
        
        view.getTfThang().enable(false);
        view.getTfNam().enable(false);
       
    }
      @Override
    public void actionexit() {
        super.actionexit(); //To change body of generated methods, choose Tools | Templates.
        view.dispose();
    }

    @Override
    public void reloadview() {
        super.reloadview(); //To change body of generated methods, choose Tools | Templates.
        view.revalidate();
        view.pack();
    }

   
    
    
    
}
    

