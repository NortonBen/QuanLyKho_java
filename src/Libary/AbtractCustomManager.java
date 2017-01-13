
package Libary;

import Model.Model;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyVetoException;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import java.sql.ResultSet;
import javax.swing.JInternalFrame;
import javax.swing.JTextField;


public abstract class AbtractCustomManager implements InterfaceCustomManager, ActionListener {

    protected JDesktopPane desktop;
    // Attribuse Model
    protected Model model;
    Object[] namecolum;
    // State 
    State state;
    boolean exce = false;
    //Attribuse 
    JButton btnAdd;
    JButton btnEdit;
    JButton btnSave;
    JButton btnDelete;
    JTable table;
    JButton btncancel;
    JButton btnexit;
    JButton btnOK;
    
    CustomTableModel modeltable;
    DataManager dataModel;
    JInternalFrame _view;

    JButton btnsearch;
    @Override
    public void initManager() {
        state = State.undefine;
        actionG3();
        unenableInput();
    }

    public AbtractCustomManager() {
    }
    
    public  void setEXCE(){
        exce= true;
    }

    @Override
    public void show() {

        _view.setVisible(true);
        desktop.add(_view);
        try {
            _view.setSelected(true);
        } catch (PropertyVetoException ex) {
            System.out.println("loi show view: " + ex);
        }
    }

    public void setView(Object view) {
        this._view = (JInternalFrame) view;
    }

    public void setDesktop(JDesktopPane desktop) {
        this.desktop = desktop;
    }

    @Override
    public void setButton(JButton btnAdd, JButton btnEdit, JButton btnSave, JButton btnDelete, JButton btncancel, JButton btnexit) {
        this.btnAdd = btnAdd;
        this.btnEdit = btnEdit;
        this.btnSave = btnSave;
        this.btnDelete = btnDelete;
        this.btncancel = btncancel;
        this.btnexit = btnexit;
        this.btnOK =btnOK;
      
      
    }
    
    public void setSearch(JButton jButton){
        this.btnsearch = jButton;
        this.btnsearch.addActionListener(this);
    }

    @Override
    public void addActionButton() {
        if(btnAdd != null){
            btnAdd.addActionListener(this);
            btnEdit.addActionListener(this);
            btnSave.addActionListener(this);
            btnDelete.addActionListener(this);
            btncancel.addActionListener(this);
            
        }
        btnexit.addActionListener(this);
    
    }

