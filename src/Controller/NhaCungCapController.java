
package Controller;


import Libary.DataManager;
import View.NhaCungCapView;
import Model.NhaCungCapModel;


public class NhaCungCapController extends AbstractController {

    //Attribute MVC
   
    NhaCungCapView view ;
    NhaCungCapModel model;
    //Attribute data
    public String maNCC ;
    public String tenNCC ;
    public String diaChi ;
    public String soDienThoai ;
    
    

    @Override
    public void init() {
        model = new NhaCungCapModel();
        setModel( model);
        view = new NhaCungCapView();
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
        maNCC = view.getTfMaNCC().getText();
        tenNCC = view.getTfTenNCC().getText();
        diaChi = view.getTfDiaChi().getText();
        soDienThoai = view.getTfSoDienThoai().getText();
    }

    @Override
    public void setData() {
        view.getTfMaNCC().setText(maNCC);
        view.getTfTenNCC().setText(tenNCC);
        view.getTfDiaChi().setText(diaChi);
        view.getTfSoDienThoai().setText(soDienThoai);
    }

    @Override
    public void nullInput() {
        super.nullInput(); //To change body of generated methods, choose Tools | Templates.
        view.getTfMaNCC().setText(null);
        view.getTfTenNCC().setText(null);
        view.getTfDiaChi().setText(null);
        view.getTfSoDienThoai().setText(null);
    }
     @Override
    public void createDataModel() {
        super.createDataModel(); //To change body of generated methods, choose Tools | Templates.
        Object[] data = {tenNCC,diaChi,soDienThoai};
        DataManager dataManager = new DataManager(maNCC, data);
        setDataModel(dataManager);
    }
    

    @Override
    public void eventSelect() {
        super.eventSelect(); //To change body of generated methods, choose Tools | Templates.
        Object[] data = getDataInRow();
        maNCC =  (String) data[0];
        tenNCC = (String) data[1];
        diaChi = (String) data[2];
        soDienThoai = (String) data[3];
    }

    @Override
    public void enableInput() {
        super.enableInput(); //To change body of generated methods, choose Tools | Templates.
        view.getTfMaNCC().enable(true);
        view.getTfTenNCC().enable(true);
        view.getTfDiaChi().enable(true);
        view.getTfSoDienThoai().enable(true);
    }

    @Override
    public void unenableInput() {
        super.unenableInput(); //To change body of generated methods, choose Tools | Templates.
        view.getTfMaNCC().enable(false);
        view.getTfTenNCC().enable(false);
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
