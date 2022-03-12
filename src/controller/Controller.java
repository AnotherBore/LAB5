package controller;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import model.Icebreaker;
import model.MyTableModel;
import model.Sailboat;
import model.Seaport;
import model.Ship;
import model.Steamboat;
import view.*;

public class Controller {
    private ArrayList<Seaport> ports;
    private Seaport seaport;
    private PortsWindow portsWindow;
    private ShipsWindow shipsWindow;
    private AddPortWindow addPortWindow;
    private AddShipWindow addShipWindow;
    private MyTableModel shipsTableModel;

    public Controller(PortsWindow portsWindow, ShipsWindow shipsWindow, AddPortWindow addPortWindow, AddShipWindow addShipWindow) {
        ports = new ArrayList<>();
        seaport = new Seaport("Default");
        this.portsWindow = portsWindow;
        this.shipsWindow = shipsWindow;
        this.addPortWindow = addPortWindow;
        this.addShipWindow = addShipWindow;
        String[] portHeaders = {"Имя", "Количество кораблей"};
        String[] shipHeaders = {"Имя", "Тип"};
        MyTableModel portsTableModel = new MyTableModel(ports);
        shipsTableModel = new MyTableModel(seaport);

        portsTableModel.setHeaders(portHeaders);
        this.portsWindow.setTableModel(portsTableModel);

        //ACTIONLISTENERS FOR ADDPORTWINDOW

        this.addPortWindow.addButton(e -> {
            String name = this.addPortWindow.getName();
            ports.add(new Seaport(name));
            portsTableModel.fireTableDataChanged();
            this.addPortWindow.reset();
        });

        //ACTIONLISTENERS FOR ADDSHIPWINDOW

        this.addShipWindow.chooseComboBox(e -> {
            int item = this.addShipWindow.getSelectedIndex();
            if(item == 0){
                this.addShipWindow.setLabel_differenceText("Введите максимальную скорость на льду (км/ ч)");
            }
            else if(item == 1){
                this.addShipWindow.setLabel_differenceText("Введите высоту мачты (метров)");
            }
            else if(item == 2){
                this.addShipWindow.setLabel_differenceText("Введите мощность двигателей (л. с.)");
            }
        });

        this.addShipWindow.addButton(e -> {
            if(this.addShipWindow.getName().isEmpty()){
                JOptionPane.showMessageDialog(this.addShipWindow, "Введите название");
            }
            else{
                String name = this.addShipWindow.getName();
                int speed = this.addShipWindow.getMaxSpeed();
                int displacement = this.addShipWindow.getDisplacement();
                int difference = this.addShipWindow.getDifference();
                String type = this.addShipWindow.getType();
                if(type.equals("Ледокол")){
                    seaport.add(new Icebreaker(name, speed, displacement, difference));
                }
                else if(type.equals("Парусник")){
                    seaport.add(new Sailboat(name, speed, displacement, difference));
                }
                else{
                    seaport.add(new Steamboat(name, speed, displacement, difference));
                }
                shipsTableModel.fireTableDataChanged();
                this.addShipWindow.reset();
            }
        });

        //ACTIONLISTENERS FOR PORTSWINDOW

        this.portsWindow.enterButton(e -> {
            int row = this.portsWindow.getSelectedRow();
            seaport = ports.get(row);
            shipsTableModel = new MyTableModel(seaport);
            shipsTableModel.setHeaders(shipHeaders);
            this.shipsWindow.setTableModel(shipsTableModel);
        });

        this.portsWindow.tableListener(e -> {
            if(this.portsWindow.getSelectedRow() > -1){
                this.portsWindow.makeEnterEnabled(true);
                this.portsWindow.makeDeleteEnabled(true);
            }
            else{
                this.portsWindow.makeEnterEnabled(false);
                this.portsWindow.makeDeleteEnabled(false);
            }
        });

        this.portsWindow.deleteButton(e -> {
            int row = this.portsWindow.getSelectedRow();
            ports.remove(row);
            portsTableModel.fireTableDataChanged();
        });

        //ACTIONLISTENERS FOR SHIPSWINDOW

        this.shipsWindow.tableListener(e -> {
            if(this.shipsWindow.getSelectedRow() > -1){
                this.shipsWindow.makeInfoEnabled(true);
                this.shipsWindow.makeDeleteEnabled(true);
            }
            else{
                this.shipsWindow.makeInfoEnabled(false);
                this.shipsWindow.makeDeleteEnabled(false);
            }
        });

        this.shipsWindow.deleteButton(e -> {
            int row = this.shipsWindow.getSelectedRow();
            seaport.delete(row);
            shipsTableModel.fireTableDataChanged();
        });

        this.shipsWindow.infoButton(e -> {
            int row = this.shipsWindow.getSelectedRow();
            Ship ship = seaport.get(row);
            String info = ship.getAbout();
            JOptionPane.showMessageDialog(this.shipsWindow, info);
        });
    }
}
