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

        this.addPortWindow.addButton(e -> {
            String name = this.addPortWindow.getName();
            ports.add(new Seaport(name));
            portsTableModel.fireTableDataChanged();
            // if(this.ports.size() > 0){
            //     this.portsWindow.makeEnterEnabled(true);
            // }
            // else this.portsWindow.makeEnterEnabled(false);
        });

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

        this.portsWindow.enterButton(e -> {
            int row = this.portsWindow.getSelectedRow();
            seaport = ports.get(row);
            shipsTableModel = new MyTableModel(seaport);
            shipsTableModel.setHeaders(shipHeaders);
            this.shipsWindow.setTableModel(shipsTableModel);
        });

        this.addShipWindow.addButton(e -> {
            if(this.addShipWindow.getName().isEmpty()){
                JOptionPane.showMessageDialog(this.addShipWindow, "Введите имя");
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
            }
        });

        this.portsWindow.tableListener(e -> {
            if(this.portsWindow.getSelectedRow() > -1){
                this.portsWindow.makeEnterEnabled(true);
            }
            else this.portsWindow.makeEnterEnabled(false);

        });


    }
}
