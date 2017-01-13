
package Libary;

import Controller.MainController;

public class CheckLogin{
    private boolean islogin;

    public CheckLogin() {
        islogin = false;
        
    }
    
    public void dangnhap(){
        islogin = true;
        MainController main = new MainController();
    }
    
}
