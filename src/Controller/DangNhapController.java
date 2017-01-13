
package Controller;

import java.awt.event.ActionEvent;
import view.Dang_Nhap;
import Model.DangNhapModel;
import Libary.CheckLogin;


public class DangNhapController extends AbstractController {

    // Attribute MVC
    public DangNhapModel model;
    public Dang_Nhap view;
    public CheckLogin check;
    // Attribute data
    public String user;
    public String pass;

    public DangNhapController(CheckLogin check) {
        super();
        this.check = check;
    }

    @Override
    public void init() {
        model = new DangNhapModel();
        view = new Dang_Nhap();
        view.show();
        view.getTBdangnhap().addActionListener(this);
        view.getBtnhuy().addActionListener(this);
        view.getError().setText(null);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == view.getBtnhuy()) {
            view.dispose();
            System.exit(0);
        }
        if (ae.getSource() == view.getTBdangnhap()) {
            checkdangnhap();
        }
        
    }

    public void checkdangnhap() {
        getData();
        if (user.trim() != null) {
            if (pass.trim() != null) {
                if (model.CheckDangNhap(user, pass)) {
                    dangnhap();

                } else {
                    view.getError().setText("Username hoac Password sai!");
                }
            } else {
                view.getError().setText("Ban chua nhap password!");
            }
        } else {
            view.getError().setText("Ban chua nhap username!");
        }
    }

    public void dangnhap() {
        check.dangnhap();
        view.dispose();
    }

    @Override
    public void getData() {
        user = view.getUsername().getText();
        pass = view.getPassWord().getText();
    }

    @Override
    public void setData() {
        view.getTfuser().setText(user);
        view.getTfpassword().setText(pass);
    }
      @Override
    public void eventSelect() {
        super.eventSelect(); //To change body of generated methods, choose Tools | Templates.
        Object[] data = getDataInRow();
        user =  (String) data[0];
        pass = (String) data[1];
        
    }

    @Override
    public void enableInput() {
        super.enableInput(); //To change body of generated methods, choose Tools | Templates.
        view.getTfuser().enable(true);
        view.getTfpassword().enable(true);
        
    }

    @Override
    public void unenableInput() {
        super.unenableInput(); //To change body of generated methods, choose Tools | Templates.
        view.getTfuser().enable(false);
        view.getTfpassword().enable(false);
       
    }
    

}
