package model;
import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

public class MyTableModel extends AbstractTableModel {
    private ArrayList<Seaport> ports;
    private ArrayList<Ship> ships;
    private int mode;
    private String[] headers;

    public MyTableModel(ArrayList<Seaport> ports) {
        this.ports = ports;
        mode = 1;
    }

    public MyTableModel(Seaport port){
        this.ships = port.getShips();
        mode = 2;
    }

    public void setHeaders(String[] headers) {
        this.headers = headers;
    }

    @Override
    public int getRowCount() {
        int count = 0;
        switch (mode) {
            case 1:
                count = ports.size();
                break;
            case 2:
                count = ships.size();
            default:
                break;
        }
        return count;
    }

    @Override
    public int getColumnCount() {
        return headers.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        if(mode == 1){
            switch (columnIndex) {
                case 0: return ports.get(rowIndex).getName();
                case 1: return ports.get(rowIndex).getSize();
                default: return "";
            }
        }
        if (mode == 2){
            switch (columnIndex) {
                case 0: return ships.get(rowIndex).getName();
                case 1: return ships.get(rowIndex).getType();
                default: return "";
            }
        }
        else{
            return "";
        }
    }

    @Override
    public String getColumnName(int column) {
        return headers[column];
    }

}
