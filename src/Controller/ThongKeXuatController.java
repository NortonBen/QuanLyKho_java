/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;
import View.ThongKeXuatView;
import Model.ThongKeXuatModel;



public class ThongKeXuatController extends AbstractController {
    //Attribute MVC
     ThongKeXuatModel model;
     ThongKeXuatView view;
    //Attribute data
   
    public String thang ;
    public String nam;

    @Override
    public void init() {
        model = new ThongKeXuatModel();
        setModel(model);
        view = new ThongKeXuatView();
        setView(view);
        setButton(null, null, null, null, null, view.getBtnThoat());
        addActionButton();
        setTable(view.getTable());
        setThongke(view.getBtnOK(),view.getTfThang(),view.getTfNam());
        //addActionSelectRow();
        //initManager();
        
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
        super.nullInput(); //To change body of generated methods, choose Tools | Templates.
        view.getTfThang().setText(null);
        view.getTfNam().setText(null);
    }
    
    

    @Override
    public void enableInput() {
        super.enableInput(); //To change body of generated methods, choose Tools | Templates.
        view.getTfThang().enable(true);
        view.getTfNam().enable(true);
        
    }

    @Override
    public void unenableInput() {
        super.unenableInput(); //To change body of generated methods, choose Tools | Templates.
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
