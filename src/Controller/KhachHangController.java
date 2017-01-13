
package Controller;
import Libary.DataManager;
import View.KhachHangView;
import Model.KhachHangModel;



public class KhachHangController extends AbstractController{

    
    //Attribute MVC
    KhachHangView view;
    KhachHangModel model;
    //Attribute data
    public String maKhach;
    public String tenKhach;
    public String diaChi;
    public String soDienThoai;
    @Override
    public void init() {
        model = new KhachHangModel();
        setModel(model);
        view = new KhachHangView();
        setView(view);
        setButton(view.getBtnThem(), view.getBtnSua(), view.getBtnLuu(), view.getBtnXoa(),view.getBtnHuy(),view.getBtnThoat());
        setTable(view.getTable());
        setSearch(view.getBtnSearch());
        addActionButton();
        addActionSelectRow();
        initManager();
    }

    @Override
    public void getData() {
        maKhach = view.getTfMaKhach().getText();
        tenKhach = view.getTfTenKhach().getText();
        diaChi = view.getTfDiaChi().getText();
        soDienThoai = view.getTfSoDienThoai().getText();
    }

    @Override
    public void setData() {
        view.getTfMaKhach().setText(maKhach);
        view.getTfTenKhach().setText(tenKhach);
        view.getTfDiaChi().setText(diaChi);
        view.getTfSoDienThoai().setText(soDienThoai);
    }

    @Override
    public void nullInput() {
        super.nullInput(); //To change body of generated methods, choose Tools | Templates.
        view.getTfMaKhach().setText(null);
        view.getTfTenKhach().setText(null);
        view.getTfDiaChi().setText(null);
        view.getTfSoDienThoai().setText(null);
    }



    @Override
    public void createDataModel() {
        super.createDataModel(); //To change body of generated methods, choose Tools | Templates.
        Object[] data = {tenKhach,diaChi,soDienThoai};
        DataManager dataManager = new DataManager(maKhach, data);
        setDataModel(dataManager);
    }

    @Override
    public void eventSelect() {
        super.eventSelect(); //To change body of generated methods, choose Tools | Templates.
        Object[] data = getDataInRow();
        maKhach =  (String) data[0];
        tenKhach = (String) data[1];
        diaChi = (String) data[2];
        soDienThoai = (String) data[3];    
    }

    @Override
    public void enableInput() {
        super.enableInput(); //To change body of generated methods, choose Tools | Templates.
        view.getTfMaKhach().enable(true);
        view.getTfTenKhach().enable(true);
        view.getTfDiaChi().enable(true);
        view.getTfSoDienThoai().enable(true);
    
    }

    @Override
    public void unenableInput() {
        super.unenableInput(); //To change body of generated methods, choose Tools | Templates.
        view.getTfMaKhach().enable(false);
        view.getTfTenKhach().enable(false);
        view.getTfDiaChi().enable(false);
        view.getTfSoDienThoai().enable(false);
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
