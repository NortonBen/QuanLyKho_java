
package Controller;

import Model.HangHoaModel;
import View.HangHoaView;
import Libary.Convert;
import Libary.CustomTableModel;
import Libary.DataManager;
import Model.Model;


public class HangHoaController extends AbstractController {

    // Attribute MVC
    public HangHoaView view;
    public HangHoaModel model;
    // Attribute data
    public String maHang;
    public String tenHang;
    public int soLuong;
    public String donViTinh;
    public int donGia;
    //
    public CustomTableModel modeltable;

    @Override
    public void init() {
        model = new HangHoaModel();
        view = new HangHoaView();
        setModel((Model) model);
        setView(view);
        setButton(view.getBtnThem(), view.getBtnSua(),view.getBtnLuu(), view.getBtnXoa(),view.getBtnHuy(),view.getBtnThoat());
        setTable(view.getTable());
        setSearch(view.getBtnSearch());
        addActionButton();
        addActionSelectRow();
        initManager();
    }

    @Override
    public void getData() {
        maHang = view.getTfMaHang().getText();
        tenHang = view.getTfTenHang().getText();
        donViTinh = view.getTfDonViTinh().getText();
        donGia = Convert.ToInt(view.getTfDonGia().getText());
        soLuong = Convert.ToInt(view.getTfSoLuong().getText());
    }


    @Override
    public void setData() {
        view.getTfMaHang().setText(maHang);
        view.getTfTenHang().setText(tenHang);
        view.getTfDonViTinh().setText(donViTinh);
        view.getTfDonGia().setText(Convert.toString(donGia));
        view.getTfSoLuong().setText(Convert.toString(soLuong));
    }

    @Override
    public void nullInput() {
        super.nullInput(); //To change body of generated methods, choose Tools | Templates.
        view.getTfMaHang().setText(null);
        view.getTfTenHang().setText(null);
        view.getTfDonViTinh().setText(null);
        view.getTfSoLuong().setText(null);
        view.getTfDonGia().setText(null);

    }

    @Override
    public void eventSelect() {
        super.eventSelect(); //To change body of generated methods, choose Tools | Templates.
        Object[] data = getDataInRow();
        maHang = (String) data[0];
        tenHang = (String) data[1];
        donViTinh = (String) data[3];
        soLuong = (int)data[2];
        donGia = (int) data[4];
    }

    @Override
    public void createDataModel() {
        super.createDataModel(); //To change body of generated methods, choose Tools | Templates.
        Object[] data = {tenHang,  donViTinh,soLuong, donGia};
        DataManager datamanager = new DataManager(maHang, data);
        setDataModel(datamanager);
    }

    @Override
    public void enableInput() {
        super.enableInput(); //To change body of generated methods, choose Tools | Templates.
        view.getTfMaHang().enable(true);
        view.getTfTenHang().enable(true);
        view.getTfDonViTinh().enable(true);
        view.getTfSoLuong().enable(true);
        view.getTfDonGia().enable(true);

    }

    @Override
    public void unenableInput() {
        super.unenableInput(); //To change body of generated methods, choose Tools | Templates.
        view.getTfMaHang().enable(false);
        view.getTfTenHang().enable(false);
        view.getTfDonViTinh().enable(false);
        view.getTfSoLuong().enable(false);
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
     @Override
    public String createSearch() {
        return view.getTxtSearch().getText();
    }
    
}
