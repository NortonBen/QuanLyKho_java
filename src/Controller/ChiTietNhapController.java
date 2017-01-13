
package Controller;

import Libary.Convert;
import Libary.DataManager;
import Model.ChiTietNhapModel;
import View.ChiTietNhapView;


public class ChiTietNhapController extends AbstractController{
    //Attribute MVC
    ChiTietNhapModel model;
    ChiTietNhapView view;
    //Attribute data
    public String soPhieuNhap;
    public String maHang;
    public int soLuongNhap;
    public int donGia;

    public ChiTietNhapController(String soPhieuNhap) {
        this.soPhieuNhap = soPhieuNhap;
        init();;
    }
    
    @Override
    public void init() {
        
        model = new ChiTietNhapModel();
        setModel( model);
        setEXCE();
        view = new ChiTietNhapView();
        view.getTfSoPhieuNhap().setText(soPhieuNhap);
        setView(view);
        setButton(view.getBtnThem(), view.getBtnSua(),view.getBtnLuu(), view.getBtnXoa(),view.getBtnHuy(),view.getBtnThoat());
        setTable(view.getTable());
        addActionButton();
        addActionSelectRow();
        initManager();
    }

    @Override
    public void getData() {
        soPhieuNhap = view.getTfSoPhieuNhap().getText();
        maHang = view.getTfMaHang().getText();
        soLuongNhap = Convert.ToInt(view.getTfSoLuongNhap().getText());
        donGia = Convert.ToInt(view.getTfDonGia().getText());
    }

    @Override
    public void setData() {
        //view.getTfSoPhieuNhap().setText(soPhieuNhap);
        view.getTfMaHang().setText(maHang);
        view.getTfSoLuongNhap().setText(Convert.toString(soLuongNhap));
        view.getTfDonGia().setText(Convert.toString(donGia));
        
    }

    @Override
    public void nullInput() {
        super.nullInput(); //To change body of generated methods, choose Tools | Templates.
        //view.getTfSoPhieuNhap().setText(null);
        view.getTfMaHang().setText(null);
        view.getTfSoLuongNhap().setText(null);
        view.getTfDonGia().setText(null);
       
    }
      @Override
    public void eventSelect() {
        super.eventSelect(); //To change body of generated methods, choose Tools | Templates.
        Object[] data = getDataInRow();
        soPhieuNhap =  (String) data[0];
        maHang = (String) data[1];
        soLuongNhap = Convert.ToInt((String) data[2]);
        donGia = Convert.ToInt((String) data[3]);
    }
     @Override
    public void createDataModel() {
        super.createDataModel(); //To change body of generated methods, choose Tools | Templates.
        Object[] data = {soPhieuNhap,maHang, soLuongNhap, donGia};
        DataManager datamanager = new DataManager(soPhieuNhap,  data);
        setDataModel(datamanager);
    }

    @Override
    public void enableInput() {
        super.enableInput(); //To change body of generated methods, choose Tools | Templates.
        //view.getTfSoPhieuNhap().enable(true);
        view.getTfMaHang().enable(true);
        view.getTfSoLuongNhap().enable(true);
        view.getTfDonGia().enable(true);
    }

    @Override
    public void unenableInput() {
        super.unenableInput(); //To change body of generated methods, choose Tools | Templates.
        view.getTfSoPhieuNhap().enable(false);
        view.getTfMaHang().enable(false);
        view.getTfSoLuongNhap().enable(false);
        view.getTfDonGia().enable(false);
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
    

