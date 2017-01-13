
package Libary;

import javax.swing.table.AbstractTableModel;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

public class CustomTableModel extends AbstractTableModel {

    public Object[] ColumeName;
    public Object[][] Data;

    public CustomTableModel(Object[] ColumeName, Object[][] Data) {
        this.ColumeName = ColumeName;
        this.Data = Data;
    }

    public CustomTableModel() {
    }

    public void setData(Object[][] Data) {
        this.Data = Data;
    }

    public Object[][] getData() {
        return Data;
    }

    public void setColumeName(Object[] ColumeName) {
        this.ColumeName = ColumeName;
    }

    public Object[] getColumeName() {
        return ColumeName;
    }

    @Override
    public void setValueAt(Object o, int i, int i1) {
        if (Data.length >= i) {
            if (Data[0].length >= i1) {
                Data[i][i1] = o;
            }
        }
    }

    public void ApdapterDefaultTableModel(DefaultTableModel model) {
        int colum = model.getColumnCount();
        int row = model.getRowCount();
        Data = new Object[row][colum];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < colum; j++) {
                Data[i][j] = model.getValueAt(i, j);
            }
        }
        ColumeName = new Object[colum];
        for (int i = 0; i < colum; i++) {
            ColumeName[i] = model.getColumnName(i);
        }
    }

    public CustomTableModel(ResultSet rs) {
        try {
            ResultSetMetaData mt = rs.getMetaData();
            int Ccol = mt.getColumnCount();
            this.ColumeName = new Object[Ccol];
            ArrayList<Object[]> datas = new ArrayList<Object[]>();
            for (int i = 1; i <= Ccol; i++) {
                ColumeName[i - 1] = mt.getColumnName(i);
            }
            while (rs.next()) {
                Object[] data = new Object[Ccol];
                for (int j = 1; j <= Ccol; j++) {
                    data[j - 1] = rs.getObject(j);
                }
                datas.add(data);
            }
            int cout = datas.size();
            Data = new Object[cout][Ccol];
            for (int i = 0; i < cout; i++) {
                Data[i] = datas.get(i);
            }
            //Data = (Object[][]) datas.toArray();
        } catch (SQLException ex) {
            System.out.println("loi get data: " + ex);
        }
    }

    public void setTable(ResultSet rs) {
        try {
            ResultSetMetaData mt = rs.getMetaData();
            int Ccol = mt.getColumnCount();
//            this.ColumeName = new Object[Ccol];
//            for(int i =1 ; i <= Ccol ; i++){
//                ColumeName[i-1] = mt.getColumnName(i);
//            }
            ArrayList<Object[]> datas = new ArrayList<Object[]>();
            while (rs.next()) {
                Object[] data = new Object[Ccol];
                for (int j = 1; j <= Ccol; j++) {
                    data[j - 1] = rs.getObject(j);
                }
                datas.add(data);
            }
            int cout = datas.size();
            Data = new Object[cout][Ccol];
            for (int i = 0; i < cout; i++) {
                Data[i] = datas.get(i);
            }
            //Data = (Object[][]) datas.toArray();
        } catch (SQLException ex) {
            System.out.println("loi get data: " + ex);
        }
    }

    @Override
    public int getRowCount() {
        return Data.length;
    }

    @Override
    public int getColumnCount() {
        if (Data.length > 0) {
            return Data[0].length;
        }
        return 0;
    }

    @Override
    public Object getValueAt(int i, int j) {
        return Data[i][j];
    }

    public void setValueAt(int row, int colume, Object data) {
        Data[row][colume] = data;
    }

    @Override
    public String getColumnName(int i) {
        return (String) ColumeName[i];
    }

}
