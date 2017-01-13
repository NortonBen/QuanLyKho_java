
package Controller;

import View.MainView;
import java.awt.event.ActionEvent;



public class MainController extends AbstractController {

    // Attribuse MCV
    MainView view;
    HangHoaController hanghoa;
    KhachHangController khachhang;
    NhaCungCapController nhacungcap;
    PhieuNhapController phieuNhapController;
    PhieuXuatController phieuXuatController;
    ThongKeNhapController thongKeNhapController;
    ThongKeXuatController thongKeXuatController;
    ThongKeTonController thongKeTonController;

    @Override
    public void init() {
        view = new MainView();
        view.show();
        setDesktop(view.getPanelshow());
        getEvent();
    }
     

    @Override
    public void getData() {
    }

    @Override
    public void setData() {
    }

    public void getEvent() {
        view.getMiHangHoa().addActionListener(this);
        view.getMiKhachHang().addActionListener(this);
        view.getMiNhaCungCap().addActionListener(this);
        view.getMiThongKeNhap().addActionListener(this);
        view.getMiThongKeTon().addActionListener(this);
        view.getMiThongKeXuat().addActionListener(this);
        view.getMiTheoDoiNhap().addActionListener(this);
        view.getMiTheoDoiXuat().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == view.getMiHangHoa()) {
            hanghoa = new HangHoaController();
            hanghoa.setDesktop(desktop);
            hanghoa.show();
        }
        if (ae.getSource() == view.getMiKhachHang()) {
            khachhang = new KhachHangController();
            khachhang.setDesktop(desktop);
            khachhang.show();
        }
        if (ae.getSource() == view.getMiNhaCungCap()) {
            nhacungcap = new NhaCungCapController();
            nhacungcap.setDesktop(desktop);
            nhacungcap.show();
        }
        if (ae.getSource() == view.getMiTheoDoiNhap()) {
            phieuNhapController = new PhieuNhapController();
            phieuNhapController.setDesktop(desktop);
            phieuNhapController.show();

        }
        if (ae.getSource() == view.getMiTheoDoiXuat()) {
            phieuXuatController = new PhieuXuatController();
            phieuXuatController.setDesktop(desktop);
            phieuXuatController.show();

        }
        if (ae.getSource() == view.getMiThongKeNhap()) {
            thongKeNhapController = new ThongKeNhapController();
            thongKeNhapController.setDesktop(desktop);
            thongKeNhapController.show();
        }
        if (ae.getSource() == view.getMiThongKeTon()) {
            thongKeTonController = new ThongKeTonController();
            thongKeTonController.setDesktop(desktop);
            thongKeTonController.show();
        }
        if (ae.getSource() == view.getMiThongKeXuat()) {
            thongKeXuatController = new ThongKeXuatController();
            thongKeXuatController.setDesktop(desktop);
            thongKeXuatController.show();
        }
    }

  

}
