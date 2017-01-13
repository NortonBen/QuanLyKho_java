
package Libary;

import javax.swing.JOptionPane;
import Model.Database;


public abstract class AbtractModelManager extends Database implements InterfaceModelManager {

    protected String table =  null;
    protected DataManager _data_old;

    @Override
    public void setTable(String table) {
        this.table = table;
    }

    public AbtractModelManager() {
        init();
    }

    public void _add_old(DataManager data) {
        this._data_old = data;
    }

    @Override
    public void viewMesenger(boolean is) {
        if (is) {
            JOptionPane.showMessageDialog(null, "Thanh cong!", "Thong bao", 1);
        } else {
            JOptionPane.showMessageDialog(null, "Loi ket noi!", "Thong bao", 0);
        }
    }

    @Override
    public void viewMesenger(boolean is, String msg) {
        if (is) {
            JOptionPane.showMessageDialog(null, msg, "Thong bao", 1);
        } else {
            JOptionPane.showMessageDialog(null, msg, "Thong bao", 0);
        }
    }

}
