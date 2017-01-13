
package Controller;

import Libary.DataManager;
import Model.PhieuXuatModel;
import View.PhieuXuatView;
import java.awt.event.ActionEvent;




public class PhieuXuatController extends AbstractController {

    //Attribute MVC

    PhieuXuatView view;
    PhieuXuatModel model;
    //Attribute data
    public String soPhieuXuat;
    public String ngayXuat;
    public String maKhach;
    public String tenKhach;

    @Override
    public void init() {
        model = new PhieuXuatModel();
        setModel(model);
        view = new PhieuXuatView();
        setView(view);
        setButton(view.getBtnThem(), view.getBtnSua(),view.getBtnLuu(), view.getBtnXoa(),view.getBtnHuy(),view.getBtnThoat());
        setTable(view.getTable());
        addActionButton();
        addActionSelectRow();
        initManager();
        view.getBtnCTX().addActionListener(this);
    }

    @Override
    public void getData() {
        soPhieuXuat = view.getTfSoPhieuXuat().getText();
        ngayXuat = view.getTfNgayXuat().getText();
        maKhach = view.getTfMaKhach().getText();
        tenKhach = view.getTfTenKhach().getText();
    }

    @Override
    public void setData() {
        view.getTfSoPhieuXuat().setText(soPhieuXuat);
        view.getTfNgayXuat().setText(ngayXuat);
        view.getTfMaKhach().setText(maKhach);;
        view.getTfTenKhach().setText(tenKhach);
    }

    @Override
    public void nullInput() {
        super.nullInput(); //To change body of generated methods, choose Tools | Templates.
        view.getTfSoPhieuXuat().setText(null);
        view.getTfMaKhach().setText(null);
        view.getTfNgayXuat().setText(null);
        view.getTfTenKhach().setText(null);
       
    }
     @Override
    public void eventSelect() {
        super.eventSelect(); //To change body of generated methods, choose Tools | Templates.
        Object[] data = getDataInRow();
        soPhieuXuat =  (String) data[0];
        ngayXuat = (String) data[1].toString();
        maKhach = (String) data[2];
        tenKhach = (String) data[3];
    }
     @Override
    public void createDataModel() {
        super.createDataModel(); //To change body of generated methods, choose Tools | Templates.
        Object[] data = {ngayXuat, maKhach, tenKhach};
        DataManager datamanager = new DataManager(soPhieuXuat, data);
        setDataModel(datamanager);
    }


    @Override
    public void enableInput() {
        super.enableInput(); //To change body of generated methods, choose Tools | Templates.
        view.getTfSoPhieuXuat().enable(true);
        view.getTfNgayXuat().enable(true);
        view.getTfMaKhach().enable(true);
        view.getTfTenKhach().enable(true);
        
    }

    @Override
    public void unenableInput() {
        super.unenableInput(); //To change body of generated methods, choose Tools | Templates.
        view.getTfSoPhieuXuat().enable(false);
        view.getTfNgayXuat().enable(false);
        view.getTfMaKhach().enable(false);
        view.getTfTenKhach().enable(false);
       
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

    @Override
    public void actionPerformed(ActionEvent ae) {
        super.actionPerformed(ae); //To change body of generated methods, choose Tools | Templates.
        if(ae.getSource() == view.getBtnCTX()){
            ChiTietXuatController chiTietXuatController = new ChiTietXuatController(soPhieuXuat);
            chiTietXuatController.setDesktop(desktop);
            chiTietXuatController.show();
        }
    }
    
    
    
    
}