    public void addActionSelectRow() {
        table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent lse) {
                if (state == State.undefine) {
                    state = State.none;
                }
                eventSelect();
                if (state == State.none) {
                    EventStateNone();
                }
            }
        });
    }

    public void setModel(Model model) {
        this.model = model;
    }

    public void EventStateNone() {

    }

    public void setDataModel(DataManager dataModel) {
        this.dataModel = dataModel;
    }

    public void createDataModel() {

    }

    public void eventSelect() {

    }

    public Object[] getDataInRow() {
        Object[] data = null;
        int row = table.getSelectedRow();
        int CCol = table.getColumnCount();
        data = new Object[CCol];
        for (int i = 0; i < CCol; i++) {
            data[i] = table.getValueAt(row, i);
        }
        return data;
    }

    @Override
    public void setTable(JTable table) {
        this.table = table;
        DefaultTableModel Dmodeltable = (DefaultTableModel) table.getModel();
        createModelTable(Dmodeltable);
        namecolum = modeltable.ColumeName;
        ResultSet rs = null;
        if(exce){
            createDataModel();
            if(dataModel.id== null){
                return;
            }
            rs = model.getid(dataModel);
        }else{
        
             rs = model.getData();
        }
        modeltable.setTable(rs);
        modeltable.ColumeName = namecolum;
        table.setModel(modeltable);
        table.revalidate();
        
    }

    public void createModelTable(DefaultTableModel model) {
        modeltable = new CustomTableModel();
        modeltable.ApdapterDefaultTableModel(model);
    }

    public void LoadDataToTable() {
        ResultSet rs = model.getData();
        modeltable.setTable(rs);
        table.setModel(modeltable);
        table.revalidate();
    }

    @Override
    public void actionAdd() {
        beforeActionAdd();
        afterActionAdd();
    }
   

    @Override
    public void actionEdit() {
        beforeActionEdit();
        afterActionEdit();
    }

    @Override
    public void actionSave() {
        beforeActionSave();
        createDataModel();
        afterActionSave();
    }

    @Override
    public void actionDelete() {
        createDataModel();

        beforeActionDelete();
        afterActionDelete();
    }

    public void beforeActionSave() {
        actionG2();
        loaddata();
    }
    
    public void loaddata(){
        
    }

    public void beforeActionDelete() {
        if (state == State.none) {
            model._add_old(dataModel);
            model.delete(dataModel);
        }
        actionG2();
    }

    public void beforeActionAdd() {
        if (state == State.none) {
            actionG1();
            nullInput();
        }
    }

    public void afterActionAdd() {
    }

    public void afterActionDelete() {
        LoadDataToTable();
    }

    public void afterActionSave() {
        if (state == State.add) {
            model._add_old(dataModel);
            model.insert(dataModel);
        }
        if (state == State.edit) {
            model.update(dataModel);
        }
        nullInput();
        actionG2();
        LoadDataToTable();
    }

    public void afterActionEdit() {
    }

    public void beforeActionEdit() {
        if (state == State.none) {
            actionG1();
            enableInput();
        }
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == btnAdd) {
            enableInput();
            actionAdd();
            state = State.add;
        }
        if (ae.getSource() == btnEdit) {
            enableInput();
            actionEdit();
            state = State.edit;
        }
        if (ae.getSource() == btnSave) {
            unenableInput();
            actionSave();
            state = State.none;
        }
        if (ae.getSource() == btnDelete) {
            unenableInput();
            actionDelete();
            state = State.none;
        }
        if (ae.getSource() == btncancel) {
            unenableInput();
            actioncancel();
            state = State.none;
        }
        if (ae.getSource() == btnexit) {
            unenableInput();
            actionexit();
            state = State.none;
        }
        if (ae.getSource() == btnsearch) {
            unenableInput();
            nullInput();
            actionSearch();
            state = State.none;
        }
        reloadview();
        if (ae.getSource() == thongke) {
            String text= this.thang.getText();//+"/"+nam.getText();
            thongke(text);
        }
    }
    
    public void actionSearch(){
        String text = createSearch();
        ResultSet rs = model.Search(text);
        modeltable.setTable(rs);
        table.setModel(modeltable);
        table.revalidate();
    }
    
    public String createSearch(){
        return  null;
    }

    public void reloadview(){
        
    }
    @Override
    public void nullInput() {
    }

    @Override
    public void enableInput() {
    }

    @Override
    public void unenableInput() {
    }

    public void actionG1() {
        btnAdd.enable(false);
        btnEdit.enable(false);
        btnDelete.enable(true);
        btnSave.enable(true);
    }

    public void actionG2() {
        btnAdd.enable(true);
        btnEdit.enable(true);
        btnDelete.enable(true);
        btnSave.enable(false);
    }

    public void actionG3() {
        btnAdd.enable(true);
        btnEdit.enable(false);
        btnDelete.enable(false);
        btnSave.enable(false);
    }

    public void actioncancel() {
        if (state != State.none) {
            unenableInput();
            nullInput();
            state = State.undefine;
        }

    }

    public void actionexit() {

    }
    
    public void thongke(String data){
        ResultSet rs = model.Thongke(data);
        modeltable.setTable(rs);
        table.setModel(modeltable);
        table.revalidate();
    }
    
    JTextField thang;
    JTextField nam;
    JButton thongke;
    public void setThongke(JButton ok,JTextField thang, JTextField nam){
        this.thongke = ok;
        this.thang = thang;
        this.nam = nam;
        this.thongke.addActionListener(this);
        
    }
}
