
package Controller;

import Libary.Convert;
import Libary.DataManager;
import Model.ChiTietXuatModel;
import View.ChiTietXuatView;


public class ChiTietXuatController extends AbstractController{
    //Attribute MVC
    ChiTietXuatModel model;
    ChiTietXuatView view;
    //Attribute data
    public String soPhieuXuat;
    public String maHang;
    public int soLuongXuat;
    public int donGia;

    public ChiTietXuatController(String soPhieuXuat) {
        this.soPhieuXuat = soPhieuXuat;
        init();
    }
   
    
    @Override
    public void init() {
        model = new ChiTietXuatModel();
        setModel(model);
        setEXCE();
        view = new ChiTietXuatView();
        view.getTfSoPhieuXuat().setText(soPhieuXuat);
        setView(view);
        setButton(view.getBtnThem(), view.getBtnSua(),view.getBtnLuu(), view.getBtnXoa(),view.getBtnHuy(),view.getBtnThoat());
        setTable(view.getTable());
        addActionButton();
        addActionSelectRow();
        initManager();
    }

    @Override
    public void getData() {
        soPhieuXuat = view.getTfSoPhieuXuat().getText();
        maHang = view.getTfMaHang().getText();
        soLuongXuat = Convert.ToInt(view.getTfSoLuongXuat().getText());
        donGia = Convert.ToInt(view.getTfDonGia().getText());
    }

    @Override
    public void setData() {
       // view.getTfSoPhieuXuat().setText(soPhieuXuat);
        view.getTfMaHang().setText(maHang);
        view.getTfSoLuongXuat().setText(Convert.toString(soLuongXuat));
        view.getTfDonGia().setText(Convert.toString(donGia));
        
    }

    @Override
    public void nullInput() {
        super.nullInput(); //To change body of generated methods, choose Tools | Templates.
        //view.getTfSoPhieuXuat().setText(null);
        view.getTfMaHang().setText(null);
        view.getTfSoLuongXuat().setText(null);
        view.getTfDonGia().setText(null);
       
    }
      @Override
    public void eventSelect() {
        super.eventSelect(); //To change body of generated methods, choose Tools | Templates.
        Object[] data = getDataInRow();
        soPhieuXuat =  (String) data[0];
        maHang = (String) data[1];
        soLuongXuat = Convert.ToInt((String) data[2]);
        donGia = Convert.ToInt((String) data[3]);
    }
     @Override
    public void createDataModel() {
        super.createDataModel(); //To change body of generated methods, choose Tools | Templates.
        Object[] data = {maHang, soLuongXuat, donGia};
        DataManager datamanager = new DataManager(soPhieuXuat, data);
        setDataModel(datamanager);
    }

    @Override
    public void enableInput() {
        super.enableInput(); //To change body of generated methods, choose Tools | Templates.
       // view.getTfSoPhieuXuat().enable(true);
        view.getTfMaHang().enable(true);
        view.getTfSoLuongXuat().enable(true);
        view.getTfDonGia().enable(true);
    }

    @Override
    public void unenableInput() {
        super.unenableInput(); //To change body of generated methods, choose Tools | Templates.
        view.getTfSoPhieuXuat().enable(false);
        view.getTfMaHang().enable(false);
        view.getTfSoLuongXuat().enable(false);
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
