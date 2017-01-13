package Main;


import Controller.DangNhapController;
import Libary.CheckLogin;

public class App {
    public static void main(String[] args) {
        CheckLogin check = new CheckLogin();
        DangNhapController dn = new DangNhapController(check);
    }
}
