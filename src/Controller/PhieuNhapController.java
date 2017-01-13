/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Libary.DataManager;
import View.PhieuNhapView;
import Model.PhieuNhapModel;
import java.awt.event.ActionEvent;



public class PhieuNhapController extends AbstractController{
    //Attribute MVC
    PhieuNhapModel model;
    PhieuNhapView view;
    //Attribute data
    public String soPhieuNhap;
    public String ngayNhap;
    public String maNCC;
    public String tenNCC;
    
    

    @Override
    public void init() {
        model = new PhieuNhapModel();
        setModel( model);
        view = new PhieuNhapView();
        setView(view);
        setButton(view.getBtnThem(), view.getBtnSua(),view.getBtnLuu(), view.getBtnXoa(),view.getBtnHuy(),view.getBtnThoat());
        setTable(view.getTable());
        addActionButton();
        addActionSelectRow();
        initManager();
        view.btnCTN.addActionListener(this);
    }

    @Override
    public void getData() {
        soPhieuNhap = view.getTfSoPhieuNhap().getText();
        ngayNhap = view.getTfNgayNhap().getText();
        maNCC = view.getTfMaNCC().getText();
        tenNCC = view.getTfTenNCC().getText();
       
    }

    @Override
    public void setData() {
        view.getTfSoPhieuNhap().setText(soPhieuNhap);
        view.getTfNgayNhap().setText(ngayNhap);
        view.getTfMaNCC().setText(maNCC);
        view.getTfTenNCC().setText(tenNCC);
    }

    @Override
    public void nullInput() {
        super.nullInput(); //To change body of generated methods, choose Tools | Templates.
        view.getTfSoPhieuNhap().setText(null);
        view.getTfMaNCC().setText(null);
        view.getTfNgayNhap().setText(null);
        view.getTfTenNCC().setText(null);
    }
      @Override
    public void eventSelect() {
        super.eventSelect(); //To change body of generated methods, choose Tools | Templates.
        Object[] data = getDataInRow();
        soPhieuNhap =  (String) data[0];
        ngayNhap =data[1].toString();
        maNCC = (String) data[2];
        tenNCC = (String) data[3];
    }
     @Override
    public void createDataModel() {
        super.createDataModel(); //To change body of generated methods, choose Tools | Templates.
        Object[] data = {ngayNhap, maNCC, tenNCC};
        DataManager datamanager = new DataManager(soPhieuNhap, data);
        setDataModel(datamanager);
    }

    @Override
    public void enableInput() {
        super.enableInput(); //To change body of generated methods, choose Tools | Templates.
        view.getTfSoPhieuNhap().enable(true);
        view.getTfNgayNhap().enable(true);
        view.getTfMaNCC().enable(true);
        view.getTfTenNCC().enable(true);
       
    }

    @Override
    public void unenableInput() {
        super.unenableInput(); //To change body of generated methods, choose Tools | Templates.
        view.getTfSoPhieuNhap().enable(false);
        view.getTfNgayNhap().enable(false);
        view.getTfMaNCC().enable(false);
        view.getTfTenNCC().enable(false);
       
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
        if(ae.getSource() == view.btnCTN){
            ChiTietNhapController chiTietNhapController = new ChiTietNhapController(soPhieuNhap);
            chiTietNhapController.setDesktop(desktop);
            chiTietNhapController.show();
        }
    }
    
    
    
}
