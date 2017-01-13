
package Libary;

import javax.swing.JButton;
import javax.swing.JTable;


public interface InterfaceCustomManager {

    enum State {
        undefine,
        none,
        edit,
        add
    }

    public void show();

    public void initManager();

    public void setButton(JButton btnAdd, JButton btnEdit, JButton btnSave, JButton btnDelete,JButton btncancel, JButton btnexit);

    public void addActionButton();

    public void setTable(JTable table);

    public void actionAdd();

    public void actionEdit();

    public void actionSave();

    public void actionDelete();
    
    public void actioncancel();
    
    public void actionexit();

    public void nullInput();

    public void enableInput();

    public void unenableInput();
}
